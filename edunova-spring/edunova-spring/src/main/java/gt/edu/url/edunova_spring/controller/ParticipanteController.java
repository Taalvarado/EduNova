package gt.edu.url.edunova_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import gt.edu.url.edunova_spring.model.Participante;
import gt.edu.url.edunova_spring.service.ParticipanteService;

@Controller
@RequestMapping("/participantes")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        // Aseguramos que el objeto participante esté presente para el formulario
        if (!model.containsAttribute("participante")) {
            model.addAttribute("participante", new Participante());
        }
        return "formulario";
    }

    @PostMapping
    public String guardarParticipante(@Valid @ModelAttribute Participante participante, BindingResult resultado, Model model) {
        // Si hay errores de validación, regresamos al formulario sin hacer el guardado y sin redirigir
        if (resultado.hasErrors()) {
            return "formulario";
        }
        participanteService.guardar(participante);
        return "redirect:/participantes";
    }

    @GetMapping
    public String listarParticipantes(Model model) {
        model.addAttribute("participantes", participanteService.listarTodos());
        model.addAttribute("total", participanteService.contar());
        return "lista";
    }
}