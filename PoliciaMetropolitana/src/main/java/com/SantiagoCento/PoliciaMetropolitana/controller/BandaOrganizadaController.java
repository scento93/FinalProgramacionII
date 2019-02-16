package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.BandaOrganizadaService;
import com.SantiagoCento.PoliciaMetropolitana.model.BandaOrganizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class BandaOrganizadaController {

    @Autowired
    BandaOrganizadaService bandaOrganizadaService;


    @GetMapping("/bandaOrganizada")
    public String getAllBandaOrganizadas(Model model) {
        model.addAttribute("bandasOrganizadas", bandaOrganizadaService.getAllBandaOrganizadas());
        return "api/bandaOrganizada";
    }

    @PostMapping("/bandaOrganizada")
    public String createBandaOrganizada(@Valid @ModelAttribute(name="BandaForm") BandaOrganizada bandaOrganizada) {
        bandaOrganizadaService.createBandaOrganizada(bandaOrganizada);
        return "redirect:/api/bandaOrganizada";
    }


    //en el html, el name del input tiene que ser igual al nombre de los atributos del objeto, si no no se puden sacar los datos del modelAttribute
    @PostMapping("/editarBandaOrganizada")
    public String updateBandaOrganizada(@Valid @ModelAttribute(name="BandaForm") BandaOrganizada bandaOrganizadaDetails) {
        bandaOrganizadaService.updateBandaOrganizada(bandaOrganizadaDetails.getNroBanda(), bandaOrganizadaDetails);
        return "redirect:/api/bandaOrganizada";
    }

    @GetMapping("/bandaOrganizada/{id}")
    public String getBandaOrganizadaById(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("bandasOrganizadas", bandaOrganizadaService.getBandaOrganizadaById(id));
        return "fragments/resultSearchBanda :: resultsList";
    }

    @DeleteMapping("/bandaOrganizada/{id}")
    public ResponseEntity<?> deleteBandaOrganizada(@PathVariable(value = "id") int id) {
        bandaOrganizadaService.deleteBandaOrganizada(id);
        return ResponseEntity.ok().build();
    }

}