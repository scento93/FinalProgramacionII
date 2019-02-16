package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.Juez;
import com.SantiagoCento.PoliciaMetropolitana.repository.JuezRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JuezService {

    @Autowired
    JuezRepository juezRepository;

    public List<Juez> getAllJueces() {
        return juezRepository.findAll();
    }

    public List<Integer> getAllIds() {
        return getAllJueces()
                .stream()
                .map(Juez::getClaveJuzgado)
                .collect(Collectors.toList());
    }

    public Juez createJuez(Juez juez) {
        return juezRepository.save(juez);
    }

    public Juez getJuezById(int juezId) {
        return juezRepository.findById(juezId).orElseThrow(() -> new ResourceNotFoundException("juez", "id", juezId));
    }

    public Juez updateJuez(int juezId, Juez juezDetails) {

        Juez juez = juezRepository.findById(juezId).orElseThrow(() -> new ResourceNotFoundException("juez", "id", juezId));

        juez.setClaveJuzgado(juezDetails.getClaveJuzgado());
        juez.setNombre(juezDetails.getNombre());
        juez.setAnosServicio(juezDetails.getAnosServicio());

        Juez updatedJuez = juezRepository.save(juez);
        return updatedJuez;
    }

    public ResponseEntity<?> deleteJuez(int juezId) {
        Juez juez = juezRepository.findById(juezId)
                .orElseThrow(() -> new ResourceNotFoundException("juez", "id", juezId));

        juezRepository.delete(juez);

        return ResponseEntity.ok().build();
    }
}
