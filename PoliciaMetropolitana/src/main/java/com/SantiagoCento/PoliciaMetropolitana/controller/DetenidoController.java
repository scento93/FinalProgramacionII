package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.BandaOrganizadaService;
import com.SantiagoCento.PoliciaMetropolitana.Services.DetenidoService;
import com.SantiagoCento.PoliciaMetropolitana.model.Detenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/api")
public class DetenidoController {

    @Autowired
    DetenidoService detenidoService;

    @Autowired
    BandaOrganizadaService bandaOrganizadaService;

    @GetMapping("/detenido")
    public String getAllDetenidos(Model model) {
        model.addAttribute("detenidos", detenidoService.getAllDetenidos());
        model.addAttribute("bandas", bandaOrganizadaService.getAllIds());

        return "api/detenido";
    }

    @PostMapping("/detenido")
    public String createDetenido(@Valid @ModelAttribute(name="DetenidoForm") Detenido detenido) {
        detenidoService.createDetenido(detenido);

        return "redirect:/api/detenido";
    }

    @GetMapping("/detenido/{id}")
    public String getDetenidoById(@PathVariable(value = "id") int detenidoId, Model model) {
        model.addAttribute("detenidos",detenidoService.getDetenidoById(detenidoId));
        return "fragments/resultSearchDetenido :: resultsList";
    }

    @PostMapping("/editarDetenido")
    public String updateDetenido(@Valid @ModelAttribute(name="DetenidoForm") Detenido detenidoDetails) {
        detenidoService.updateDetenido(detenidoDetails.getClave(), detenidoDetails);
        return "redirect:/api/detenido";
    }

    @DeleteMapping("/detenido/{id}")
    public ResponseEntity<?> deleteDetenido(@PathVariable(value = "id") int detenidoId) {
        detenidoService.deleteDetenido(detenidoId);

        return ResponseEntity.ok().build();
    }
}
