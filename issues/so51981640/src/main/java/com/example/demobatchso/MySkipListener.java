package com.example.demobatchso;

import org.springframework.batch.core.SkipListener;

public class MySkipListener implements SkipListener<Integer, Integer> {

		@Override
		public void onSkipInRead(Throwable t) {

		}

		@Override
		public void onSkipInWrite(Integer item, Throwable t) {

		}

		@Override
		public void onSkipInProcess(Integer item, Throwable t) {
			System.out.println("Item " + item + " was skipped due to: " + t.getMessage());
		}
	}
