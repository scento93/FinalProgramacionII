package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.Contratacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratacionRepository extends JpaRepository<Contratacion,Integer> {
    List<Contratacion> findContratacionByCodSucursal(int codSucursal);
    List<Contratacion> findContratacionByCodVigilante(int codVigilante);
}
