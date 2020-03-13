package com.example.demo;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class MyChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext chunkContext) {
		System.out.println("MyChunkListener.beforeChunk");
	}

	@Override
	public void afterChunk(ChunkContext chunkContext) {
		System.out.println("MyChunkListener.afterChunk");
	}

	@Override
	public void afterChunkError(ChunkContext chunkContext) {

	}
}
