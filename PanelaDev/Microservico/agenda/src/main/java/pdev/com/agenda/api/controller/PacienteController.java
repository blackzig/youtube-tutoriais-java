package pdev.com.agenda.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.domain.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

	@PostMapping
	public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
		Paciente p = service.salvar(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}

	@GetMapping
	public ResponseEntity<List<Paciente>> listarTodos() {
		List<Paciente> pacientes = service.listarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(pacientes);
	}
}
