package com.todo.dto.request;

import java.sql.Timestamp;

public class TodoDto {
	private int todoId;
	private String todoName;
	private String todoDescription;
	private String createdTime;
	private String dueTime;

	public TodoDto() {

	}

	public TodoDto(String todoName, String todoDescription, String createdTime, String dueTime) {
		super();
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.createdTime = createdTime;
		this.dueTime = dueTime;
	}

	public String getTodoName() {
		return todoName;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTodoDescription() {
		return todoDescription;
	}

	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getDueTime() {
		return dueTime;
	}

	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}

}
