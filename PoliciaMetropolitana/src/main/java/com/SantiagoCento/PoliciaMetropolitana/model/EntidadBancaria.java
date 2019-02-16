package com.SantiagoCento.PoliciaMetropolitana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entidadBancaria")
public class EntidadBancaria {

    @Id
    private int codigo;

    @NotNull
    private String domicilioCentral;


    public EntidadBancaria(int codigo, String domicilioCentral) {
        this.codigo = codigo;
        this.domicilioCentral = domicilioCentral;
    }

    public EntidadBancaria(){
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDomicilioCentral() {
        return domicilioCentral;
    }

    public void setDomicilioCentral(String domicilioCentral) {
        this.domicilioCentral = domicilioCentral;
    }
    
}
