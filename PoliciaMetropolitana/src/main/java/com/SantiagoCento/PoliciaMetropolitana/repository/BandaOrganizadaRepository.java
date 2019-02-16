package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.BandaOrganizada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandaOrganizadaRepository extends JpaRepository<BandaOrganizada, Integer> {

}