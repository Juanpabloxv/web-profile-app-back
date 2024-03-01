/*
 * Esta clase representa un objeto DTO (Data Transfer Object) para la entidad Persona.
 * Es utilizado para transferir datos relacionados con una persona entre las capas de la aplicación.
 */
package com.app.apirest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Integer numeroTelefono;
    private String ciudad;
    private String pais;
}
