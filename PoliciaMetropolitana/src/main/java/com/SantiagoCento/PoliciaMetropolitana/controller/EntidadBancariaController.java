package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.EntidadBancariaService;
import com.SantiagoCento.PoliciaMetropolitana.model.EntidadBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaService entidadBancariaService;


    @GetMapping("/entidadBancaria")
    public String getAllEntidadBancarias(Model model) {
        model.addAttribute("entidadesBancarias", entidadBancariaService.getAllEntidadBancarias());
        return "api/entidadBancaria";
    }

    @PostMapping("/entidadBancaria")
    public String createEntidadBancaria(@Valid @ModelAttribute(name="entidadForm") EntidadBancaria entidadBancaria) {
        entidadBancariaService.createEntidadBancaria(entidadBancaria);
        return "redirect:/api/entidadBancaria";
    }


    //en el html, el name del input tiene que ser igual al nombre de los atributos del objeto, si no no se puden sacar los datos del modelAttribute
    @PostMapping("/editarEntidadBancaria")
    public String updateEntidadBancaria(@Valid @ModelAttribute(name="entidadForm") EntidadBancaria entidadBancariaDetails) {
        entidadBancariaService.updateEntidadBancaria(entidadBancariaDetails.getCodigo(), entidadBancariaDetails);
        return "redirect:/api/entidadBancaria";
    }

    @GetMapping("/entidadBancaria/{id}")
    public String getEntidadBancariaById(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("entidadesBancarias", entidadBancariaService.getEntidadBancariaById(id));
        return "fragments/resultSearchEntidad :: resultsList";
    }

    @DeleteMapping("/entidadBancaria/{id}")
    public ResponseEntity<?> deleteEntidadBancaria(@PathVariable(value = "id") int id) {
        entidadBancariaService.deleteEntidadBancaria(id);
        return ResponseEntity.ok().build();
    }
}
