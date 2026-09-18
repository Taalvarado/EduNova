package gt.edu.url.edunova;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidaController {

    @GetMapping("/api/saludo")
    public String saludo() {
        return "¡Bienvenido(a) a EduNova - Sistema de Gestión de Capacitación Interna!";
    }

    @GetMapping("/api/bienvenida")
    public String bienvenida(@RequestParam(value = "nombre", defaultValue = "Usuario") String nombre) {
        return "¡Bienvenido(a) " + nombre + " al portal de EduNova!";
    }
}