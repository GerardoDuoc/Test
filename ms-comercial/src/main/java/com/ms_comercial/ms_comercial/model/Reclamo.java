package com.ms_comercial.ms_comercial.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "el id no debe estar vacio")
    @Column(name = "id_cliente", unique = true, nullable = false)
    private Long id_cliente;

    @NotBlank(message = "el titulo no debe estar vacio")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotBlank(message = "el detalle no debe estar vacio")
    @Column(name = "detalle_reclamo", nullable = false) 
    private String detalle_cliente;

    @NotNull(message = "el estado no puede ser nulo")
    @Column(name = "estado_reclamo", nullable = false)
    private Boolean estado_reclamo; 
}