package com.SantiagoCento.PoliciaMetropolitana.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vigilantes")
@EntityListeners(AuditingEntityListener.class)
public class Vigilante extends Usuario {

    @NotNull(message = "Por Favor, Ingrese la edad")
    private Long edad;

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }
}
