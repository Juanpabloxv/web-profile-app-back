/*
 * Este controlador maneja las solicitudes relacionadas con las personas.
 * Proporciona puntos finales para realizar operaciones CRUD en personas.
 */
package com.app.apirest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.apirest.dto.PersonDTO;
import com.app.apirest.models.PersonModel;
import com.app.apirest.services.PersonService;

import lombok.AllArgsConstructor;

/*
 * Esta anotación permite solicitudes de origen cruzado desde cualquier dominio.
 */
@CrossOrigin
@AllArgsConstructor
/*
 * La anotación @RequestMapping especifica la ruta base para todos los endpoints definidos en este controlador.
 */
@RequestMapping("/api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    /*
     * Este método maneja las solicitudes GET para obtener una lista de todas las personas.
     * Retorna una lista iterable de objetos PersonModel.
     */
    @GetMapping
    public Iterable<PersonModel> list () {
        return personService.findAll();
    }

    /*
     * Este método maneja las solicitudes GET para obtener una persona por su ID.
     * Toma el ID de la persona como parámetro de la URL y retorna el objeto PersonModel correspondiente.
     */
    @GetMapping("{id}")
    public PersonModel get(@PathVariable Integer id) {
        return personService.findById(id);
    }

    /*
     * Este método maneja las solicitudes POST para crear una nueva persona.
     * Toma un objeto PersonDTO en el cuerpo de la solicitud y retorna el objeto PersonModel creado.
     * Retorna el código de estado HTTP 201 (CREATED) en caso de éxito.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public PersonModel create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    /*
     * Este método maneja las solicitudes PUT para actualizar una persona existente.
     * Toma el ID de la persona a actualizar como parámetro de la URL y un objeto PersonDTO en el cuerpo de la solicitud.
     * Retorna el objeto PersonModel actualizado.
     */
    @PutMapping("{id}")
    public PersonModel update(@PathVariable Integer id, 
    @RequestBody PersonDTO personDTO) {
        return personService.update(id,personDTO);
    }

    /*
     * Este método maneja las solicitudes DELETE para eliminar una persona por su ID.
     * Toma el ID de la persona como parámetro de la URL y no retorna ningún contenido.
     * Retorna el código de estado HTTP 204 (NO_CONTENT) en caso de éxito.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }
}
