package com.oospina.pruebabackend.services;

import com.oospina.pruebabackend.dtos.CriteriaDto;
import com.oospina.pruebabackend.dtos.CriteriaResponseTareaDto;
import com.oospina.pruebabackend.model.Tarea;
import com.oospina.pruebabackend.repositories.ITareasRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService implements ITareaService {

    private final ITareasRepo tareasRepo;

    public TareaService(ITareasRepo tareasRepo) {
        this.tareasRepo = tareasRepo;
    }

    @Override
    public List<CriteriaResponseTareaDto> buscarPorCriterio(CriteriaDto criteria) {
        List<Tarea> tareas = tareasRepo.buscarPorCriterio(criteria.getIdUsuario(), criteria.getFromFecha(), criteria.getToFecha());
        List<CriteriaResponseTareaDto> response = new ArrayList<>();
        tareas.forEach(t -> {
            response.add(new CriteriaResponseTareaDto(t.getNombre(), t.getDescripcion(),
                    t.getFecha(), t.getUsuario()));
        });
        return response;
    }
}
