package com.keven.testejavajr.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Contatos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatorio")
	private String primeiroNome;

	@NotEmpty(message = "Preenchimento obrigatorio")
	private String ultimoNome;

	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido (sintatico)")
	private String email;

	@NotEmpty(message = "Preenchimento obrigatorio")
	@OneToMany(mappedBy = "contatos", cascade = CascadeType.ALL)
	private List<Telefones> telefones;

	public Contatos(String nome, String sobreNome, String email) {
		this.primeiroNome = nome;
		this.ultimoNome = sobreNome;
		this.email = email;
	}
	
}
