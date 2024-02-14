package com.todo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo.model.Todo;
import com.todo.rowMapper.TodoRowMapper;

public class TodoDao {

	private JdbcTemplate jdbcTemplate;

	public TodoDao() {

	}

	public boolean insertTodo(Todo todo) {
		String query = "insert into todos(todo_name, todo_description, created_time, due_time) values(?,?,?,?)";
		int r = this.jdbcTemplate.update(query, todo.getTodoName(), todo.getTodoDescription(), todo.getCreatedTime(),
				todo.getDueTime());

		return r > 0 ? true : false;
	}

	public List<Todo> getAllTodos(){
		String sql = "select * from todos";
		List<Todo> todos = this.jdbcTemplate.query(sql, new TodoRowMapper());
		return todos;
	}
	
	public boolean update(Todo todo) {
		String query = "update todos set todo_name=?, todo_description=?,due_time=? where todo_id=?";
		int r = this.jdbcTemplate.update(query, todo.getTodoName(), todo.getTodoDescription(), todo.getDueTime(), todo.getTodoId());
		return r > 0 ? true : false;
	}

	public boolean delete(int id) {
		 String query = "Delete from todos where todo_id=?";
		 int r = this.jdbcTemplate.update(query, id);
		 return r > 0 ? true : false;
	}
	
	public boolean deleteAll() {
		 String query = "Delete from todos";
		 int r = this.jdbcTemplate.update(query);
		 return r > 0 ? true : false;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
