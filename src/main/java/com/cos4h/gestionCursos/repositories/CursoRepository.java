package com.cos4h.gestionCursos.repositories;

import com.cos4h.gestionCursos.Entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
