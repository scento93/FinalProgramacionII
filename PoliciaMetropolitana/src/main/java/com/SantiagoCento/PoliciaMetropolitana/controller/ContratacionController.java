package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.ContratacionService;
import com.SantiagoCento.PoliciaMetropolitana.Services.SucursalBancariaService;
import com.SantiagoCento.PoliciaMetropolitana.Services.VigilanteService;
import com.SantiagoCento.PoliciaMetropolitana.model.Contratacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class ContratacionController {

    @Autowired
    ContratacionService contratacionService;

    @Autowired
    VigilanteService vigilanteService;

    @Autowired
    SucursalBancariaService sucursalBancariaService;

    @GetMapping("/contratacion")
    public String getAllContrataciones(Model model) {
        model.addAttribute("contrataciones", contratacionService.getAllContrataciones());
        model.addAttribute("sucursales", sucursalBancariaService.getAllIds());
        model.addAttribute("vigilantes", vigilanteService.getAllIds());

        return "api/contratacion";
    }

    @PostMapping("/contratacion")
    public String createContratacion(@Valid @ModelAttribute(name="ContratacionForm") Contratacion contratacion) {
        contratacionService.createContratacion(contratacion);

        return "redirect:/api/contratacion";
    }

    @GetMapping("/contratacion/sucursal/{id}")
    public String getContratacionBySucursal(@PathVariable(value = "id") int contratacionId, Model model) {
        model.addAttribute("contrataciones",contratacionService.getContratacionesBySucursal(contratacionId));
        return "fragments/resultSearchContratacion :: resultsList";
    }

    @GetMapping("/contratacion/vigilante/{id}")
    public String getContratacionByVigilante(@PathVariable(value = "id") int contratacionId, Model model) {
        model.addAttribute("contrataciones",contratacionService.getContratacionesByVigilante(contratacionId));
        return "fragments/resultSearchContratacion :: resultsList";
    }

    @PostMapping("/editarContratacion")
    public String updateContratacion(@Valid @ModelAttribute(name="ContratacionEditForm") Contratacion contratacionDetails) {
        contratacionService.updateContratacion(contratacionDetails.getId(), contratacionDetails);
        return "redirect:/api/contratacion";
    }

    @DeleteMapping("/contratacion/{id}")
    public ResponseEntity<?> deleteContratacion(@PathVariable(value = "id") int contratacionId) {
        contratacionService.deleteContratacion(contratacionId);

        return ResponseEntity.ok().build();
    }
}
