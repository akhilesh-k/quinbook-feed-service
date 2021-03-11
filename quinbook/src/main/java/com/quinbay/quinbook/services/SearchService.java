package com.quinbay.quinbook.services;

import com.quinbay.quinbook.searchdto.UserRequestDTO;
import com.quinbay.quinbook.searchdto.UserResponseDTO;

import java.util.List;

public interface SearchService {
	UserResponseDTO getUserList(Integer Id);
	List<UserResponseDTO> getUserListBySearchTerm(String searchTerm);
	UserResponseDTO saveInSolr(UserRequestDTO userRequestDTO);
	UserResponseDTO addUser(UserRequestDTO userRequestDTO);
}
