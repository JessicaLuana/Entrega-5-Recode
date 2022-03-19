package com.jessicaluana.apiJess.controller;

import org.springframework.http.ResponseEntity;
import java.net.URI;
import java.util.List;

import com.jessicaluana.apiJess.services.ContatoService;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ContatoController {

    @RestController
    @RequestMapping(value = "/contato")
    public class UsersController {

        @Autowired
        private ContatoService contatoService;

        @GetMapping
        public List<contatoService> findAll() {
            return contatoService.findAll();
        }

        @PostMapping("/criar")
        public ResponseEntity<Contato> save(@RequestBody Contato contato) {
            contatoService.save(contato);
            return ResponseEntity.ok().body(contato);
        }

        @DeleteMapping("/deletar")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            contatoService.delete(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/editar")
        public ResponseEntity<Contato> edit(@PathVariable Integer id, @RequestBody Contato contato) {
            contato = contatoService.edit(id, Nome);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contato.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(contato);
        }

    }

}
