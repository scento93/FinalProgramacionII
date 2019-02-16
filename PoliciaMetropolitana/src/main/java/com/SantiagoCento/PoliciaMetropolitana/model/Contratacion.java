package com.SantiagoCento.PoliciaMetropolitana.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "contratacion")
public class Contratacion {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @NotNull
    private int codSucursal;
    @NotNull
    private int codVigilante;
    @NotNull
    private boolean conArma;

    public Contratacion(@NotNull LocalDate fecha, @NotNull int codSucursal, @NotNull int codVigilante, @NotNull boolean conArma) {
        this.fecha = fecha;
        this.codSucursal = codSucursal;
        this.codVigilante = codVigilante;
        this.conArma = conArma;
    }

    public Contratacion() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(int codSucursal) {
        this.codSucursal = codSucursal;
    }

    public boolean isConArma() {
        return conArma;
    }

    public void setConArma(boolean conArma) {
        this.conArma = conArma;
    }

    public int getCodVigilante() {
        return codVigilante;
    }

    public void setCodVigilante(int codVigilante) {
        this.codVigilante = codVigilante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
