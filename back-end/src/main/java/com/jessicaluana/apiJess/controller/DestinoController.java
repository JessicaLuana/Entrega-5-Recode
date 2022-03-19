package com.jessicaluana.apiJess.controller;

import org.springframework.http.ResponseEntity;
import java.net.URI;
import java.util.List;

import com.jessicaluana.apiJess.services.DestinoService;

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

public class DestinoController {

    @RestController
    @RequestMapping(value = "/destino")
    public class UsersController {

        @Autowired
        private DestinoService destinoService;

        @GetMapping
        public List<DestinoService> findAll() {
            return destinoService.findAll();
        }

        @PostMapping("/criar")
        public ResponseEntity<Destino> save(@RequestBody Destino destino) {
            destinoService.save(destino);
            return ResponseEntity.ok().body(destino);
        }

        @DeleteMapping("/deletar")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            DestinoService.delete(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/editar")
        public ResponseEntity<Contato> edit(@PathVariable Integer id, @RequestBody Destino destino) {
            destino = destinoService.edit(id, Nome);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(destino.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(destino);
        }

    }

}
