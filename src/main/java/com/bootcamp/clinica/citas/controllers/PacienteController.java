package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.services.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> findAll(){
        System.out.println("call findALl");
        return this.pacienteService.findAll();
    }

//    @GetMapping("/find")
//    public List<Paciente> find(){
//        System.out.println("find");
//        return this.pacienteService.findAll();
//    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.pacienteService.findById(id);
    }

//    @GetMapping("/{edad}/{nombre}")
//    public Paciente findById(@PathVariable("edad") Long edad,@PathVariable("nombre") Long nombre ){
//        System.out.println("id = " + id);
//        return this.pacienteService.findById(id);
//    }


    @GetMapping("/buscar")
    public List<Paciente> findByName(@RequestParam("nombre") String nombre){
        System.out.println("nombre = " + nombre);
        return this.pacienteService.findByName(nombre);
    }

    @PostMapping
    public Paciente save(@RequestBody Paciente paciente){
        return this.pacienteService.save(paciente);
    }
//
//    @PutMapping
//    public Paciente update(@RequestBody Paciente doctor){
//        return this.pacienteService.save(doctor);
//    }

//    @PatchMapping("/especialidad/{id}/{especialidad}")
//    public Paciente update(@PathVariable("id") Long id, @PathVariable("especialidad") String especialidad){
//        System.out.println("especialidad = " + especialidad);
//        return this.pacienteService.updateEspecialidad(id, especialidad);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.pacienteService.delete(id);
    }

}
