package com.oospina.pruebabackend.repositories;

import com.oospina.pruebabackend.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuariosRepo extends CrudRepository<Usuario, Long> {
}
