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

import com.jessicaluana.apiJess.entities.CadastroCliente;
import com.jessicaluana.apiJess.services.CadastroClienteService;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "http://localhost:3000")
public class CadastroClienteResource {
	
		@Autowired
		private CadastroClienteService service;

		@GetMapping
		public List<CadastroCliente> findAll() {
			return service.findAll();
		}
		
		@PostMapping
		public ResponseEntity<CadastroCliente> save(@RequestBody CadastroCliente CadastroCliente){
			service.save(CadastroCliente);
			return ResponseEntity.ok().body(CadastroCliente);
		}
}
