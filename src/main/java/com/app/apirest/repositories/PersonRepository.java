/*
 * Esta interfaz define un repositorio para la entidad de persona.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos para las entidades de persona.
 */
package com.app.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.apirest.models.PersonModel;

@Repository
public interface PersonRepository extends  CrudRepository <PersonModel, Integer>{
}
