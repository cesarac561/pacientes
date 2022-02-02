package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class PacienteServiceImpl implements PacienteService {

    private PacienteRepository pacienteRepository;
    public PacienteServiceImpl(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> findByName(String nombre) {
        return this.pacienteRepository.find(nombre);
    }

    @Override
    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Override
    public Paciente findById(Long id) {
        return  this.pacienteRepository.findById(id).get();
    }

    @Override
    public Paciente save(Paciente paciente) {
        return this.pacienteRepository.save(paciente);
    }

//    @Override
//    public Paciente updateEspecialidad(Long id, String especialidad) {
//        var doctor = this.pacienteRepository.findById(id).get();
//        doctor.setEspecialidad(especialidad);
//        return this.pacienteRepository.save(doctor);
//    }

    @Override
    public void delete(Long id) {
        this.pacienteRepository.deleteById(id);
    }
}
