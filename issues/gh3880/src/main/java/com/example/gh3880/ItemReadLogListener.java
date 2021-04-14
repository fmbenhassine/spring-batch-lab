package com.example.gh3880;

import org.springframework.batch.core.ItemReadListener;

class ItemReadLogListener implements ItemReadListener<Integer> {

		@Override
		public void beforeRead() {
			System.out.println("ItemReadLogListener.beforeRead");
		}

		@Override
		public void afterRead(Integer item) {
			System.out.println("ItemReadLogListener.afterRead " + item);
		}

		@Override
		public void onReadError(Exception ex) {
			System.out.println("ItemReadLogListener.onReadError" + ex.getMessage());
		}
	}