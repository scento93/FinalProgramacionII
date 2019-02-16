package com.SantiagoCento.PoliciaMetropolitana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "juez")
public class Juez {

    @Id
    private int claveJuzgado;

    @NotNull
    private String nombre;

    @NotNull
    private int anosServicio;

    public Juez(int claveJuzgado, String nombre, int anosServicio) {
        this.claveJuzgado = claveJuzgado;
        this.nombre = nombre;
        this.anosServicio = anosServicio;
    }

    public Juez() {
    }

    public int getClaveJuzgado() {
        return claveJuzgado;
    }

    public void setClaveJuzgado(int claveJuzgado) {
        this.claveJuzgado = claveJuzgado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnosServicio() {
        return anosServicio;
    }

    public void setAnosServicio(int anosServicio) {
        this.anosServicio = anosServicio;
    }

}
