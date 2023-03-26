package pdev.com.agenda.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.repository.PacienteRepository;

@Service
@Transactional
public class PacienteService {

	private final PacienteRepository pacienteRepository;
	
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

	public Paciente salvar(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	public List<Paciente> listarTodos() {
		try {
			return pacienteRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Optional<Paciente> buscarPorId(Long id) {
		return pacienteRepository.findById(id);
	}

	public void deletar(Long id) {
		pacienteRepository.deleteById(id);
	}

}
