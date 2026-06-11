package com.ms_infraestructura.ms_infraestructura.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name="vehiculo") 
public class Vehiculo 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 6, max = 6, message = "La patente debe tener exactamente 6 caracteres ")
    @Column(unique = false, length = 6 )
    private String patente;

    @Size(min =3, max =20, message= "La marca debe tener entre 3 y 20 caracteres")
    @Column(length = 20 )
    private String marca;

    @Size(min =10, max =30, message= "El modelo debe tener entre 10 y 30 caracteres")
    @Column(length = 30 )
    private String modelo;


}

