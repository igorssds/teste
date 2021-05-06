package com.keven.testejavajr.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class DContatos {

	private Integer id;
	
	@NotNull(message = "Nome nao pode ser null")
	private String primeiroNome;

	@NotNull(message = "Ultimo nome nao pode ser null")
	private String ultimoNome;

	@NotNull(message = "Email nao pode ser null")
	private String email;
	
	@NotEmpty
	private List<DTelefones> telefones;
}
