package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.BandaOrganizada;
import com.SantiagoCento.PoliciaMetropolitana.repository.BandaOrganizadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandaOrganizadaService {

    @Autowired
    BandaOrganizadaRepository bandaOrganizadaRepository;

    public List<BandaOrganizada> getAllBandaOrganizadas() {
        return bandaOrganizadaRepository.findAll();
    }

    public List<Integer> getAllIds() {
        return getAllBandaOrganizadas()
                .stream()
                .map(BandaOrganizada::getNroBanda)
                .collect(Collectors.toList());
    }

    public BandaOrganizada createBandaOrganizada(BandaOrganizada bandaOrganizada) {

        return bandaOrganizadaRepository.save(bandaOrganizada);
    }

    public BandaOrganizada getBandaOrganizadaById(int bandaOrganizadaId) {
        return bandaOrganizadaRepository.findById(bandaOrganizadaId).orElseThrow(() -> new ResourceNotFoundException("bandaOrganizada", "id", bandaOrganizadaId));
    }

    public BandaOrganizada updateBandaOrganizada(int bandaOrganizadaId, BandaOrganizada bandaOrganizadaDetails) {

        BandaOrganizada bandaOrganizada = bandaOrganizadaRepository.findById(bandaOrganizadaId).orElseThrow(() -> new ResourceNotFoundException("bandaOrganizada", "id", bandaOrganizadaId));

        bandaOrganizada.setNroBanda(bandaOrganizadaDetails.getNroBanda());
        bandaOrganizada.setCantMiembros(bandaOrganizadaDetails.getCantMiembros());

        BandaOrganizada updatedBandaOrganizada = bandaOrganizadaRepository.save(bandaOrganizada);
        return updatedBandaOrganizada;
    }

    public ResponseEntity<?> deleteBandaOrganizada(int bandaOrganizadaId) {
        BandaOrganizada bandaOrganizada = bandaOrganizadaRepository.findById(bandaOrganizadaId)
                .orElseThrow(() -> new ResourceNotFoundException("bandaOrganizada", "id", bandaOrganizadaId));

        bandaOrganizadaRepository.delete(bandaOrganizada);

        return ResponseEntity.ok().build();
    }
}
