package com.todo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.dao.TodoDao;
import com.todo.dto.request.TodoDto;
import com.todo.model.Todo;

@Controller
public class TodoController {
	@Autowired
	private TodoDao todoDao;
	
	 private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	    public static Timestamp parseTimestamp(String timestampStr) {
	        LocalDateTime localDateTime = LocalDateTime.parse(timestampStr, formatter);
	        return Timestamp.valueOf(localDateTime);
	    }
	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("listOfAllTodos", todoDao.getAllTodos());
		return "index";
	}
	
	@PostMapping("/addtodo")
	public String addTodo(@ModelAttribute TodoDto todoDto, Model model) 
	{
		
		
		Todo todo = new Todo();
		todo.setTodoName(todoDto.getTodoName());
		todo.setTodoDescription(todoDto.getTodoDescription());
		todo.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		
		Timestamp time = parseTimestamp(todoDto.getDueTime());
		todo.setDueTime(time);
		System.out.println(todo.toString());
		
		boolean isInsertSuccess = todoDao.insertTodo(todo);
		System.out.println(isInsertSuccess);
		if(isInsertSuccess) {
			model.addAttribute("responseMessage", "Todo created successfully");
		}
		else {
			model.addAttribute("responseMessage", "Could not create todo");
		}
		
		model.addAttribute("listOfAllTodos", todoDao.getAllTodos());
		return "index";
	}
	
	
	
	@PostMapping("/updatetodo")
	public String updateTodo(@ModelAttribute TodoDto todoDto, Model model) {
		
		System.out.println(todoDto.toString());
		Todo todo = new Todo();
		todo.setTodoId(todoDto.getTodoId());
		todo.setTodoName(todoDto.getTodoName());
		todo.setTodoDescription(todoDto.getTodoDescription());		
		Timestamp time = parseTimestamp(todoDto.getDueTime());
		todo.setDueTime(time);
		System.out.println(todo.toString());
		
		boolean isUpdateSuccess = todoDao.update(todo);
		if(isUpdateSuccess) {
			model.addAttribute("responseMessage", "Todo update successfully");
		}
		else {
			model.addAttribute("responseMessage", "Could not update todo");
		}
		
		model.addAttribute("listOfAllTodos", todoDao.getAllTodos());
		return "index";

		}
	
	@PostMapping("/deletetodo")
	public String delete(@RequestParam("id") int id, Model model) {
		boolean isDeleteSuccess;
		if(id==-1) {
			isDeleteSuccess = todoDao.deleteAll();
		}
		else {
			isDeleteSuccess = todoDao.delete(id);
		}
		
		if(isDeleteSuccess) {
			model.addAttribute("responseMessage", "Todo delete successfully");
		}
		else {
			model.addAttribute("responseMessage", "Could not delete todo");
		}
		model.addAttribute("listOfAllTodos", todoDao.getAllTodos());
		
		return "index";
	}
}
