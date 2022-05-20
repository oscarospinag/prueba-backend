package com.oospina.pruebabackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Entity
@AllArgsConstructor
public @Data
class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String cedula;

    private String telefono;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private List<Tarea> tareas;

    public Usuario() {
    }
}
