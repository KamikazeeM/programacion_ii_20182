package com.ubosque.edu.co.progll.delegado;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.dao.Implementacion.BaseDAO;

public class BaseDelegado<T> {

	private InterfazBaseDAOFachada fachada;

	// constructor
	public BaseDelegado() {
		fachada = new BaseDAO<T>();		
	}

	public InterfazBaseDAOFachada getFachada() {
		return fachada;
	}

}
