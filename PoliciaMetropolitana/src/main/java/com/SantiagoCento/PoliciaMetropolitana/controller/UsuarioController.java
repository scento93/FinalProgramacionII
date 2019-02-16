package com.SantiagoCento.PoliciaMetropolitana.controller;

import com.SantiagoCento.PoliciaMetropolitana.Services.UsuarioService;
import com.SantiagoCento.PoliciaMetropolitana.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/administrador")
    public String getAllAdministradores(Model model) {
        model.addAttribute("administradores", usuarioService.getAllAdministradores());
        return "api/administrador";
    }

    @GetMapping("/investigador")
    public String getAllInvestigadores(Model model) {
        model.addAttribute("investigadores", usuarioService.getAllInvestigadores());
        return "api/investigador";
    }

    @PostMapping("/administrador")
    public String createAdministrador(@Valid @ModelAttribute(name="UsuarioForm") Usuario usuario) {
        usuarioService.createAdministrador(usuario);
        return "redirect:/api/administrador";
    }

    @PostMapping("/investigador")
    public String createInvestigador(@Valid @ModelAttribute(name="UsuarioForm") Usuario usuario) {
        usuarioService.createInvestigador(usuario);
        return "redirect:/api/investigador";
    }


    @GetMapping("/usuario/{id}")
    public String getUsuarioById(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarioById(id));
        return "fragments/resultSearchUsuario :: resultsList";
    }

    //en el html, el name del input tiene que ser igual al nombre de los atributos del objeto, si no no se puden sacar los datos del modelAttribute
    @PostMapping("/editarAdministrador")
    public String updateAdministrador(@Valid @ModelAttribute(name="UsuarioForm") Usuario usuarioDetails) {
        usuarioService.updateUsuario(usuarioDetails.getId(), usuarioDetails);
        return "redirect:/api/administrador";
    }

    @PostMapping("/editarInvestigador")
    public String updateInvestigador(@Valid @ModelAttribute(name="UsuarioForm") Usuario usuarioDetails) {
        usuarioService.updateUsuario(usuarioDetails.getId(), usuarioDetails);
        return "redirect:/api/investigador";
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") int id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }

}
