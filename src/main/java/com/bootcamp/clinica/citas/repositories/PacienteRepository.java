package com.bootcamp.clinica.citas.repositories;

import com.bootcamp.clinica.citas.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE UPPER(nombre) LIKE CONCAT('%',UPPER(:#{#nombre}),'%')  ")
    List<Paciente> find(String nombre);

//    @Query("SELECT p FROM Product p " +
//            "WHERE UPPER(p.name) LIKE CONCAT('%',UPPER(:#{#param.name}),'%') " +
//            "AND p.color=:#{#param.color} " +
//            "AND p.size=:#{#param.size} " +
//            "AND p.weight<:#{#param.weight}")
//    List<Product> findByParams(@Param("param") FindProductRequest param);

}
