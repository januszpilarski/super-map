package com.pilarski.mmap.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserDTO {
	
	@NotBlank
	@Size(min = 3)
	private String username;
	@NotBlank
	@Size(min = 6, max = 18)
	private String password;
	@NotBlank
	private String paswordConfirm;
	@NotNull
	@Email
	private String email;

}
