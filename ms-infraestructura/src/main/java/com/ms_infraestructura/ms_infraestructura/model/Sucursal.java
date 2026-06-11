package com.ms_infraestructura.ms_infraestructura.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sucursal")
public class Sucursal 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "La dirección no puede estar vacio!")
    private String direccion;

    @NotBlank(message = "La ciudad no puede estar vacio")
    private String ciudad;

    @NotBlank(message = "La comuna no puede estar vacio")
    private String comuna;
    
}
