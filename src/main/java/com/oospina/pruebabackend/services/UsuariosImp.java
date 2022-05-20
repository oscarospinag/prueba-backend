package com.oospina.pruebabackend.services;

import com.oospina.pruebabackend.dtos.TareaDto;
import com.oospina.pruebabackend.dtos.UsuarioDto;
import com.oospina.pruebabackend.model.Tarea;
import com.oospina.pruebabackend.model.Usuario;
import com.oospina.pruebabackend.repositories.ITareasRepo;
import com.oospina.pruebabackend.repositories.IUsuariosRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosImp implements IUsuariosService {

    private final IUsuariosRepo usuariosRepo;

    private final ITareasRepo tareasRepo;

    private final ModelMapper modelMapper;

    public UsuariosImp(IUsuariosRepo usuariosRepo, ITareasRepo tareasRepo, ModelMapper modelMapper) {
        this.usuariosRepo = usuariosRepo;
        this.tareasRepo = tareasRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsuarioDto crear(UsuarioDto dto) {
        validar(dto);
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        return modelMapper.map(usuariosRepo.save(usuario), UsuarioDto.class);
    }

    @Override
    public UsuarioDto actualizar(Long id, UsuarioDto dto) {
        validar(dto);
        Usuario usuario = usuariosRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setCedula(dto.getCedula());
        usuario.setTelefono(dto.getTelefono());
        if (dto.getTareas() != null && !dto.getTareas().isEmpty()) {
            usuario.getTareas().clear();
            for (TareaDto t : dto.getTareas()) {
                usuario.getTareas().add(new Tarea(t.getNombre(), t.getDescripcion(), t.getFecha()));
            }
        } else {
            usuario.setTareas(null);
        }
        UsuarioDto response = modelMapper.map(usuariosRepo.save(usuario), UsuarioDto.class);
        tareasRepo.actualizaTareas();
        return response;
    }

    @Override
    public void eliminar(Long id) {
        usuariosRepo.deleteById(id);
    }

    @Override
    public UsuarioDto buscarPorId(Long id) {
        Usuario usuario = usuariosRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        return  modelMapper.map(usuario, UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> listar() {
        List<Usuario> list = (List<Usuario>) usuariosRepo.findAll();
        List<UsuarioDto> response = new ArrayList<>();
        list.forEach(u -> {
            response.add(modelMapper.map(u, UsuarioDto.class));
        });
        return response;
    }

    private void validar(UsuarioDto dto) {
        if (dto.getNombre() == null ||
                dto.getNombre() != null && dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre requerido");
        }
        if (dto.getCedula() == null ||
                dto.getCedula() != null && dto.getCedula().isEmpty()) {
            throw new IllegalArgumentException("Cedula requerida");
        }
        if (dto.getTelefono() == null ||
                dto.getTelefono() != null && dto.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("Telefono requerido");
        }
    }
}
