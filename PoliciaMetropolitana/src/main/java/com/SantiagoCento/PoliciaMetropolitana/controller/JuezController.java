package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.JuezService;
import com.SantiagoCento.PoliciaMetropolitana.model.Juez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class JuezController {

    @Autowired
    JuezService juezService;


    @GetMapping("/juez")
    public String getAllJueces(Model model) {
        model.addAttribute("jueces", juezService.getAllJueces());
        return "api/juez";
    }

    @PostMapping("/juez")
    public String createJuez(@Valid @ModelAttribute(name="JuezForm") Juez juez) {
        juezService.createJuez(juez);
        return "redirect:/api/juez";
    }


    //en el html, el name del input tiene que ser igual al nombre de los atributos del objeto, si no no se puden sacar los datos del modelAttribute
    @PostMapping("/editarJuez")
    public String updateJuez(@Valid @ModelAttribute(name="JuezForm") Juez juezDetails) {
        juezService.updateJuez(juezDetails.getClaveJuzgado(), juezDetails);
        return "redirect:/api/juez";
    }

    @GetMapping("/juez/{id}")
    public String getJuezById(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("jueces", juezService.getJuezById(id));
        return "fragments/resultSearchJuez :: resultsList";
    }

    @DeleteMapping("/juez/{id}")
    public ResponseEntity<?> deleteJuez(@PathVariable(value = "id") int id) {
        juezService.deleteJuez(id);
        return ResponseEntity.ok().build();
    }
}
