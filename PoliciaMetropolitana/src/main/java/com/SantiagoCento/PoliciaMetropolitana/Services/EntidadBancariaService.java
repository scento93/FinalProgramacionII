package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.EntidadBancaria;
import com.SantiagoCento.PoliciaMetropolitana.repository.EntidadBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntidadBancariaService {

    @Autowired
    EntidadBancariaRepository entidadBancariaRepository;

    public List<EntidadBancaria> getAllEntidadBancarias() {
        return entidadBancariaRepository.findAll();
    }

    public List<Integer> getAllIds() {
        return getAllEntidadBancarias()
                .stream()
                .map(EntidadBancaria::getCodigo)
                .collect(Collectors.toList());
    }

    public EntidadBancaria createEntidadBancaria(EntidadBancaria entidadBancaria) {

        return entidadBancariaRepository.save(entidadBancaria);
    }

    public EntidadBancaria getEntidadBancariaById(int entidadBancariaId) {
        return entidadBancariaRepository.findById(entidadBancariaId).orElseThrow(() -> new ResourceNotFoundException("entidadBancaria", "id", entidadBancariaId));
    }

    public EntidadBancaria updateEntidadBancaria(int entidadBancariaId, EntidadBancaria entidadBancariaDetails) {

        EntidadBancaria entidadBancaria = entidadBancariaRepository.findById(entidadBancariaId).orElseThrow(() -> new ResourceNotFoundException("entidadBancaria", "id", entidadBancariaId));

        entidadBancaria.setCodigo(entidadBancariaDetails.getCodigo());
        entidadBancaria.setDomicilioCentral(entidadBancariaDetails.getDomicilioCentral());

        EntidadBancaria updatedEntidadBancaria = entidadBancariaRepository.save(entidadBancaria);
        return updatedEntidadBancaria;
    }

    public ResponseEntity<?> deleteEntidadBancaria(int entidadBancariaId) {
        EntidadBancaria entidadBancaria = entidadBancariaRepository.findById(entidadBancariaId)
                .orElseThrow(() -> new ResourceNotFoundException("entidadBancaria", "id", entidadBancariaId));

        entidadBancariaRepository.delete(entidadBancaria);

        return ResponseEntity.ok().build();
    }
}
