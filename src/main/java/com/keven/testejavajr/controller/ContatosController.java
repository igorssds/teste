package com.keven.testejavajr.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.keven.testejavajr.domain.Contatos;
import com.keven.testejavajr.dto.DContatos;
import com.keven.testejavajr.service.ContatosService;

@RestController
@RequestMapping(value="/contatos")
public class ContatosController {
	
	@Autowired
	private ContatosService contatosService; 

	
	@GetMapping("/{id}")
	public ResponseEntity<Contatos> find(@PathVariable Integer id) {
		Contatos obj = contatosService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Contatos>> findAll()	{
		List<Contatos> list = contatosService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<URI> insert(@Valid @RequestBody DContatos obj){
		DContatos insert = contatosService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insert.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody DContatos obj, @PathVariable Integer id){
		obj.setId(id);
		contatosService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		contatosService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Contatos>> findPage(
			@RequestParam (value = "page", defaultValue = "0") Integer page,
			@RequestParam (value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam (value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam (value = "direction", defaultValue = "ASC") String direction) {
		Page<Contatos> list = contatosService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
