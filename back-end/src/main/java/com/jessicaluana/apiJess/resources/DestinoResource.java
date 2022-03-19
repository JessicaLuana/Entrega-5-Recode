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

import com.jessicaluana.apiJess.entities.Destino;
import com.jessicaluana.apiJess.services.DestinoService;


@RestController
@RequestMapping("/destino")
@CrossOrigin(origins = "http://localhost:3000")
public class DestinoResource {

	@Autowired
	private DestinoService service;

	@GetMapping
	public List<Destino> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Destino> save(@RequestBody Destino Destino){
		service.save(Destino);
		return ResponseEntity.ok().body(Destino);
	}
}
