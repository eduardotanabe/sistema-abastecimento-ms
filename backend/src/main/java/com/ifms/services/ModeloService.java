package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.ModeloDTO;
import com.ifms.entities.Modelo;
import com.ifms.repositories.ModeloRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository repository;
	
	@Transactional(readOnly = true)
	public List<ModeloDTO> findAll() {
		List<Modelo> list = repository.findAll();
		return ModeloDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public ModeloDTO findById(Long id) {
		Optional<Modelo> obj = repository.findById(id);
		Modelo modelo = obj.orElseThrow(() -> new ResourceNotFoundException("O modelo solicitado não foi localizado."));
		return new ModeloDTO(modelo);
	}
	
	@Transactional
	public ModeloDTO insert(ModeloDTO dto) {
		Modelo entity = new Modelo(dto);
		entity = repository.save(entity);
		return new ModeloDTO(entity);
	}

	@Transactional
	public ModeloDTO update(Long id, ModeloDTO dto) {
		try {
			Modelo entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setMarca(dto.getMarca());
			
			entity = repository.save(entity);
			return new ModeloDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do modelo não foi localizado.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível encontrar o modelo, o id do modelo não foi localizado.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar o modelo, pois o mesmo está em uso.");
		}
	}
	
	

}
	