package com.demo;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "person")
	public class Person {

		@Id
		private int id;
		private String name;

		private Person() {
		}

		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return id == person.id &&
					Objects.equals(name, person.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, name);
		}
	}
