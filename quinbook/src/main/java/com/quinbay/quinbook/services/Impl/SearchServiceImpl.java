package com.quinbay.quinbook.services.Impl;

import com.quinbay.quinbook.entity.QuinbookUsers;
import com.quinbay.quinbook.repositories.UserRepository;
import com.quinbay.quinbook.repositories.UserSolrRepository;
import com.quinbay.quinbook.searchdto.UserRequestDTO;
import com.quinbay.quinbook.searchdto.UserResponseDTO;
import com.quinbay.quinbook.services.SearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserSolrRepository userSolrRepository;

	@Override
	public UserResponseDTO getUserList(Integer id){
		Optional<QuinbookUsers> quinbookUsers=userSolrRepository.findById(id);
		UserResponseDTO userResponseDTO=new UserResponseDTO();
		if(quinbookUsers.isPresent()){
			BeanUtils.copyProperties(quinbookUsers.get(),userResponseDTO);
		}
		return userResponseDTO;
	}

	@Override
	public List<UserResponseDTO> getUserListBySearchTerm(String searchTerm){
		PageRequest pageable=PageRequest.of(0,5);
		List<UserResponseDTO> userResponseDTOList =new ArrayList<>();
		List<QuinbookUsers> quinbookUsersList=userSolrRepository.findByString(searchTerm,pageable);

		for(QuinbookUsers quinbookUsers:quinbookUsersList){
			UserResponseDTO userResponseDTO=new UserResponseDTO();
			BeanUtils.copyProperties(quinbookUsers,userResponseDTO);
			userResponseDTOList.add(userResponseDTO);
		}
		return userResponseDTOList;
	}
	@Override
	public UserResponseDTO saveInSolr(UserRequestDTO userRequestDTO){
		QuinbookUsers quinbookUsers=new QuinbookUsers();
		BeanUtils.copyProperties(userRequestDTO, quinbookUsers);
		QuinbookUsers savedQuinBookUsers=userRepository.save(quinbookUsers);
		QuinbookUsers savedQuinBookUsersInSolr=userSolrRepository.save(quinbookUsers);
		UserResponseDTO userResponseDTO=new UserResponseDTO();
		BeanUtils.copyProperties(savedQuinBookUsersInSolr,userResponseDTO);
		return userResponseDTO;
	}
	@Override
	public UserResponseDTO addUser(UserRequestDTO userRequestDTO){
		return saveInSolr(userRequestDTO);
	}
}
