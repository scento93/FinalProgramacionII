package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.SucursalBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalBancariaRepository extends JpaRepository<SucursalBancaria,Integer> {

}
