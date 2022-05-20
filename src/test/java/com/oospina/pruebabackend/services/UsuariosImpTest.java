package com.oospina.pruebabackend.services;

import com.oospina.pruebabackend.dtos.TareaDto;
import com.oospina.pruebabackend.dtos.UsuarioDto;
import com.oospina.pruebabackend.model.Tarea;
import com.oospina.pruebabackend.model.Usuario;
import com.oospina.pruebabackend.repositories.ITareasRepo;
import com.oospina.pruebabackend.repositories.IUsuariosRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuariosImpTest {

    @InjectMocks
    private UsuariosImp service;

    @Mock
    private IUsuariosRepo repository;

    @Mock
    private ITareasRepo tareasRepo;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void crear() {
        // given
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea(1L, "Tare1", "Des1", LocalDate.now(), 1L));
        Usuario usuario = new Usuario(1L, "user1", "123", "456", tareas);
        when(this.repository.save(any())).thenReturn(usuario);

        List<TareaDto> tareasDto = new ArrayList<>();
        tareasDto.add(new TareaDto("Tare1", "Des1", LocalDate.now()));
        UsuarioDto dto = new UsuarioDto("user1", "123", "456", tareasDto);
        // when
        this.service.crear(dto);
        // then
        assertEquals(usuario.getNombre(), dto.getNombre());
        assertEquals(usuario.getTareas().size(), dto.getTareas().size());
        verify(this.repository).save(any());
    }

    @Test
    void actualizar() {
        // given
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea(1L, "Tare1", "Des1", LocalDate.now(), 1L));
        Usuario usuario = new Usuario(1L, "user1", "123", "456", tareas);
        when(this.repository.findById(anyLong())).thenReturn(Optional.of(usuario));

        List<TareaDto> tareasDto = new ArrayList<>();
        tareasDto.add(new TareaDto("Tare1", "Des1", LocalDate.now()));
        UsuarioDto dto = new UsuarioDto("user1", "123", "456", tareasDto);

        when(this.modelMapper.map(any(), any())).thenReturn(dto);
        // when
        this.service.actualizar(anyLong(), dto);
        // then
        assertEquals(usuario.getNombre(), dto.getNombre());
        assertEquals(usuario.getTareas().size(), dto.getTareas().size());
        verify(this.tareasRepo).actualizaTareas();
    }

    @Test
    void eliminar() {
        service.eliminar(anyLong());
        verify(this.repository).deleteById(anyLong());
    }

    @Test
    void buscarPorId() {
        // given
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea(1L, "Tare1", "Des1", LocalDate.now(), 1L));
        Usuario usuario = new Usuario(1L, "user1", "123", "456", tareas);
        when(this.repository.findById(anyLong())).thenReturn(Optional.of(usuario));

        List<TareaDto> tareasDto = new ArrayList<>();
        tareasDto.add(new TareaDto("Tare1", "Des1", LocalDate.now()));
        UsuarioDto dto = new UsuarioDto("user1", "123", "456", tareasDto);
        // when
        this.service.buscarPorId(anyLong());
        // then
        assertEquals(usuario.getNombre(), dto.getNombre());
        assertEquals(usuario.getTareas().size(), dto.getTareas().size());
        verify(this.repository).findById(anyLong());
    }

    @Test
    void listarSinResultados() {
        // given
        List<UsuarioDto> lista = new ArrayList<>();
        // when
        List<UsuarioDto> crear = this.service.listar();
        // then
        assertEquals(lista, crear);
        verify(this.repository).findAll();
    }
}