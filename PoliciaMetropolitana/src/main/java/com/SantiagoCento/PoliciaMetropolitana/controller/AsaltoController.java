package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.AsaltoService;
import com.SantiagoCento.PoliciaMetropolitana.Services.DetenidoService;
import com.SantiagoCento.PoliciaMetropolitana.Services.JuezService;
import com.SantiagoCento.PoliciaMetropolitana.Services.SucursalBancariaService;
import com.SantiagoCento.PoliciaMetropolitana.model.Asalto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class AsaltoController {

    @Autowired
    AsaltoService asaltoService;

    @Autowired
    DetenidoService detenidoService;

    @Autowired
    SucursalBancariaService sucursalBancariaService;

    @Autowired
    JuezService juezService;

    @GetMapping("/asalto")
    public String getAllAsaltos(Model model) {
        model.addAttribute("asaltos", asaltoService.getAllAsaltos());
        model.addAttribute("sucursales", sucursalBancariaService.getAllIds());
        model.addAttribute("detenidos", detenidoService.getAllIds());
        model.addAttribute("jueces", juezService.getAllIds());

        return "api/asalto";
    }

    @PostMapping("/asalto")
    public String createAsalto(@Valid @ModelAttribute(name="AsaltoForm") Asalto asalto) {
        asaltoService.createAsalto(asalto);

        return "redirect:/api/asalto";
    }

    @GetMapping("/asalto/sucursal/{id}")
    public String getAsaltoBySucursal(@PathVariable(value = "id") int sucursalId, Model model) {
        model.addAttribute("asaltos",asaltoService.getAsaltoBySucursal(sucursalId));
        return "fragments/resultSearchAsalto :: resultsList";
    }

    @GetMapping("/asalto/detenido/{id}")
    public String getAsaltoByDetenido(@PathVariable(value = "id") int asaltoId, Model model) {
        model.addAttribute("asaltos",asaltoService.getAsaltoByDetenido(asaltoId));
        return "fragments/resultSearchAsalto :: resultsList";
    }

    @PostMapping("/editarAsalto")
    public String updateAsalto(@Valid @ModelAttribute(name="AsaltoEditForm") Asalto asaltoDetails) {
        asaltoService.updateAsalto(asaltoDetails.getId(), asaltoDetails);
        return "redirect:/api/asalto";
    }

    @DeleteMapping("/asalto/{id}")
    public ResponseEntity<?> deleteAsalto(@PathVariable(value = "id") int asaltoId) {
        asaltoService.deleteAsalto(asaltoId);

        return ResponseEntity.ok().build();
    }
}
