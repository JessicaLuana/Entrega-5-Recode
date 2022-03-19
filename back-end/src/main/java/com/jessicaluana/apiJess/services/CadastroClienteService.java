package com.jessicaluana.apiJess.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jessicaluana.apiJess.services.exceptions.ResourceNotFoundException;
import com.jessicaluana.apiJess.entities.CadastroCliente;
import com.jessicaluana.apiJess.repositories.CadastroClienteRepository;

@Service
public class CadastroClienteService {
	@Autowired
	private CadastroClienteRepository cadastroClienteRepository;

	@Transactional(readOnly = true)
	public List<CadastroCliente> findAll() {
		List<CadastroCliente> cadastroCliente = CadastroClienteRepository.findAll();
		return cadastroCliente;
	}

	public void salvar(CadastroCliente cadastroCliente) {
		cadastroClienteRepository.save(cadastroCliente);
	}

	@Transactional
	public void deletar(Integer id) {
		try {
			cadastroClienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("CadastroCliente não existe.");
		}

	@Transactional
	public CadastroCliente editar(Integer id,CadastroCliente cadastroCliente {
		CadastroCliente cadastroClienteEditar = cadastroClienteRepository.getOne(id);

		cadastroClienteEditar.setNome(cadastroCliente.getNome());
		cadastroClienteEditar.setCpf(cadastroCliente.getCpf());
		cadastroClienteEditar.setEmail(cadastroCliente.getEmail());
		cadastroClienteEditar.setEndereco(cadastroCliente.getEndereco());
		

		cadastroClienteEditar = cadastroClienteRepository.save(cadastroClienteEditar);

		return new CadastroCliente();

	}
}
