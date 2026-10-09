package gt.edu.url.edunova_spring.service;

import gt.edu.url.edunova_spring.model.Participante;
import gt.edu.url.edunova_spring.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> obtenerTodos() {
        return participanteRepository.findAll();
    }

    public void guardar(Participante participante) {
        participanteRepository.save(participante);
    }
}