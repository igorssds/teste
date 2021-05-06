package com.keven.testejavajr;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.keven.testejavajr.domain.Contatos;
import com.keven.testejavajr.domain.Telefones;
import com.keven.testejavajr.repository.ContatosRepository;


@SpringBootApplication
public class TesteJavaJrApplication implements CommandLineRunner{
	
	@Autowired
	private ContatosRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteJavaJrApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Contatos c = new Contatos("Keven", "silva", "keenve@abc.com");
		Telefones t = new Telefones("456132");
		c.setTelefones(Arrays.asList(t));
		t.setContatos(c);
		repository.save(c);
		
		
	}
}
