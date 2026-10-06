package gt.edu.url.edunova_spring.model;

public class Participante {
    private String nombre;
    private String curso;
    private String telefono;

    // Constructor vacío (OBLIGATORIO)
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