package com.cos4h.gestionCursos.Controller;

import com.cos4h.gestionCursos.Entities.Curso;
import com.cos4h.gestionCursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CursoController {
  @Autowired
  CursoRepository cursoRepository;

  @GetMapping
  public String home() {
    return "redirect:/cursos";
  }

  @GetMapping("/cursos")
  public String listarCursos(Model model) {
    List<Curso> cursos = cursoRepository.findAll();
    model.addAttribute("cursos", cursos);
    return "cursos";
  }

  @GetMapping("/cursos/nuevo")
  public String formularioCrearCurso(Model model) {
    Curso curso = new Curso();
    curso.setPublicado(true);
    model.addAttribute("curso", curso);
    model.addAttribute("pageTitle", "Nuevo curso");
    return "nuevo_fmr";
  }

  @PostMapping("/cursos/save")
  public String guardarCurso(Curso curso, RedirectAttributes redirectAttributes) {
    try {
      cursoRepository.save(curso);
      redirectAttributes.addAttribute("message", "El curso ha sido guardado con exito");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }
    return "redirect:/cursos";
  }
}
