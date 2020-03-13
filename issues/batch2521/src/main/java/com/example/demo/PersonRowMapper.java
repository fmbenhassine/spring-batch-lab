package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(resultSet.getInt(1));
		person.setName(resultSet.getString(2));
		return person;
	}

}
