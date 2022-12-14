package com.farlau.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farlau.back.end.dto.UserDTO;
import com.farlau.back.end.service.UserService;

@RestController
//@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/")
	public List<UserDTO> getUsers() {
		List<UserDTO> usuarios = userService.getAll();
		return usuarios;
	}

	@GetMapping("/user/{id}")
	public UserDTO findById(@PathVariable long id) {
		return userService.findById(id);
	}

	@GetMapping("/user/cpf/{cpf}")
	UserDTO findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}
	
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(
		@RequestParam(name="nome", required = true)
		String nome){
			return userService.queryByName(nome);
	}

	@PostMapping("/user")
	UserDTO newUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}

	@DeleteMapping("/user/{id}")
	UserDTO delete(@PathVariable long id) {
		return userService.delete(id);
	}
}
