package com.keven.testejavajr.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class DTelefones {

	
	private Integer id;
	
	@NotNull(message = "Telefone nao pode ser null")
	private String telefone;
	
	
}
