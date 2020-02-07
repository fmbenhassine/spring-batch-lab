package com.example.demo;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.support.SingleItemPeekableItemReader;
import org.springframework.batch.item.support.builder.SingleItemPeekableItemReaderBuilder;
import org.springframework.core.io.Resource;

public class RecipeItemReader implements ItemStreamReader<Recipe> {

	private SingleItemPeekableItemReader<String> peekableItemReader;

	public RecipeItemReader(Resource recipesFile) {
		FlatFileItemReader<String> delegate = new FlatFileItemReaderBuilder<String>()
				.name("recipeReader")
				.resource(recipesFile)
				.lineMapper(new PassThroughLineMapper())
				.build();
		peekableItemReader = new SingleItemPeekableItemReaderBuilder<String>()
				.delegate(delegate)
				.build();
	}

	// TODO quick and dirty, add sanity checks
	@Override
	public Recipe read() throws Exception {
		String line = peekableItemReader.peek();
		if (line == null) {
			return null;
		}
		Recipe recipe = new Recipe();
		if (line.startsWith("R")) {
			String name = peekableItemReader.read().substring(2);
			recipe.setName(name);
		}
		while (peekableItemReader.peek() != null && peekableItemReader.peek().startsWith("I")) {
			recipe.addIngredient(peekableItemReader.read().substring(2));
		}
		return recipe;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		peekableItemReader.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		peekableItemReader.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		peekableItemReader.close();
	}
}
