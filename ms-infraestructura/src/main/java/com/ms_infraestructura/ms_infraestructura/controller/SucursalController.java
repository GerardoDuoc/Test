package com.ms_infraestructura.ms_infraestructura.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ms_infraestructura.ms_infraestructura.DTO.SucursalDTO;
import com.ms_infraestructura.ms_infraestructura.service.SucursalService;
import com.ms_infraestructura.ms_infraestructura.model.Sucursal;


@RestController 
@RequestMapping("/api/v1/sucursal") 
public class SucursalController 
{
    @Autowired
    private SucursalService sucursalService;
    
    @GetMapping
    public ResponseEntity<List<SucursalDTO>> listarSucursal()
    {
        List<SucursalDTO> sucursales = sucursalService.obtenerSucursal();
        if(sucursales.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDTO> buscarSucursalPorId(@PathVariable Integer id)
    {
        try
        {
            SucursalDTO sucursal = sucursalService.obtenerSucursalPorId(id);
            return ResponseEntity.ok(sucursal);
        }
        catch(RuntimeException e)
        {
            // Nota: Se agregó el tipo de retorno esperado por ResponseEntity
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Sucursal> guardarSucursal(@RequestBody Sucursal sucursal)
    {
        Sucursal sucursalCreada = sucursalService.guardarSucursal(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalCreada);
    } 
    
    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Integer id, @RequestBody Sucursal sucursal)
    {
        try
        {
            // Corregido: El método en el Service debe llamarse actualizarSucursal
            Sucursal sucursalActualizado = sucursalService.actualizarSucursal(id, sucursal);
            return ResponseEntity.ok(sucursalActualizado);
        }
        catch(Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id)
    {
        try
        {
            sucursalService.eliminarSucursal(id);
            return ResponseEntity.noContent().build();
        }
        catch(RuntimeException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}