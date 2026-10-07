package gt.edu.url.edunova_spring.controller;

import gt.edu.url.edunova_spring.model.Participante;
import gt.edu.url.edunova_spring.service.ParticipanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public String listarParticipantes(Model model) {
        model.addAttribute("participantes", participanteService.listarTodos());
        model.addAttribute("totalParticipantes", participanteService.contar());
        return "lista"; // Apunta a lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("participante", new Participante());
        return "formulario"; 
    }

    @PostMapping
    public String guardarParticipante(@Valid @ModelAttribute("participante") Participante participante,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "formulario"; // Vuelve a formulario.html si hay errores
        }
        participanteService.guardar(participante);
        return "redirect:/participantes";
    }
}