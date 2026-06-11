package com.ms_comercial.ms_comercial.DTO;

import lombok.Data;

@Data
public class ReclamoDTO {
    private Long id;
    private Long id_cliente;
    private String detalle_cliente;
    private String titulo;
    private boolean estado_reclamo;
}
