package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.Role;
import com.SantiagoCento.PoliciaMetropolitana.model.Usuario;
import com.SantiagoCento.PoliciaMetropolitana.repository.RolesRepository;
import com.SantiagoCento.PoliciaMetropolitana.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolesRepository rolesRepository;

    public List<Usuario> getAllAdministradores() {
        return usuarioRepository.getAllByTipo("administrador");
    }

    public List<Usuario> getAllInvestigadores() {
        return usuarioRepository.getAllByTipo("investigador");
    }


    public Usuario createAdministrador(Usuario usuario) {
        Set<Role> roles = new HashSet<>();
        roles.add(rolesRepository.findByRoleId(1));
        roles.add(rolesRepository.findByRoleId(2));

        usuario.setTipo("administrador");

        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }

    public Usuario createInvestigador(Usuario usuario) {
        Set<Role> roles = new HashSet<>();

        roles.add(rolesRepository.findByRoleId(2));

        usuario.setTipo("investigador");

        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }

    public Usuario updateUsuario(int id, Usuario usuarioDetails) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));

        usuario.setId(usuarioDetails.getId());
        usuario.setPassword(usuarioDetails.getPassword());

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return updatedUsuario;
    }

    public ResponseEntity<?> deleteUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));

        usuarioRepository.delete(usuario);

        return ResponseEntity.ok().build();
    }
}
