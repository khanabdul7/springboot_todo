package com.initiallyrics.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<TODO> todos = new ArrayList<>(); // creating a list of type TODO class

	private static int idCounter = 0;

	// creating static block to store hard coded list.
	static {
		todos.add(new TODO(++idCounter, "Initiallyrics", "Learn Java", LocalDate.now().plusMonths(1), false));
		todos.add(new TODO(++idCounter, "Initiallyrics", "Learn React", LocalDate.now().plusMonths(2), false));
		todos.add(new TODO(++idCounter, "Initiallyrics", "Learn Full Stack", LocalDate.now().plusMonths(3), false));
	}

	public List<TODO> findByUsername(String username) {
		return todos;
	}

	//this method is to add new TODO in list
	public void addTodo(String username, String description, LocalDate date, boolean completed) {
		TODO todo = new TODO(++idCounter, username, description, date, completed);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<TODO> predicate = t -> t.getId() == id;
		todos.removeIf(predicate);
	}

	public TODO findById(int id) {
		Predicate<TODO> predicate = t -> t.getId() == id;
		TODO todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(TODO todo) {
		deleteById(todo.getId());
		todos.add(todo);
	} 
}
