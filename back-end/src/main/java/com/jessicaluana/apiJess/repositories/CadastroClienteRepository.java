package com.jessicaluana.apiJess.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jessicaluana.apiJess.entities.CadastroCliente;

@Repository
public interface CadastroClienteRepository extends JpaRepository<CadastroCliente, Integer>{

}
