package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.Detenido;
import com.SantiagoCento.PoliciaMetropolitana.repository.DetenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetenidoService {
    @Autowired
    DetenidoRepository detenidoRepository;

    public List<Detenido> getAllDetenidos() {
        return detenidoRepository.findAll();
    }

    public List<Integer> getAllIds() {
        return getAllDetenidos()
                .stream()
                .map(Detenido::getClave)
                .collect(Collectors.toList());
    }

    public Detenido createDetenido(Detenido detenido) {

        return detenidoRepository.save(detenido);
    }

    public Detenido getDetenidoById(int detenidoId) {
        return detenidoRepository.findById(detenidoId).orElseThrow(() -> new ResourceNotFoundException("detenido", "id", detenidoId));
    }

    public Detenido updateDetenido(int detenidoId, Detenido detenidoDetails) {

        Detenido detenido = detenidoRepository.findById(detenidoId).orElseThrow(() -> new ResourceNotFoundException("detenido", "id", detenidoId));

        detenido.setClave(detenidoDetails.getClave());
        detenido.setNombreCompleto(detenidoDetails.getNombreCompleto());
        detenido.setBandaPertenece(detenidoDetails.getBandaPertenece());

        Detenido updatedDetenido = detenidoRepository.save(detenido);
        return updatedDetenido;
    }

    public ResponseEntity<?> deleteDetenido(int detenidoId) {
        Detenido detenido = detenidoRepository.findById(detenidoId)
                .orElseThrow(() -> new ResourceNotFoundException("detenido", "id", detenidoId));

        detenidoRepository.delete(detenido);

        return ResponseEntity.ok().build();
    }

}
