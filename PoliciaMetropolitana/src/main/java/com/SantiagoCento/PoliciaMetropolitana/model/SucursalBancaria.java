package com.SantiagoCento.PoliciaMetropolitana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sucursalBancaria")
public class SucursalBancaria {

    @Id
    private int codigo;

    @NotNull
    private int nroEmpleados;

    @NotNull
    private String direccion;

    @NotNull
    private int entidadCentral;

    public SucursalBancaria(int codigo, @NotNull int nroEmpleados, @NotNull String direccion, @NotNull int entidadCentral) {
        this.codigo = codigo;
        this.nroEmpleados = nroEmpleados;
        this.direccion = direccion;
        this.entidadCentral = entidadCentral;
    }

    public SucursalBancaria() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNroEmpleados() {
        return nroEmpleados;
    }

    public void setNroEmpleados(int nroEmpleados) {
        this.nroEmpleados = nroEmpleados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEntidadCentral() {
        return entidadCentral;
    }

    public void setEntidadCentral(int entidadCentral) {
        this.entidadCentral = entidadCentral;
    }
}
