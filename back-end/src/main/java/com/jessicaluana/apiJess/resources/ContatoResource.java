package com.jessicaluana.apiJess.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jessicaluana.apiJess.entities.Contato;
import com.jessicaluana.apiJess.services.ContatoService;

@RestController
@RequestMapping("/contato")
@CrossOrigin(origins = "http://localhost:3000")
public class ContatoResource {

		@Autowired
		private ContatoService service;

		@GetMapping
		public List<Contato> findAll() {
			return service.findAll();
		}
		
		@PostMapping
		public ResponseEntity<Contato> save(@RequestBody Contato Contato){
			service.save(Contato);
			return ResponseEntity.ok().body(Contato);
		}
}

