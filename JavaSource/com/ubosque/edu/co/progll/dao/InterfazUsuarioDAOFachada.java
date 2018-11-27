package com.ubosque.edu.co.progll.dao;

import com.ubosque.edu.co.progll.modelo.Usuario;

// Funciones adicionales para el modelo de usuario
public interface InterfazUsuarioDAOFachada {
	public boolean existe(String username, String password);
	public Usuario obtenerPorUsuario(String username);
}
