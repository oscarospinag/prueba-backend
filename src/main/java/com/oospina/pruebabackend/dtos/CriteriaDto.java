package com.oospina.pruebabackend.dtos;

import lombok.Data;

import java.time.LocalDate;

public @Data
class CriteriaDto {

    private LocalDate fromFecha;
    private LocalDate toFecha;
    private Long idUsuario;

    public CriteriaDto() {
    }

    public CriteriaDto(LocalDate fromFecha, LocalDate toFecha, Long idUsuario) {
        this.fromFecha = fromFecha;
        this.toFecha = toFecha;
        this.idUsuario = idUsuario;
        if (toFecha.isBefore(fromFecha)) {
            throw new IllegalArgumentException("Fechas invalidas");
        }
    }
}
