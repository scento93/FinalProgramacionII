package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.EntidadBancariaService;
import com.SantiagoCento.PoliciaMetropolitana.Services.SucursalBancariaService;
import com.SantiagoCento.PoliciaMetropolitana.model.SucursalBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/api")
public class SucursalBancariaController {

    @Autowired
    SucursalBancariaService sucursalBancariaService;

    @Autowired
    EntidadBancariaService entidadBancariaService;

    @GetMapping("/sucursalBancaria")
    public String getAllSucursalesBancarias(Model model) {
        model.addAttribute("sucursales", sucursalBancariaService.getAllSucursalesBancarias());
        model.addAttribute("entidades", entidadBancariaService.getAllIds());

        return "api/sucursalBancaria";
    }

    @PostMapping("/sucursalBancaria")
    public String createSucursalBancaria(@Valid @ModelAttribute(name="SucursalForm") SucursalBancaria sucursalBancaria) {
        sucursalBancariaService.createSucursalBancaria(sucursalBancaria);

        return "redirect:/api/sucursalBancaria";
    }

    @GetMapping("/sucursalBancaria/{id}")
    public String getSucursalBancariaById(@PathVariable(value = "id") int sucursalBancariaId, Model model) {
        model.addAttribute("sucursales",sucursalBancariaService.getSucursalBancariaById(sucursalBancariaId));
        return "fragments/resultSearchSucursal :: resultsList";
    }

    @PostMapping("/editarSucursal")
    public String updateSucursalBancaria(@Valid @ModelAttribute(name="SucursalForm") SucursalBancaria sucursalBancariaDetails) {
        sucursalBancariaService.updateSucursalBancaria(sucursalBancariaDetails.getCodigo(), sucursalBancariaDetails);
        return "redirect:/api/sucursalBancaria";
    }

    @DeleteMapping("/sucursalBancaria/{id}")
    public ResponseEntity<?> deleteSucursalBancaria(@PathVariable(value = "id") int sucursalBancariaId) {
        sucursalBancariaService.deleteSucursalBancaria(sucursalBancariaId);

        return ResponseEntity.ok().build();
    }
}
