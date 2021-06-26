package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.entities.Autoposto;

@Repository
public interface AutopostoRepository extends JpaRepository<Autoposto, Long>{

}
