package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.Asalto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsaltoRepository extends JpaRepository<Asalto,Integer> {
    List<Asalto> findAsaltoBySucursalAsalto(int codSucursal);
    List<Asalto> findAsaltoByClaveDetenido(int claveDetenido);
}
