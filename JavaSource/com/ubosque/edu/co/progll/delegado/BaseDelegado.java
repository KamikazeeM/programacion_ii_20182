package com.ubosque.edu.co.progll.delegado;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.dao.Implementacion.BaseDAO;

public class BaseDelegado<T> {

	private InterfazBaseDAOFachada destinoFachada;

	// constructor
	public <T> BaseDelegado() {
		destinoFachada = new BaseDAO<T>();		
	}

	public InterfazBaseDAOFachada getDestinoFachada() {
		return destinoFachada;
	}

}
