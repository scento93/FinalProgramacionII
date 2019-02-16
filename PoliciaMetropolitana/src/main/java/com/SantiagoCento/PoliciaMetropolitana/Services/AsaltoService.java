package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.Asalto;
import com.SantiagoCento.PoliciaMetropolitana.repository.AsaltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsaltoService {

    @Autowired
    AsaltoRepository asaltoRepository;

    public List<Asalto> getAllAsaltos() {
        return asaltoRepository.findAll();
    }

    public Asalto createAsalto(Asalto asalto) {
        return asaltoRepository.save(asalto);
    }

    public List<Asalto> getAsaltoBySucursal(int sucursalId) {
        return asaltoRepository.findAsaltoBySucursalAsalto(sucursalId);
    }

    public List<Asalto> getAsaltoByDetenido(int claveDetenidoId) {
        return asaltoRepository.findAsaltoByClaveDetenido(claveDetenidoId);
    }

    public Asalto updateAsalto(int asaltoId, Asalto asaltoDetails) {

        Asalto asalto = asaltoRepository.findById(asaltoId).orElseThrow(() -> new ResourceNotFoundException("asalto", "id", asaltoId));

        asalto.setFechaAsalto(asaltoDetails.getFechaAsalto());
        asalto.setSucursalAsalto(asaltoDetails.getSucursalAsalto());
        asalto.setClaveDetenido(asaltoDetails.getClaveDetenido());
        asalto.setCondenado(asaltoDetails.isCondenado());
        asalto.setCondena(asaltoDetails.getCondena());
        asalto.setJuezEncargado(asaltoDetails.getJuezEncargado());

        Asalto updatedAsalto = asaltoRepository.save(asalto);
        return updatedAsalto;
    }

    public ResponseEntity<?> deleteAsalto(int asaltoId) {
        Asalto asalto = asaltoRepository.findById(asaltoId)
                .orElseThrow(() -> new ResourceNotFoundException("asalto", "id", asaltoId));

        asaltoRepository.delete(asalto);

        return ResponseEntity.ok().build();
    }
}
