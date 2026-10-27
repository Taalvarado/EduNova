package gt.edu.url.edunova_spring.service;

import gt.edu.url.edunova_spring.model.Participante;
import gt.edu.url.edunova_spring.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    // Lista todos los participantes
    public List<Participante> listarTodos() {
        return participanteRepository.findAll();
    }

    // Guarda o actualiza un participante
    public Participante guardar(Participante participante) {
        return participanteRepository.save(participante);
    }

    // Busca un participante por su ID (usado en editar)
    public Optional<Participante> buscarPorId(Long id) {
        return participanteRepository.findById(id);
    }

    // Elimina un participante por su ID
    public void eliminar(Long id) {
        participanteRepository.deleteById(id);
    }

    // Cuenta el total de participantes (por si lo usas en el dashboard o vistas)
    public long contar() {
        return participanteRepository.count();
    }
}