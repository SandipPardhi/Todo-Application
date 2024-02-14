package com.todo.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.todo.model.Todo;

public class TodoRowMapper implements RowMapper<Todo>{

	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Todo todo = new Todo();
		todo.setTodoId(rs.getInt("todo_id"));
		todo.setTodoName(rs.getString("todo_name"));
		todo.setTodoDescription(rs.getString("todo_description"));
		todo.setCreatedTime(rs.getTimestamp("created_time"));
		todo.setDueTime(rs.getTimestamp("due_time"));
		
		
		return todo;
	}

}
