package com.ms_infraestructura.ms_infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import feign.Param; 
import com.ms_infraestructura.ms_infraestructura.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer>
{
    @Query("SELECT s FROM Sucursal s WHERE s.direccion = :direccion")
    Sucursal findByDirectionQuery(@Param("direccion") String direccion);
    
}
