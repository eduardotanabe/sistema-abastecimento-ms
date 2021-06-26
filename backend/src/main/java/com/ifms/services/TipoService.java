package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.TipoDTO;
import com.ifms.entities.Tipo;
import com.ifms.repositories.TipoRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository repository;
	
	@Transactional(readOnly = true)
	public List<TipoDTO> findAll() {
		List<Tipo> list = repository.findAll();
		return TipoDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public TipoDTO findById(Long id) {
		Optional<Tipo> obj = repository.findById(id);
		Tipo tipo = obj.orElseThrow(() -> new ResourceNotFoundException("O tipo solicitado não foi localizado."));
		return new TipoDTO(tipo);
	}
	
	@Transactional
	public TipoDTO insert(TipoDTO dto) {
		Tipo entity = new Tipo(dto);
		entity = repository.save(entity);
		return new TipoDTO(entity);
	}

	@Transactional
	public TipoDTO update(Long id, TipoDTO dto) {
		try {
			Tipo entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			
			entity = repository.save(entity);
			return new TipoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do tipo não foi localizado.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível encontrar o tipo, o id do tipo não foi localizado.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar o tipo, pois o mesmo está em uso.");
		}
	}
	
	

}
	