package com.todo.model;

import java.sql.Timestamp;

public class Todo {

	private int todoId;
	private String todoName;
	private String todoDescription;
	private Timestamp createdTime;
	private Timestamp dueTime;

	public Todo() {

	}

	public Todo(int todoId, String todoName, String todoDescription, Timestamp createdTime, Timestamp dueTime) {
		this.todoId = todoId;
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.createdTime = createdTime;
		this.dueTime = dueTime;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
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

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getDueTime() {
		return dueTime;
	}

	public void setDueTime(Timestamp dueTime) {
		this.dueTime = dueTime;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoName=" + todoName + ", todoDescription=" + todoDescription
				+ ", createdTime=" + createdTime + ", dueTime=" + dueTime + "]";
	}

}
