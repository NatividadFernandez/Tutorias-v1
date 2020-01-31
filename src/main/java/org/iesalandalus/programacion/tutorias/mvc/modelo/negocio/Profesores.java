package org.iesalandalus.programacion.tutorias.mvc.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Profesor;

public class Profesores {

	private List<Profesor> coleccionProfesores;

	// Constructor con parámetros
	public Profesores() {
		coleccionProfesores = new ArrayList();
	}

	// Getters
	public List<Profesor> get() {
		return copiaProfundaProfesores();
	}

	// Copia profunda de Profesores
	private List<Profesor> copiaProfundaProfesores() {
		List<Profesor> copiaProfesor = new ArrayList<>();
		for (Profesor profesor : coleccionProfesores) {
			copiaProfesor.add(new Profesor(profesor));
		}
		return copiaProfesor;
	}

	public int getTamano() {
		return coleccionProfesores.size();
	}

	// Insertar profesor
	public void insertar(Profesor profesor) throws OperationNotSupportedException {

		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
		}

		int indice = coleccionProfesores.indexOf(profesor);

		if (indice == -1) {
			coleccionProfesores.add(new Profesor(profesor));
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un profesor con ese DNI.");
		}

	}

	// Buscar profesores
	public Profesor buscar(Profesor profesor) {
		if (profesor == null) {
			throw new IllegalArgumentException("ERROR: No se puede buscar un profesor nulo.");
		}

		int indice = coleccionProfesores.indexOf(profesor);
		if (indice == -1) {
			return null;
		} else {
			return new Profesor(coleccionProfesores.get(indice));
		}

	}

	// Borrar profesore
	public void borrar(Profesor profesor) throws OperationNotSupportedException {

		if (profesor == null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar un profesor nulo.");
		}

		int indice = coleccionProfesores.indexOf(profesor);

		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ningún profesor con ese DNI.");
		} else {
			coleccionProfesores.remove(indice);
		}
	}

}
