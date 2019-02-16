package com.SantiagoCento.PoliciaMetropolitana.repository;

import com.SantiagoCento.PoliciaMetropolitana.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(int id);

    List<Usuario> getAllByTipo(String tipo);
}