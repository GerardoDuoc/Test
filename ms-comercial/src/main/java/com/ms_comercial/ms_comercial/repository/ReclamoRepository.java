package com.ms_comercial.ms_comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_comercial.ms_comercial.model.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo,Long >
 {

    
 

}