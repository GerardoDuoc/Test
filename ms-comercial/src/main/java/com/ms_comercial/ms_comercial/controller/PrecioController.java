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

import com.ms_comercial.ms_comercial.DTO.PrecioDTO;
import com.ms_comercial.ms_comercial.model.Precio;
import com.ms_comercial.ms_comercial.service.PrecioService;

@RestController
@RequestMapping("/api/v1/precio")
public class PrecioController 
{
    @Autowired
    private PrecioService precioService;

    @GetMapping
    public ResponseEntity<List<PrecioDTO>> listarPrecio()
    {
        List<PrecioDTO> precios = precioService.totalPrecios();
        if(precios.isEmpty())
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(precios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PrecioDTO> buscarPrecioPorId(@PathVariable Integer id)
    {
        try
        {
            PrecioDTO precios = precioService.buscarPorid(id);
            return ResponseEntity.ok(precios);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Precio> guardarPrecio(@RequestBody Precio precio)
    {
        Precio nuevoPrecio = precioService.guardarPrecio(precio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPrecio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Precio> actualizarPrecio(@PathVariable Integer id, @RequestBody Precio precio)
    {
        try
        {
            Precio precioActualizado = precioService.actualizarPrecio(id, precio);
            return ResponseEntity.ok(precioActualizado);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrecio(@PathVariable Integer id)
    {
        try
        {       
            precioService.eliminarPrecio(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

}
