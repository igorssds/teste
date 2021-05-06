package com.keven.testejavajr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keven.testejavajr.dto.DTelefones;
import com.keven.testejavajr.service.TelefonesService;

@RestController
@RequestMapping(value = "/telefones")
public class TelefonesController {

	@Autowired
	private TelefonesService telefonesService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DTelefones> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(telefonesService.find(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<DTelefones>> findAll()	{
		return ResponseEntity.ok().body(telefonesService.findAll());
	}
}
