package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.entities.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{

}
