/*
 * Esta clase representa la entidad de base de datos para la tabla "person".
 * Contiene información sobre una persona y su correspondencia en la base de datos.
 */
package com.app.apirest.models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * La anotación @Data de Lombok genera automáticamente getters, setters, toString(), equals() y hashCode() para la clase.
 * Las anotaciones @AllArgsConstructor y @NoArgsConstructor de Lombok generan automáticamente constructores con todos los campos y sin argumentos, respectivamente.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person")
public class PersonModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;
    private String email;
    private Integer numeroTelefono;
    private String ciudad;
    private String pais;
}
