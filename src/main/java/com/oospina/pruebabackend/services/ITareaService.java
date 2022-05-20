package com.oospina.pruebabackend.services;

import com.oospina.pruebabackend.dtos.CriteriaDto;
import com.oospina.pruebabackend.dtos.CriteriaResponseTareaDto;
import com.oospina.pruebabackend.dtos.TareaDto;

import java.util.List;

public interface ITareaService {

    List<CriteriaResponseTareaDto> buscarPorCriterio(CriteriaDto criteria);
}
