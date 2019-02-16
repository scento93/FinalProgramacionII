package com.SantiagoCento.PoliciaMetropolitana.Services;

import com.SantiagoCento.PoliciaMetropolitana.exception.ResourceNotFoundException;
import com.SantiagoCento.PoliciaMetropolitana.model.SucursalBancaria;
import com.SantiagoCento.PoliciaMetropolitana.repository.SucursalBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalBancariaService {

    @Autowired
    SucursalBancariaRepository sucursalBancariaRepository;

    public List<SucursalBancaria> getAllSucursalesBancarias() {
        return sucursalBancariaRepository.findAll();
    }

    public SucursalBancaria createSucursalBancaria(SucursalBancaria sucursalBancaria) {

        return sucursalBancariaRepository.save(sucursalBancaria);
    }

    public List<Integer> getAllIds() {
        return getAllSucursalesBancarias()
                .stream()
                .map(SucursalBancaria::getCodigo)
                .collect(Collectors.toList());
    }

    public SucursalBancaria getSucursalBancariaById(int sucursalBancariaId) {
        return sucursalBancariaRepository.findById(sucursalBancariaId).orElseThrow(() -> new ResourceNotFoundException("sucursalBancaria", "id", sucursalBancariaId));
    }

    public SucursalBancaria updateSucursalBancaria(int sucursalBancariaId, SucursalBancaria sucursalBancariaDetails) {

        SucursalBancaria sucursalBancaria = sucursalBancariaRepository.findById(sucursalBancariaId).orElseThrow(() -> new ResourceNotFoundException("sucursalBancaria", "id", sucursalBancariaId));

        sucursalBancaria.setCodigo(sucursalBancariaDetails.getCodigo());
        sucursalBancaria.setNroEmpleados(sucursalBancariaDetails.getNroEmpleados());
        sucursalBancaria.setDireccion(sucursalBancariaDetails.getDireccion());
        sucursalBancaria.setEntidadCentral(sucursalBancariaDetails.getEntidadCentral());

        SucursalBancaria updatedSucursalBancaria = sucursalBancariaRepository.save(sucursalBancaria);
        return updatedSucursalBancaria;
    }

    public ResponseEntity<?> deleteSucursalBancaria(int sucursalBancariaId) {
        SucursalBancaria sucursalBancaria = sucursalBancariaRepository.findById(sucursalBancariaId)
                .orElseThrow(() -> new ResourceNotFoundException("sucursalBancaria", "id", sucursalBancariaId));

        sucursalBancariaRepository.delete(sucursalBancaria);

        return ResponseEntity.ok().build();
    }
}
