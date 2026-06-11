package com.ms_comercial.ms_comercial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ms_comercial.ms_comercial.DTO.ReclamoDTO;
import com.ms_comercial.ms_comercial.model.Reclamo;
import com.ms_comercial.ms_comercial.repository.ReclamoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReclamoService {
    @Autowired
    private ReclamoRepository reclamoRepository;


    private ReclamoDTO convertirADTO(Reclamo reclamos) {
        ReclamoDTO dto = new ReclamoDTO();
        dto.setId(reclamos.getId());
        dto.setDetalle_cliente(reclamos.getDetalle_cliente());
        dto.setTitulo(reclamos.getTitulo());
        dto.setId_cliente(reclamos.getId_cliente());

        return dto;
    }

     public List<ReclamoDTO> findAll() {
        log.info("...la auditoria se esta ejecutando");
        return reclamoRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ReclamoDTO findById(Long id) {
        log.info("...la auditoria se esta ejecutando");
        Reclamo reclamos = reclamoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
         return convertirADTO(reclamos);
    }

    public Reclamo save(Reclamo reclamo) {
        return  reclamoRepository.save(reclamo);
    }

    public void deleteById(Long id) {
        Reclamo reclamos = reclamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("reclamo no encontrado"));
        reclamoRepository.deleteById(reclamos.getId());
    }

    public Reclamo updateReclamo(Long id, Reclamo reclamo) {
        Reclamo reclamosToUpdate = reclamoRepository.findById(id)
        
                .orElseThrow(() -> new RuntimeException("Auditoría no encontrada"));
        
            reclamosToUpdate.setEstado_reclamo(reclamo.getEstado_reclamo());
            reclamosToUpdate.setDetalle_cliente(reclamo.getDetalle_cliente());
            reclamosToUpdate.setTitulo(reclamo.getTitulo());
            return reclamoRepository.save(reclamosToUpdate);
       
    }



}
