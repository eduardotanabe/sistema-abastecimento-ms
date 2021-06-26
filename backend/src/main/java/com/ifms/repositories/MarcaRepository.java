package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
