package com.ubosque.edu.co.progll.delegado;

import com.ubosque.edu.co.progll.dao.InterfazUsuarioDAOFachada;
import com.ubosque.edu.co.progll.dao.Implementacion.UsuarioDAO;

public class UsuarioDelegado {

	private InterfazUsuarioDAOFachada fachada;

	// constructor
	public UsuarioDelegado() {
		fachada = new UsuarioDAO();		
	}

	public InterfazUsuarioDAOFachada getFachada() {
		return fachada;
	}

}
