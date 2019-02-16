package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.Contratacion;
import com.SantiagoCento.PoliciaMetropolitana.repository.ContratacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratacionService {

    @Autowired
    ContratacionRepository contratacionRepository;

    public List<Contratacion> getAllContrataciones() {
        return contratacionRepository.findAll();
    }

    public Contratacion createContratacion(Contratacion contratacion) {

        return contratacionRepository.save(contratacion);
    }

    public List<Contratacion> getContratacionesBySucursal(int sucursalId) {
        return contratacionRepository.findContratacionByCodSucursal(sucursalId);
    }

    public List<Contratacion> getContratacionesByVigilante(int vigilanteId) {
        return contratacionRepository.findContratacionByCodVigilante(vigilanteId);
    }

    public Contratacion updateContratacion(int contratacionId, Contratacion contratacionDetails) {

        Contratacion contratacion = contratacionRepository.findById(contratacionId).orElseThrow(() -> new ResourceNotFoundException("contratacion", "id", contratacionId));

        contratacion.setCodSucursal(contratacionDetails.getCodSucursal());
        contratacion.setCodVigilante(contratacionDetails.getCodVigilante());
        contratacion.setConArma(contratacionDetails.isConArma());
        contratacion.setFecha(contratacionDetails.getFecha());

        Contratacion updatedContratacion = contratacionRepository.save(contratacion);
        return updatedContratacion;
    }

    public ResponseEntity<?> deleteContratacion(int contratacionId) {
        Contratacion contratacion = contratacionRepository.findById(contratacionId)
                .orElseThrow(() -> new ResourceNotFoundException("contratacion", "id", contratacionId));

        contratacionRepository.delete(contratacion);

        return ResponseEntity.ok().build();
    }
}
