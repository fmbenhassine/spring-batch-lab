package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

	private String name;
	private List<String> ingredients = new ArrayList<>();

	public void setName(String name) {
		this.name = name;
	}

	public void addIngredient(String ingredient) {
		this.ingredients.add(ingredient);
	}

	@Override
	public String toString() {
		return "Recipe{" +
				"name='" + name + '\'' +
				", ingredients=" + ingredients +
				'}';
	}
}
