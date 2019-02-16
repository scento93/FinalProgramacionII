package com.SantiagoCento.PoliciaMetropolitana.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "asalto")
public class Asalto{

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAsalto;
    @NotNull
    private int sucursalAsalto;
    @NotNull
    private int claveDetenido;
    @NotNull
    private int juezEncargado;
    @NotNull
    private boolean condenado;

    private String condena;

    public Asalto(LocalDate fechaAsalto, int sucursalAsalto, int claveDetenido, int juezEncargado, boolean condenado, String condena) {
        this.fechaAsalto = fechaAsalto;
        this.sucursalAsalto = sucursalAsalto;
        this.claveDetenido = claveDetenido;
        this.juezEncargado = juezEncargado;
        this.condenado = condenado;
        this.condena = condena;
    }

    public Asalto() {
    }
    
    public LocalDate getFechaAsalto() {
        return fechaAsalto;
    }

    public void setFechaAsalto(LocalDate fechaAsalto) {
        this.fechaAsalto = fechaAsalto;
    }

    public int getSucursalAsalto() {
        return sucursalAsalto;
    }

    public void setSucursalAsalto(int sucursalAsalto) {
        this.sucursalAsalto = sucursalAsalto;
    }

    public int getClaveDetenido() {
        return claveDetenido;
    }

    public void setClaveDetenido(int claveDetenido) {
        this.claveDetenido = claveDetenido;
    }

    public int getJuezEncargado() {
        return juezEncargado;
    }

    public void setJuezEncargado(int juezEncargado) {
        this.juezEncargado = juezEncargado;
    }

    public boolean isCondenado() {
        return condenado;
    }

    public void setCondenado(boolean condenado) {
        this.condenado = condenado;
    }

    public String getCondena() {
        return condena;
    }

    public void setCondena(String condena) {
        this.condena = condena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
