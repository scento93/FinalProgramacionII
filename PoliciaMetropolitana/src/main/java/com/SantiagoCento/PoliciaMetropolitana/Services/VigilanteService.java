package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.CustomUserDetails;
import com.SantiagoCento.PoliciaMetropolitana.model.Role;
import com.SantiagoCento.PoliciaMetropolitana.model.Vigilante;
import com.SantiagoCento.PoliciaMetropolitana.repository.RolesRepository;
import com.SantiagoCento.PoliciaMetropolitana.repository.VigilanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VigilanteService {

    @Autowired
    VigilanteRepository vigilanteRepository;

    @Autowired
    RolesRepository rolesRepository;

    public List<Vigilante> getAllVigilantes() {
        return vigilanteRepository.findAll();
    }

    public Vigilante createVigilante(Vigilante vigilante) {
        vigilante.setTipo("vigilante");

        Set<Role> roles = new HashSet<>();
        roles.add(rolesRepository.findByRoleId(3));

        vigilante.setRoles(roles);
        return vigilanteRepository.save(vigilante);
    }

    public List<Integer> getAllIds() {
        return getAllVigilantes()
                .stream()
                .map(Vigilante::getId)
                .collect(Collectors.toList());
    }


    public Vigilante getLoggedVigilanteData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails)auth.getPrincipal();
        return vigilanteRepository.findById(customUser.getId()).orElseThrow(() -> new ResourceNotFoundException("vigilante", "id", customUser.getId()));
    }

    public Vigilante getVigilanteById(int vigilanteId) {
        return vigilanteRepository.findById(vigilanteId).orElseThrow(() -> new ResourceNotFoundException("vigilante", "id", vigilanteId));
    }

    public Vigilante updateVigilante(int vigilanteId, Vigilante vigilanteDetails) {

        Vigilante vigilante = vigilanteRepository.findById(vigilanteId).orElseThrow(() -> new ResourceNotFoundException("vigilante", "id", vigilanteId));

        vigilante.setId(vigilanteDetails.getId());
        vigilante.setPassword(vigilanteDetails.getPassword());
        vigilante.setEdad(vigilanteDetails.getEdad());

        Vigilante updatedVigilante = vigilanteRepository.save(vigilante);
        return updatedVigilante;
    }

    public ResponseEntity<?> deleteVigilante(int vigilanteId) {
        Vigilante vigilante = vigilanteRepository.findById(vigilanteId)
                .orElseThrow(() -> new ResourceNotFoundException("vigilante", "id", vigilanteId));

        vigilanteRepository.delete(vigilante);

        return ResponseEntity.ok().build();
    }
}
