package com.ms_comercial.ms_comercial.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name="precio")
public class Precio 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(value = 0, message ="El precio no puede ser negativo")
    @Max(value= 1000000, message= "El precio no puede ser mayor a 1.000.000")
    @Column(name = "precio_base", nullable = false) 
    private Double precioBase;
}