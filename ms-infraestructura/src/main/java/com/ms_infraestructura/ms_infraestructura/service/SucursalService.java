package com.ms_infraestructura.ms_infraestructura.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.ms_infraestructura.ms_infraestructura.DTO.SucursalDTO;
import com.ms_infraestructura.ms_infraestructura.model.Sucursal;
import com.ms_infraestructura.ms_infraestructura.repository.SucursalRepository;

@Service
@Slf4j
public class SucursalService 
{
    @Autowired
    private SucursalRepository sucursalRepository;

    public List<SucursalDTO> obtenerSucursal()
    {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        return sucursales.stream().map(this::convertirADTO).toList();
    }

    public void eliminarSucursal(Integer id)
    {
        if(!sucursalRepository.existsById(id))
            {
                throw new RuntimeException("No se puede eliminar la sucursal, porque no existe");
            }
            sucursalRepository.deleteById(id);
            log.info("Sucursal con ID: {} ha sido eliminado exitosamente", id);

    }

    public SucursalDTO obtenerSucursalPorId(Integer id)
    {
        Sucursal sucursal = sucursalRepository.findById(id).orElseThrow(() -> new RuntimeException( "Sucursal no encontrada con la ID :" + id));
        return convertirADTO(sucursal);
    }

    private SucursalDTO convertirADTO(Sucursal sucursal)
    {
        SucursalDTO dto =new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setDireccion(sucursal.getDireccion());
        dto.setComuna(sucursal.getComuna());
        dto.setCiudad(sucursal.getCiudad());
        return dto;

    }
    

    public Sucursal guardarSucursal(Sucursal sucursal) {
        Sucursal nuevaSucursal = sucursalRepository.save(sucursal);
        log.info("Nueva sucursal guardada exitosamente con ID: {}", nuevaSucursal.getId());
        return nuevaSucursal;
    }

  
    public Sucursal actualizarSucursal(Integer id, Sucursal sucursalDetalles) {
        Sucursal sucursalExistente = sucursalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró la sucursal con ID: " + id));

        sucursalExistente.setDireccion(sucursalDetalles.getDireccion());
        sucursalExistente.setCiudad(sucursalDetalles.getCiudad());
        sucursalExistente.setComuna(sucursalDetalles.getComuna());

        log.info("Sucursal con ID: {} actualizada", id);
        return sucursalRepository.save(sucursalExistente);
    }
    
}
