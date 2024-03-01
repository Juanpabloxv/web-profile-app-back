/*
 * Esta clase proporciona los servicios relacionados con las personas.
 * Contiene métodos para realizar operaciones CRUD en la base de datos para las entidades de persona.
 */
package com.app.apirest.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.apirest.dto.PersonDTO;
import com.app.apirest.models.PersonModel;
import com.app.apirest.repositories.PersonRepository;

import lombok.AllArgsConstructor;

/*
 * La anotación @AllArgsConstructor de Lombok genera automáticamente un constructor con todos los campos.
 * La anotación @Service de Spring indica que esta clase es un componente de servicio.
 */
@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper mapper;

    /*
     * Este método recupera todas las personas de la base de datos.
     * Retorna una lista iterable de objetos PersonModel.
     */
    public Iterable<PersonModel> findAll() {
        return personRepository.findAll();
    }

    /*
     * Este método busca una persona por su ID en la base de datos.
     * Toma el ID de la persona como parámetro y retorna el objeto PersonModel correspondiente.
     */
    public PersonModel findById(Integer id) {
        return personRepository
        .findById(id)
        .orElse(null);
    }

    /*
     * Este método crea una nueva persona en la base de datos.
     * Toma un objeto PersonDTO como parámetro, lo mapea a un objeto PersonModel y lo guarda en la base de datos.
     * Retorna el objeto PersonModel creado.
     */
    public PersonModel create(PersonDTO personDTO) {
        PersonModel personModel = mapper.map(personDTO, PersonModel.class);    
        return personRepository.save(personModel);
    }

    /*
     * Este método actualiza una persona existente en la base de datos.
     * Toma el ID de la persona a actualizar y un objeto PersonDTO con los nuevos datos.
     * Obtiene la persona de la base de datos, mapea los datos del DTO a la entidad y guarda los cambios.
     * Retorna el objeto PersonModel actualizado.
     */
    public PersonModel update(Integer id, PersonDTO personDTO) {
        PersonModel personFormDb = findById(id);

        mapper.map(personDTO, personFormDb);  

        return personRepository.save(personFormDb);
    }

    /*
     * Este método elimina una persona de la base de datos por su ID.
     * Toma el ID de la persona como parámetro, busca la persona en la base de datos y la elimina.
     */
    public void delete(@PathVariable Integer id) {
        PersonModel personFormDb = personRepository
        .findById(id)
        .orElse(null);
        personRepository.delete(personFormDb);
    }

}
