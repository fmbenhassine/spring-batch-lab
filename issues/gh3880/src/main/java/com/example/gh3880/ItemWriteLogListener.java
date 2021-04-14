package com.example.gh3880;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

class ItemWriteLogListener implements ItemWriteListener<Person> {

		@Override
		public void beforeWrite(List<? extends Person> items) {
			System.out.println("ItemWriteLogListener.beforeWrite" + items);
		}

		@Override
		public void afterWrite(List<? extends Person> items) {
			System.out.println("ItemWriteLogListener.afterWrite" + items);
		}

		@Override
		public void onWriteError(Exception exception, List<? extends Person> items) {
			System.out.println("ItemWriteLogListener.onWriteError" + exception.getMessage());
		}
	}