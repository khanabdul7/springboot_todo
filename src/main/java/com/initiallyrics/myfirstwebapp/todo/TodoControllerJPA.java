package com.initiallyrics.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.persistence.Id;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	private TodoService todoService;
	
	private TodoRepository todoRepository;

	public TodoControllerJPA(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository= todoRepository;
	}

	@RequestMapping("todo")
	public String todos(ModelMap model) {
		List<TODO> todos = todoRepository.findByUsername(getLoggedInUsername()); // calling method
		model.addAttribute("todos", todos); // adding list of todos from service method to "todos" so that it can be render by view.
		return "todosJSP"; // returning todosJSP view
	}

	/*
	 * NOTE: we are using 2 way binding in below 2 methods (showAddtodo, Addtodo).
	 * at line : 42 and 43 we r binding model values to view(addTodoJSP) -- 1st binding
	 * at line : 50 and 51 we r getting values from view to model again -- 2nd binding 
	 * at line : 52 we r calling logic and adding new todo to our list
	 */

	// this method is used to handle GET request and return addTodoJSP view
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddtodo(ModelMap model) {
		String username = (String) model.get("name");
		TODO todo = new TODO(0, username, "", LocalDate.now(), false); // creating obj with initial values.
		model.put("todo", todo); // putting above created obj into model so that i can be bound with modelAttribute used in its corresponding view i.e: addTodoJSP
		return "addTodoJSP";
	}

	// this method is used to handle POST request and redirect to todo view after
	// adding new Todo
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String Addtodo(ModelMap model, @Valid @ModelAttribute("todo") TODO todo, BindingResult result) { // this todo obj will recieve its values from view i.e:addTodoJSP, BindingResult will get error from view (if any), @Valid is used so that binding should happen after validating at POJO class.
		
		if(result.hasErrors()) {
			return "addTodoJSP";
		}
		
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo";
	}

	@RequestMapping("delete")
	public String delete(@RequestParam int id) {
		//todoRepository.deleteById(id);
		todoRepository.deleteById(id);
		return "redirect:todo";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam int id, ModelMap model) {
		TODO todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "addTodoJSP";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateTodoPage(ModelMap model, @Valid @ModelAttribute("todo") TODO todo, BindingResult result) { // this todo obj will recieve its values from view i.e:addTodoJSP, BindingResult will get error from view (if any), @Valid is used so that binding should happen after validating at POJO class.
		
		if(result.hasErrors()) {
			return "addTodoJSP";
		}
		
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();

	}
}
