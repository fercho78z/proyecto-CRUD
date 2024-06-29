package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping({"/"})
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.ListarTodosLosEstudiantes());
		return "Estudiantes"; 
	}
	
	
	@GetMapping({"/estudiante/nuevo"})
	public String crearEstudiantesForm(Model modelo) {
		modelo.addAttribute("estudiantes", new Estudiante());
		return "AltaEstudiante"; 
	}
	
	//la etiqueta estudiantes debe coicidir con el action del form y la referencia de object el ModelAttribute 
	@PostMapping({"/estudiantes"})
	public String guardarEstudiantes(@ModelAttribute("estudiante") Estudiante estudiante) {
		
		servicio.guardarEstudiante(estudiante);
		return "redirect:/"; 
	}

	@GetMapping({"/estudiantes/editar/{id}"})
	public String mostrarEstudiantesFormEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiantes", servicio.obtenerEstudiantId(id));
		return "EditarEstudiante"; 
	}
	
	@PostMapping({"/estudiantes/{id}"})
	public String actualizarEstudiantes(@PathVariable Long id,@ModelAttribute("estudiante") Estudiante estudiante, Model modelo)  {
		Estudiante estudianteesxitente=servicio.obtenerEstudiantId(id);	
		estudianteesxitente.setId(id);
		estudianteesxitente.setNombre(estudiante.getNombre());
		estudianteesxitente.setApellido(estudiante.getApellido());
		estudianteesxitente.setEmail(estudiante.getEmail());
		servicio.actualizarEstudiante(estudianteesxitente);
		return "redirect:/"; 
	}
	@GetMapping("/estudiantes/{id}")
	public String eliminarPersona(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/";
	}
}
