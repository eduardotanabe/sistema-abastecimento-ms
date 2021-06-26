package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.AutopostoDTO;
import com.ifms.entities.Autoposto;
import com.ifms.repositories.AutopostoRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class AutopostoService {
	
	@Autowired
	private AutopostoRepository repository;
	
	@Transactional(readOnly = true)
	public List<AutopostoDTO> findAll() {
		List<Autoposto> list = repository.findAll();
		return AutopostoDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public AutopostoDTO findById(Long id) {
		Optional<Autoposto> obj = repository.findById(id);
		Autoposto autoposto = obj.orElseThrow(() -> new ResourceNotFoundException("O autoposto solicitado não foi localizado."));
		return new AutopostoDTO(autoposto);
	}
	
	@Transactional
	public AutopostoDTO insert(AutopostoDTO dto) {
		Autoposto entity = new Autoposto(dto);
		entity = repository.save(entity);
		return new AutopostoDTO(entity);
	}

	@Transactional
	public AutopostoDTO update(Long id, AutopostoDTO dto) {
		try {
			Autoposto entity = repository.getOne(id);
			entity.setNomeFantasia(dto.getNomeFantasia());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());
			entity.setCnpj(dto.getCnpj());
			entity.setEndereco(dto.getEndereco());
			entity.setCidade(dto.getCidade());

			entity = repository.save(entity);
			return new AutopostoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do autoposto não foi localizado.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, o id do autoposto não foi localizado.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar o autoposto, pois o mesmo está em uso.");
		}
	}
	
	

}
	