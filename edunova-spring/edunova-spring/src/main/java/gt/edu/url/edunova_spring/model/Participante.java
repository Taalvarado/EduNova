package gt.edu.url.edunova_spring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Participante {

    @NotBlank(message = "El nombre del participante es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    private String nombre;

    @NotBlank(message = "Debes seleccionar o indicar un curso.")
    private String curso;

    @NotBlank(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "[0-9]{8}", message = "El teléfono debe tener exactamente 8 dígitos, sin espacios ni guiones.")
    private String telefono;

    // Constructor vacío 
    public Participante() {
    }

    // Constructor parametrizado
    public Participante(String nombre, String curso, String telefono) {
        this.nombre = nombre;
        this.curso = curso;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}