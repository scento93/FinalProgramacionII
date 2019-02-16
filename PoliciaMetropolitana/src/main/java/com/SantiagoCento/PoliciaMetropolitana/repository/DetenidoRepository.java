package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.Detenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetenidoRepository extends JpaRepository<Detenido,Integer> {

}
