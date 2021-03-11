package com.quinbay.quinbook.searchdto;

import lombok.Data;

@Data
public class UserResponseDTO {
	private Integer userId;
	private String userName;
	private String email;
	private String location;
}
