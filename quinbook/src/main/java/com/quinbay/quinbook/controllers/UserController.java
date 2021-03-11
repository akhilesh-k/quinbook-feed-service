package com.quinbay.quinbook.controllers;

import com.quinbay.quinbook.searchdto.UserRequestDTO;
import com.quinbay.quinbook.searchdto.UserResponseDTO;
import com.quinbay.quinbook.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	SearchService searchService;

	@GetMapping("/getUser/{id}")
	public UserResponseDTO getUserList(@PathVariable("id") Integer id){
		return searchService.getUserList(id);
	}

	@GetMapping("/getUserName/{searchTerm}")
	public List<UserResponseDTO> getUserListBySearchTerm(@PathVariable("searchTerm") String searchTerm){
		return searchService.getUserListBySearchTerm(searchTerm);
	}
	@PostMapping("/addUser")
	public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO){
		return searchService.addUser(userRequestDTO);
	}
}
