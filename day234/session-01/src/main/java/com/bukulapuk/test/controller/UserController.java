package com.bukulapuk.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bukulapuk.test.model.User;
import com.bukulapuk.test.repository.UserRepository;

@Controller
@RequestMapping(path="/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	//@RequestMapping(path="", method=RequestMethod.GET)
	@GetMapping(path="")
	public @ResponseBody Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/fetch/{limit}/{offset}")
	public @ResponseBody List<User> fetchUsers(@PathVariable("limit") int limit,
												@PathVariable("offset") int offset){
		return userRepository.getUserByLimit(limit,offset);
	}
	
	@PostMapping(path="")
	public @ResponseBody User storeUser(
			@RequestParam("email") String email, 
			@RequestParam("name") String name) {
		
		/**
		 * Validation
		 */
		if(email.isEmpty()) return null;
		if(name.isEmpty()) return null;
		
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		userRepository.save(user);
		
		return user;
	}
	
	@PutMapping(path="/{id}")
	public @ResponseBody User editUser(
			@PathVariable("id") Long id,
			@RequestParam("email") String email,
			@RequestParam("name") String name) {
		
		/**
		 * Validation
		 */
		if(email.isEmpty()) return null;
		if(name.isEmpty()) return null;
		
		User user = userRepository.findOne(id);
		user.setEmail(email);
		user.setName(name);
		userRepository.save(user);
		
		return user;
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String destroyUser(
			@PathVariable("id") Long id) {
		
//		User user = userRepository.findOne(id);
//		userRepository.delete(user);
		userRepository.delete(id);
		
		return "Success";
	}
}
