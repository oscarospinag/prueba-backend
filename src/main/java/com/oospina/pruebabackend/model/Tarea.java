package com.oospina.pruebabackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@ToString
@Entity
@AllArgsConstructor
public @Data class Tarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDate fecha;

    private Long usuario;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, LocalDate fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
}
