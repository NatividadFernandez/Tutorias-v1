package org.iesalandalus.programacion.tutorias.mvc.modelo;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.*;
import org.iesalandalus.programacion.tutorias.mvc.modelo.negocio.*;

public class Modelo {

	private Alumnos alumnos;
	private Citas citas;
	private Profesores profesores;
	private Sesiones sesiones;
	private Tutorias tutorias;

	public Modelo() {
		alumnos = new Alumnos();
		citas = new Citas();
		profesores = new Profesores();
		sesiones = new Sesiones();
		tutorias = new Tutorias();
	}

	// Alumno
	public void insertar(Alumno alumno) throws OperationNotSupportedException {
		alumnos.insertar(alumno);
	}

	public Alumno buscar(Alumno alumno) {
		return alumnos.buscar(alumno);
	}

	public void borrar(Alumno alumno) throws OperationNotSupportedException {
		List<Cita> citasAlumno = citas.get(alumno);
		for(Cita cita : citasAlumno) {
			citas.borrar(cita);
		}
		alumnos.borrar(alumno);
	}

	public List<Alumno> getAlumnos() {
		return alumnos.get();
	}

	// Profesor
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		profesores.insertar(profesor);
	}

	public Profesor buscar(Profesor profesor) {
		return profesores.buscar(profesor);
	}

	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		List<Tutoria> citasProfesor = tutorias.get(profesor);
		for(Tutoria tutoria : citasProfesor) {
			tutorias.borrar(tutoria);
		}
		profesores.borrar(profesor);
	}

	public List<Profesor> getProfesores() {
		return profesores.get();
	}

	// Tutoría
	public void insertar(Tutoria tutoria) throws OperationNotSupportedException {
		if (tutoria == null) {
			throw new NullPointerException("ERROR: No se puede insertar una tutoría nula.");
		}

		Profesor profesor = profesores.buscar(tutoria.getProfesor());
		if (profesor == null) {
			throw new OperationNotSupportedException("ERROR: No existe el profesor de esta tutoría.");
		}
		tutorias.insertar(new Tutoria(profesor, tutoria.getNombre()));
	}

	public Tutoria buscar(Tutoria tutoria) {
		return tutorias.buscar(tutoria);
	}

	public void borrar(Tutoria tutoria) throws OperationNotSupportedException {
		List<Sesion> sesionesTutoria = sesiones.get(tutoria);
		for(Sesion sesion : sesionesTutoria) {
			borrar(sesion);
		}
		tutorias.borrar(tutoria);
	}

	public List<Tutoria> getTutorias() {
		return tutorias.get();
	}

	public List<Tutoria> getTutorias(Profesor profesor) {
		return tutorias.get(profesor);
	}

	// Sesion
	public void insertar(Sesion sesion) throws OperationNotSupportedException {
		if (sesion == null) {
			throw new NullPointerException("ERROR: No se puede insertar una sesión nula.");
		}

		Tutoria tutoria = tutorias.buscar(sesion.getTutoria());
		if (tutoria == null) {
			throw new OperationNotSupportedException("ERROR: No existe la tutoría de esta sesión.");
		}

		sesiones.insertar(new Sesion(tutoria, sesion.getFecha(), sesion.getHoraInicio(), sesion.getHoraFin(),
				sesion.getMinutosDuracion()));
	}

	public Sesion buscar(Sesion sesion) {
		return sesiones.buscar(sesion);
	}

	public void borrar(Sesion sesion) throws OperationNotSupportedException {
		List<Cita> citasSesion = citas.get(sesion);
		for(Cita cita : citasSesion) {
			citas.borrar(cita);
		}
		sesiones.borrar(sesion);
	}

	public List<Sesion> getSesiones() {
		return sesiones.get();
	}

	public List<Sesion> getSesiones(Tutoria tutoria) {
		return sesiones.get(tutoria);
	}

	// Cita
	public void insertar(Cita cita) throws OperationNotSupportedException {
		if (cita == null) {
			throw new NullPointerException("ERROR: No se puede insertar una cita nula.");
		}
		Alumno alumno = alumnos.buscar(cita.getAlumno());
		if (alumno == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alumno de esta cita.");
		}
		
		Sesion sesion = sesiones.buscar(cita.getSesion());
		if (sesion == null) {
			throw new OperationNotSupportedException("ERROR: No existe la sesión de esta cita.");
		}
		
		citas.insertar(new Cita(alumno, sesion, cita.getHora()));
	}

	public Cita buscar(Cita cita) {
		return citas.buscar(cita);
	}

	public void borrar(Cita cita) throws OperationNotSupportedException {
		citas.borrar(cita);
	}

	public List<Cita> getCitas() {
		return citas.get();
	}

	public List<Cita> getCitas(Sesion sesion) {
		return citas.get(sesion);
	}

	public List<Cita> getCitas(Alumno alumno) {
		return citas.get(alumno);
	}

}
