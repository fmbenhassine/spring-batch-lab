package com.example.gh3880;

class Person {
		private final String name;

		public Person(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}