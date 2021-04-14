package com.example.gh3880;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

class LogChunkListener implements ChunkListener {

		@Override
		public void beforeChunk(ChunkContext context) {
			System.out.println("LogChunkListener.beforeChunk");
		}

		@Override
		public void afterChunk(ChunkContext context) {
			System.out.println("LogChunkListener.afterChunk");
		}

		@Override
		public void afterChunkError(ChunkContext context) {
			System.out.println("LogChunkListener.afterChunkError");
		}
	}