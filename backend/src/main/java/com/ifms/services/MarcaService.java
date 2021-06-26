package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.MarcaDTO;
import com.ifms.entities.Marca;
import com.ifms.repositories.MarcaRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	@Transactional(readOnly = true)
	public List<MarcaDTO> findAll() {
		List<Marca> list = repository.findAll();
		return MarcaDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public MarcaDTO findById(Long id) {
		Optional<Marca> obj = repository.findById(id);
		Marca marca = obj.orElseThrow(() -> new ResourceNotFoundException("A marca solicitada não foi localizada."));
		return new MarcaDTO(marca);
	}
	
	@Transactional
	public MarcaDTO insert(MarcaDTO dto) {
		Marca entity = new Marca(dto);
		entity = repository.save(entity);
		return new MarcaDTO(entity);
	}

	@Transactional
	public MarcaDTO update(Long id, MarcaDTO dto) {
		try {
			Marca entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setModelos(dto.getModelos());
			
			entity = repository.save(entity);
			return new MarcaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da marca não foi localizada.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível encontrar a marca, o id da marca não foi localizada.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar a marca, pois a mesma está em uso.");
		}
	}
	
	

}
	