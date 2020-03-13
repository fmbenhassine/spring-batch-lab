package com.example.demo;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

class MyTasklet implements Tasklet {

		private int progress;

		@Override
		public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			RepeatStatus repeatStatus;
			if (moreWork()) {
				doSomeWork();
				repeatStatus = RepeatStatus.CONTINUABLE;
			} else {
				repeatStatus = RepeatStatus.FINISHED;
			}
			reportProgress(chunkContext);
			return repeatStatus;
		}

		private void reportProgress(ChunkContext chunkContext) {
			chunkContext.getStepContext().getStepExecution()
					.getExecutionContext().putInt("progress", this.progress++);
		}

		private void doSomeWork() throws Exception {
			Thread.sleep(5000);
			System.out.println("doing some work..");
		}

		private boolean moreWork() {
			return this.progress < 100;
		}
	}
