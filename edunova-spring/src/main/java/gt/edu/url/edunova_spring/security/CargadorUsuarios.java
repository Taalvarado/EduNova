package gt.edu.url.edunova_spring.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import gt.edu.url.edunova_spring.model.Usuario;
import gt.edu.url.edunova_spring.repository.UsuarioRepository;

@Component
public class CargadorUsuarios implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final String passwordAdmin;
    private final String passwordEntrenador;

    public CargadorUsuarios(UsuarioRepository usuarioRepository,
                            PasswordEncoder passwordEncoder,
                            @Value("${ADMIN_PASSWORD:Clave-Admin-2026}") String passwordAdmin,
                            @Value("${ENTRENADOR_PASSWORD:Clave-Entr-2026}") String passwordEntrenador) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordAdmin = passwordAdmin;
        this.passwordEntrenador = passwordEntrenador;
    }

    @Override
    public void run(String... args) {
        crearSiNoExiste("admin", passwordAdmin, "ADMIN");
        crearSiNoExiste("entrenador", passwordEntrenador, "ENTRENADOR");
    }

    private void crearSiNoExiste(String username, String passwordPlano, String rol) {
        if (usuarioRepository.findByUsername(username).isEmpty()) {
            String hash = passwordEncoder.encode(passwordPlano);
            usuarioRepository.save(new Usuario(username, hash, rol));
        }
    }
}