package com.oospina.pruebabackend.services;

import com.oospina.pruebabackend.dtos.UsuarioDto;

import java.util.List;

public interface IUsuariosService {

    UsuarioDto crear(UsuarioDto usuario);

    UsuarioDto actualizar(Long id, UsuarioDto usuario);

    void eliminar(Long id);

    UsuarioDto buscarPorId(Long id);

    List<UsuarioDto> listar();
}
