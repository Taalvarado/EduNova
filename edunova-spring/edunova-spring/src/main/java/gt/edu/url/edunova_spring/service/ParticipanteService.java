package gt.edu.url.edunova_spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import gt.edu.url.edunova_spring.model.Participante;

@Service
public class ParticipanteService {

    private final List<Participante> participantes = new ArrayList<>();

    public void guardar(Participante participante) {
        participantes.add(participante);
    }

    public List<Participante> listarTodos() {
        return participantes;
    }

    public int contar() {
        return participantes.size();
    }
}