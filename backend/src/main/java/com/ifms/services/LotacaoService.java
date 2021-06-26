package com.ifms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.LotacaoDTO;
import com.ifms.entities.Lotacao;
import com.ifms.repositories.LotacaoRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class LotacaoService {
	
	@Autowired
	private LotacaoRepository repository;
	
	@Transactional(readOnly = true)
	public List<LotacaoDTO> findAll() {
		List<Lotacao> list = repository.findAll();
		return LotacaoDTO.converter(list);
	}

	@Transactional(readOnly = true)
	public LotacaoDTO findById(Long id) {
		Optional<Lotacao> obj = repository.findById(id);
		Lotacao lotacao = obj.orElseThrow(() -> new ResourceNotFoundException("A lotação solicitada não foi localizada."));
		return new LotacaoDTO(lotacao);
	}
	
	@Transactional
	public LotacaoDTO insert(LotacaoDTO dto) {
		Lotacao entity = new Lotacao(dto);
		entity = repository.save(entity);
		return new LotacaoDTO(entity);
	}

	@Transactional
	public LotacaoDTO update(Long id, LotacaoDTO dto) {
		try {
			Lotacao entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setEndereco(dto.getEndereco());
			entity.setEmail(dto.getEmail());
			entity.setSite(dto.getSite());
			entity.setTelefone(dto.getTelefone());
			entity.setCidade(dto.getCidade());
			
			entity = repository.save(entity);
			return new LotacaoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da lotação não foi localizada.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível encontrar a lotação, o id da lotação não foi localizada.");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar a lotação, pois a mesma está em uso.");
		}
	}
	
	

}
	