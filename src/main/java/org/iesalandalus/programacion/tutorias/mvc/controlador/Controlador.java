package org.iesalandalus.programacion.tutorias.mvc.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.tutorias.mvc.modelo.Modelo;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Cita;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Sesion;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Tutoria;
import org.iesalandalus.programacion.tutorias.mvc.modelo.negocio.Alumnos;
import org.iesalandalus.programacion.tutorias.mvc.vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;

	public Controlador(Modelo modelo, Vista vista) {
		if(modelo == null) {
			throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
		}
		
		if(vista == null) {
			throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");	
		}	
		
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}

	public void comenzar() {
		vista.comenzar();
	}

	public void terminar() {
		System.out.println("¡Hasta Luego!");
	}

	// Alumno
	public void insertarAlumno(Alumno alumno) throws OperationNotSupportedException {
		modelo.insertar(alumno);
	}

	public Alumno buscarAlumno(Alumno alumno) {
		return modelo.buscar(alumno);
	}

	public void borrarAlumno(Alumno alumno) throws OperationNotSupportedException {
		modelo.borrar(alumno);
	}

	public List<Alumno> getAlumnos() {
		return modelo.getAlumnos();
	}

	// Profesor
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.insertar(profesor);
	}

	public Profesor buscarProfesor(Profesor profesor) {
		return modelo.buscar(profesor);
	}

	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.borrar(profesor);
	}

	public List<Profesor> getProfesores() {
		return modelo.getProfesores();
	}

	// Tutorias
	public void insertarTutoria(Tutoria tutoria) throws OperationNotSupportedException {
		modelo.insertar(tutoria);
	}

	public Tutoria buscarTutoria(Tutoria tutoria) {
		return modelo.buscar(tutoria);
	}

	public void borrarTutoria(Tutoria tutoria) throws OperationNotSupportedException {
		modelo.borrar(tutoria);
	}

	public List<Tutoria> getTutorias() {
		return modelo.getTutorias();
	}

	public List<Tutoria> getTutorias(Profesor profesor) {
		return modelo.getTutorias(profesor);
	}

	// Sesion
	public void insertarSesion(Sesion sesion) throws OperationNotSupportedException {
		modelo.insertar(sesion);
	}

	public Sesion buscarSesion(Sesion sesion) {
		return modelo.buscar(sesion);
	}

	public void borrarSesion(Sesion sesion) throws OperationNotSupportedException {
		modelo.borrar(sesion);
	}

	public List<Sesion> getSesiones() {
		return modelo.getSesiones();
	}

	public List<Sesion> getSesiones(Tutoria tutoria) {
		return modelo.getSesiones(tutoria);
	}

	// Cita
	public void insertarCita(Cita cita) throws OperationNotSupportedException {
		modelo.insertar(cita);
	}

	public Cita buscarCita(Cita cita) {
		return modelo.buscar(cita);
	}

	public void borrarCita(Cita cita) throws OperationNotSupportedException {
		modelo.borrar(cita);
	}

	public List<Cita> getCitas() {
		return modelo.getCitas();
	}

	public List<Cita> getCitas(Sesion sesion) {
		return modelo.getCitas(sesion);
	}

	public List<Cita> getCitas(Alumno alumno) {
		return modelo.getCitas(alumno);
	}

}
