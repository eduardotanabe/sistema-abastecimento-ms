package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.EstadoDTO;
import com.ifms.entities.Estado;
import com.ifms.repositories.EstadoRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	@Transactional(readOnly = true)
	public List<EstadoDTO> findAll() {
		List<Estado> list = repository.findAll();
		return EstadoDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public EstadoDTO findById(Long id) {
		Optional<Estado> obj = repository.findById(id);
		Estado estado = obj.orElseThrow(() -> new ResourceNotFoundException("O estado solicitado não foi localizado."));
		return new EstadoDTO(estado);
	}
	
	@Transactional
	public EstadoDTO insert(EstadoDTO dto) {
		Estado entity = new Estado(dto);
		entity = repository.save(entity);
		return new EstadoDTO(entity);
	}

	@Transactional
	public EstadoDTO update(Long id, EstadoDTO dto) {
		try {
			Estado entity = repository.getOne(id);
			entity.setUf(dto.getUf());
			
			entity = repository.save(entity);
			return new EstadoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do estado não foi localizado.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível encontrar o estado, o id do estado não foi localizado.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar o estado, pois o mesmo está em uso.");
		}
	}
	
	

}
	