package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.EntidadBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadBancariaRepository  extends JpaRepository<EntidadBancaria, Integer>{

}
