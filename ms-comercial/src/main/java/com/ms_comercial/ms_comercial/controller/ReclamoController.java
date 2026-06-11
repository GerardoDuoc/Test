package com.ms_comercial.ms_comercial.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_comercial.ms_comercial.DTO.ReclamoDTO;
import com.ms_comercial.ms_comercial.model.Reclamo;
import com.ms_comercial.ms_comercial.service.ReclamoService;

@RestController
@RequestMapping("/api/v1/reclamo")
public class ReclamoController {
    @Autowired
    private ReclamoService reclamoService;

    @GetMapping()
    public ResponseEntity<List<ReclamoDTO>> listarAsientos() {
        List<ReclamoDTO> reclamo = reclamoService.findAll();
        if (reclamo.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reclamo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReclamoDTO> buscarAsientoPorId(@PathVariable Long id) {
        try {
            ReclamoDTO reclamo = reclamoService.findById(id);
            return ResponseEntity.ok(reclamo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reclamo> guardar(@RequestBody Reclamo reclamos) {
        Reclamo reclamo = reclamoService.save(reclamos);
        return ResponseEntity.status(HttpStatus.CREATED).body(reclamo);
    }


     @PutMapping("/{id}")
     public ResponseEntity<Reclamo> actualizar(@PathVariable Long id, @RequestBody Reclamo reclamos) {
        try {
            Reclamo reclamo = reclamoService.updateReclamo(id, reclamos);
            return ResponseEntity.ok(reclamo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            reclamoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
