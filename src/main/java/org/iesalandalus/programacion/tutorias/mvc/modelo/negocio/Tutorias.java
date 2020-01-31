package org.iesalandalus.programacion.tutorias.mvc.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Tutoria;

public class Tutorias {

	private List<Tutoria> coleccionTutorias;

	// Constructor 
	public Tutorias() {
		coleccionTutorias = new ArrayList();
	}

	// Getters
	public List<Tutoria> get() {
		return copiaProfundaTutorias();
	}

	// Copia profunda tutorias
	private List<Tutoria> copiaProfundaTutorias() {
		List<Tutoria> copiaTutoria = new ArrayList<>();
		for (Tutoria tutoria : coleccionTutorias) {
			coleccionTutorias.add(new Tutoria(tutoria));
		}
		return copiaTutoria;
	}

	// Tutoria profesor
	public Tutoria[] get(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: El profesor no puede ser nulo.");
		}
		Tutoria[] tutoriaProfesor = new Tutoria[capacidad];
		int j = 0;
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionTutorias[i].getProfesor().equals(profesor)) {
				tutoriaProfesor[j++] = new Tutoria(coleccionTutorias[i]);
			}
		}
		return tutoriaProfesor;
	}

	public int getTamano() {
		return coleccionTutorias.size();
	}

	// Insertar tutoria
	public void insertar(Tutoria tutoria) throws OperationNotSupportedException {

		if (tutoria == null) {
			throw new NullPointerException("ERROR: No se puede insertar una tutoría nula.");
		}

		int indice = coleccionTutorias.indexOf(tutoria);

		if (indice == -1) {
			coleccionTutorias.add(new Tutoria(tutoria));
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe una tutoría con ese identificador.");
		}

	}

	// Buscar tutorias
	public Tutoria buscar(Tutoria tutoria) {
		if (tutoria == null) {
			throw new IllegalArgumentException("ERROR: No se puede buscar una tutoría nula.");
		}

		int indice = coleccionTutorias.indexOf(tutoria);
		if (indice == -1) {
			return null;
		} else {
			return new Tutoria(coleccionTutorias.get(indice));
		}

	}

	// Borrar tutorias
	public void borrar(Tutoria tutoria) throws OperationNotSupportedException {
		if (tutoria == null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar una tutoría nula.");
		}

		int indice = coleccionTutorias.indexOf(tutoria);
		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ninguna tutoría con ese identificador.");
		} else {
			coleccionTutorias.remove(indice);
		}
	}

}
