package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.CidadeDTO;
import com.ifms.entities.Cidade;
import com.ifms.repositories.CidadeRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	@Transactional(readOnly = true)
	public List<CidadeDTO> findAll() {
		List<Cidade> list = repository.findAll();
		return CidadeDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public CidadeDTO findById(Long id) {
		Optional<Cidade> obj = repository.findById(id);
		Cidade cidade = obj.orElseThrow(() -> new ResourceNotFoundException("A cidade solicitada não foi localizada."));
		return new CidadeDTO(cidade);
	}
	
	@Transactional
	public CidadeDTO insert(CidadeDTO dto) {
		Cidade entity = new Cidade(dto);
		entity = repository.save(entity);
		return new CidadeDTO(entity);
	}

	@Transactional
	public CidadeDTO update(Long id, CidadeDTO dto) {
		try {
			Cidade entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setEstado(dto.getEstado());
			
			entity = repository.save(entity);
			return new CidadeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da cidade não foi localizado.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível a cidade, o id da ciadde não foi localizado.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar a cidade, pois a mesma está em uso.");
		}
	}
	
	

}
	