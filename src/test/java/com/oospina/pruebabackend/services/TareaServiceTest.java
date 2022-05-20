package com.oospina.pruebabackend.services;

import com.oospina.pruebabackend.dtos.CriteriaDto;
import com.oospina.pruebabackend.dtos.CriteriaResponseTareaDto;
import com.oospina.pruebabackend.model.Tarea;
import com.oospina.pruebabackend.repositories.ITareasRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TareaServiceTest {

    @InjectMocks
    private TareaService service;

    @Mock
    private ITareasRepo repository;

    @Test
    void buscarPorCriterio() {
        // given
        List<Tarea> lista = new ArrayList<>();
        lista.add(new Tarea(1L, "Tare1", "Des1", LocalDate.now(), 1L));
        when(this.repository.buscarPorCriterio(anyLong(), any(), any()))
                .thenReturn(lista);
        // when
        List<CriteriaResponseTareaDto> result = this.service.buscarPorCriterio(new CriteriaDto(LocalDate.now(), LocalDate.now(), 1L));
        // then
        assertEquals(lista.size(), result.size());
        verify(this.repository).buscarPorCriterio(anyLong(), any(), any());
    }
}