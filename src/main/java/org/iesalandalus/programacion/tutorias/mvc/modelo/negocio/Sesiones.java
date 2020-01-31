package org.iesalandalus.programacion.tutorias.mvc.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Sesion;
import org.iesalandalus.programacion.tutorias.mvc.modelo.dominio.Tutoria;

public class Sesiones {

	private List<Sesion> coleccionSesiones;

	// Constructor
	public Sesiones() {
		coleccionSesiones = new ArrayList();
	}

	// Getters
	public List<Sesion> get() {
		return copiaProfundaSesiones();
	}

	// Copia profunda sesiones
	private List<Sesion> copiaProfundaSesiones() {
		List<Sesion> copiaSesion = new ArrayList<>();
		for (Sesion sesion : coleccionSesiones) {
			copiaSesion.add(new Sesion(sesion));
		}
		return copiaSesion;
	}

	// Sesion tutoria
	public Sesion[] get(Tutoria tutoria) {
		if (tutoria == null) {
			throw new NullPointerException("ERROR: La tutoría no puede ser nula.");
		}
		Sesion[] sesionTutoria = new Sesion[capacidad];
		int j = 0;
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionSesiones[i].getTutoria().equals(tutoria)) {
				sesionTutoria[j++] = new Sesion(coleccionSesiones[i]);
			}
		}
		return sesionTutoria;
	}

	public int getTamano() {
		return coleccionSesiones.size();
	}

	// Insertar sesion
	public void insertar(Sesion sesion) throws OperationNotSupportedException {
		if (sesion == null) {
			throw new NullPointerException("ERROR: No se puede insertar una sesión nula.");
		}

		int indice = coleccionSesiones.indexOf(sesion);
		if (indice == -1) {
			coleccionSesiones.add(new Sesion(sesion));
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe una sesión con esa fecha.");
		}

	}

	// Buscar sesiones
	public Sesion buscar(Sesion sesion) {
		if (sesion == null) {
			throw new IllegalArgumentException("ERROR: No se puede buscar una sesión nula.");
		}

		int indice = coleccionSesiones.indexOf(sesion);
		if (indice == -1) {
			return null;
		} else {
			return new Sesion(coleccionSesiones.get(indice));
		}

	}

	// Borrar sesiones
	public void borrar(Sesion sesion) throws OperationNotSupportedException {
		if (sesion == null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar una sesión nula.");
		}

		int indice = coleccionSesiones.indexOf(sesion);
		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ninguna sesión con esa fecha.");
		} else {
			coleccionSesiones.remove(indice);
		}
	}

}
