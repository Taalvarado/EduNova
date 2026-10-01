package gt.edu.url.edunova_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("participante", new Participante());
        return "formulario";
    }

    @PostMapping
    public String guardarParticipante(@ModelAttribute Participante participante) {
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