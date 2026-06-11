package com.ms_infraestructura.ms_infraestructura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_infraestructura.ms_infraestructura.DTO.VehiculoDTO;
import com.ms_infraestructura.ms_infraestructura.model.Vehiculo;
import com.ms_infraestructura.ms_infraestructura.repository.VehiculoRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class VehiculoService 
{
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<VehiculoDTO> obtenerVehiculo()
    {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(this::convertirADTO).toList();
    }
    public Vehiculo guardarVehiculo(Vehiculo vehiculo)
    {
       log.info("Guardando vehiculo...");
         return vehiculoRepository.save(vehiculo);
    }    
    public List<Vehiculo>totalVehiculos()
    {
        return vehiculoRepository.findAll();
    }
    public void eliminarVehiculo(Integer id)
    {
        log.info("Intentando eliminar el vehiculo con ID : {}",id);
        if(!vehiculoRepository.existsById(id))
            {
                throw new RuntimeException("No se puede eliminar : El vehiculo no se ha encontrado con la ID :" + id);
            }
        vehiculoRepository.deleteById(id);
        log.info("Vehiculo con ID : {} ha sido eliminado exitosamente",id);
    }
    public Vehiculo actualizarVehiculo(Integer id, Vehiculo nuevoVehiculo)
    {
        log.info("Actualizando el vehiculo con ID {}", id);
        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se puede actualizar, razon: El vehiculo no se ha encontrado con ID: " + id));
        vehiculoExistente.setPatente(nuevoVehiculo.getPatente());
        vehiculoExistente.setMarca(nuevoVehiculo.getMarca());
        vehiculoExistente.setModelo(nuevoVehiculo.getModelo()); 
        return vehiculoRepository.save(vehiculoExistente);
    }

    //Metodo para convertir la entidad en DTO, lo mismo que se hizo en PersonalService
    public VehiculoDTO convertirADTO(Vehiculo vehiculo)
    {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getId());
        dto.setPatente(vehiculo.getPatente());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        return dto;
    }
    public VehiculoDTO buscarPorId(Integer id)
    {
        log.info("Buscando el vehicolo por id...");
        Vehiculo vehiculo= vehiculoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException ( "Vehiculo no encontrado con la ID :"  + id));
        return convertirADTO(vehiculo);
    }



}
