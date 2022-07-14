package com.example.demo.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnimesPostRequestBody {
	
	@NotNull(message = "não pode ser null")
	@NotEmpty	
	private String name;

}
