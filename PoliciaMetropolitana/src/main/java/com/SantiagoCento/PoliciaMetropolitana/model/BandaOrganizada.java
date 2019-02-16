package com.SantiagoCento.PoliciaMetropolitana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bandaOrganizada")
public class BandaOrganizada{

    @Id
    private int nroBanda;

    @NotNull
    private int cantMiembros;

    public BandaOrganizada(int nroBanda, int cantMiembros) {
        this.nroBanda = nroBanda;
        this.cantMiembros = cantMiembros;
    }

    public BandaOrganizada() {
    }

    public int getNroBanda() {
        return nroBanda;
    }

    public void setNroBanda(int nroBanda) {
        this.nroBanda = nroBanda;
    }

    public int getCantMiembros() {
        return cantMiembros;
    }

    public void setCantMiembros(int cantMiembros) {
        this.cantMiembros = cantMiembros;
    }
    
}
