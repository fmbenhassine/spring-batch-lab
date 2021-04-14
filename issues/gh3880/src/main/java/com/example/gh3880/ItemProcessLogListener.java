package com.example.gh3880;

import org.springframework.batch.core.ItemProcessListener;

class ItemProcessLogListener implements ItemProcessListener<Integer, Person> {

		@Override
		public void beforeProcess(Integer item) {
			System.out.println("ItemProcessLogListener.beforeProcess " + item);
		}

		@Override
		public void afterProcess(Integer item, Person result) {
			System.out.println("ItemProcessLogListener.afterProcess " + item + " |" + result);
		}

		@Override
		public void onProcessError(Integer item, Exception e) {
			System.out.println("ItemProcessLogListener.onProcessError" + e.getMessage());
		}
	}