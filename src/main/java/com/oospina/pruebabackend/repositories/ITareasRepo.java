package com.oospina.pruebabackend.repositories;

import com.oospina.pruebabackend.model.Tarea;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITareasRepo extends CrudRepository<Tarea, Long> {

    @Transactional
    @Modifying
    @Query("delete from Tarea where usuario is null")
    void actualizaTareas();

    @Transactional(readOnly = true)
    @Query("SELECT t FROM Tarea t where " +
            "(:usuario is null or t.usuario = :usuario) " +
            "and (:fromFecha is null or t.fecha >= :fromFecha) " +
            "and (:toFecha is null or t.fecha <= :toFecha)")
    List<Tarea> buscarPorCriterio(@Param("usuario") Long usuario,
                                  @Param("fromFecha") LocalDate fromFecha,
                                  @Param("toFecha") LocalDate toFecha);
}
