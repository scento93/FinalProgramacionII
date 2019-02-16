package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.Juez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuezRepository extends JpaRepository<Juez, Integer>{

}
