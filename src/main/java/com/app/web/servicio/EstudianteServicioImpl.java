package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio{
	
	@Autowired
	private EstudianteRepositorio repositorio;
	@Override
	public List<Estudiante> ListarTodosLosEstudiantes() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}
	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantId(Long Id) {
		return repositorio.findById(Id).get();
	}
	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}
	@Override
	public void eliminarEstudiante(Long Id) {
		repositorio.deleteById(Id);
	}
}
