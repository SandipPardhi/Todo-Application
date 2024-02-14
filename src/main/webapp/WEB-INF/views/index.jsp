<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.todo.model.Todo"%>
<%@page import="java.util.List"%>
<%@page import="com.todo.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.todo-application {
	min-height: 100vh;
	width: 100%;
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
}

.application-section {
	min-height: 255.33px;
	width: calc(50% - 12px);
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 10px 5px;
	border: 1px solid rgb(47, 207, 109);
	min-width: 300px;
}

.margin-x-auto {
	margin-left: auto;
	margin-right: auto;
}

.add-todo-form {
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 10px;
	margin-top: 30px;
}

.input-field {
	height: 35px;
	width: 200px;
	border-radius: 5px;
}

.submit-button {
	background-color: rgb(47, 207, 109);
}

.display-todo-section {
	overflow-x: scroll;
}

td, th {
	width: fit-content;
	margin: 0px 5px;
}

th {
	text-wrap: nowrap;
}

.no-wrap{
	text-wrap: nowrap;
}

.todo-list-table {
	margin-top: 30px;
	margin-bottom: 30px;
}

.response-message {
	position: fixed;
	top: 5px;
	right: 5px;
	color: red;
}

.add-todo-form-section {
	
}
</style>
</head>
<body>

	<div class="todo-application">

		
		<% 
	
		List<Todo> todos = (List<Todo>)request.getAttribute("listOfAllTodos");	
		
		String responseMessage = (String)request.getAttribute("responseMessage");
		if( responseMessage != null  ){
		
		out.println("<p class=\"response-message\">"+responseMessage+"</p>");
		}%>

		<div class="add-todo-form-section application-section">
			Add Todo Form
			<form class="margin-x-auto add-todo-form" action="addtodo"
				method="POST">
				<input class="input-field" type="text" placeholder="Enter Todo Name"
					name="todoName" /> <input class="input-field" type="text"
					placeholder="Enter Todo Description" name="todoDescription" /> <input
					class="input-field" type="datetime-local" name="dueTime" /> <input
					class="input-field submit-button" type="submit" />
			</form>
		</div>

		<div class="display-todo-section application-section">

			List All Todo

			<table class="todo-list-table">
				<tr>
					<th>ID</th>
					<th>TODO NAME</th>
					<th>DESCRIPTION</th>
					<th>Created Time</th>
					<th>DUE DATE</th>
				</tr>
				
				<%
					for(Todo todo:todos){
						out.println("<tr>"+
							"<td class='no-wrap'>"+todo.getTodoId()+"</td>"+	
							"<td class='no-wrap'>"+todo.getTodoName()+"</td>"+
							"<td>"+todo.getTodoDescription()+"</td>"+
							"<td class='no-wrap'>"+todo.getCreatedTime()+"</td>"+
							"<td class='no-wrap'>"+todo.getDueTime()+"</td>"+
							"</tr>");
					}
				
				%>
					

			</table>

		</div>

		<div class="update-todo-section application-section">
			Update Todo Form
			<form class="margin-x-auto add-todo-form" action="/todo/updatetodo"
				method="post">
				<input class="input-field" type="number" placeholder="Enter Todo ID"
					name="todoId"> 
					<input class="input-field" type="text"
					placeholder="Enter Todo Name" name="todoName" /> 
					<input
					class="input-field" type="text"
					placeholder="Enter Todo Description" name="todoDescription" /> 
					<input
					class="input-field" type="datetime-local" name="dueTime" /> 
					<input
					class="input-field submit-button" type="submit" value="Update" />
			</form>
		</div>

		<div class="delete-todo-section application-section">
			Delete Todo Form
			<form class="margin-x-auto add-todo-form" action="/todo/deletetodo"
				method="post">
				<select class="input-field" name="id" >
					<option value="" selected disabled>Select Todo</option>
					<option value="-1"> All </option>
					<% 
						for(Todo todo:todos){
							out.println("<option value='"+todo.getTodoId()+"'>"+todo.getTodoName()+"</option>");
						}	
					%>
					
				</select>
				<input class="input-field submit-button"
					type="submit" value="delete" />
			</form>
		</div>

	</div>
	<% %>

</body>
</html>
