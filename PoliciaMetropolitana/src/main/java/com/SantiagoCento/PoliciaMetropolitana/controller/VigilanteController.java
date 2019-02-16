package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.VigilanteService;
import com.SantiagoCento.PoliciaMetropolitana.model.Vigilante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/api")
public class VigilanteController {

    @Autowired
    VigilanteService vigilanteService;

    @GetMapping("/vigilante")
    public String getAllVigilantes(Model model) {
        model.addAttribute("vigilantes", vigilanteService.getAllVigilantes());
        return "api/vigilante";
    }

    @GetMapping("/ingresoVigilante")
    public String getLoggedVigilante(Model model) {
        model.addAttribute("vigilante", vigilanteService.getLoggedVigilanteData());
        return "api/ingresoVigilante";
    }

    @PostMapping("/vigilante")
    public String createVigilante(@Valid @ModelAttribute(name="vigilanteForm") Vigilante vigilante) {
        vigilanteService.createVigilante(vigilante);

        return "redirect:/api/vigilante";
    }

    @GetMapping("/vigilante/{id}")
    public String getVigilanteById(@PathVariable(value = "id") int vigilanteId, Model model) {
        model.addAttribute("vigilantes",vigilanteService.getVigilanteById(vigilanteId));
        return "fragments/resultSearchVigilante :: resultsList";
    }

    @PostMapping("/editarVigilante")
    public String updateVigilante(@Valid @ModelAttribute(name="VigilanteForm") Vigilante vigilanteDetails) {
        vigilanteService.updateVigilante(vigilanteDetails.getId(), vigilanteDetails);
        return "redirect:/api/vigilante";
    }

    @DeleteMapping("/vigilante/{id}")
    public ResponseEntity<?> deleteVigilante(@PathVariable(value = "id") int vigilanteId) {
        vigilanteService.deleteVigilante(vigilanteId);

        return ResponseEntity.ok().build();
    }

}
