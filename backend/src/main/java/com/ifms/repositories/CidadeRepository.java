package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}