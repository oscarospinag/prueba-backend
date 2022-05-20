package com.oospina.pruebabackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@ToString
@AllArgsConstructor
public @Data
class UsuarioDto {

    private String nombre;
    private String cedula;
    private String telefono;
    private List<TareaDto> tareas;

    public UsuarioDto() {
    }
}
