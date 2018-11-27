package com.ubosque.edu.co.progll.logica;

import java.util.List;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.dao.InterfazUsuarioDAOFachada;
import com.ubosque.edu.co.progll.delegado.BaseDelegado;
import com.ubosque.edu.co.progll.delegado.UsuarioDelegado;
import com.ubosque.edu.co.progll.modelo.Usuario;
import com.ubosque.edu.co.progll.modelo.Usuario;

/**
 * Representa la logica para el modelo Usuario
 * @author kamikazee
 *
 */
public class UsuarioLogica {
	
	private InterfazUsuarioDAOFachada usuarioFachada;
	private UsuarioDelegado usuarioDelegado;
	
	private InterfazBaseDAOFachada<Usuario> baseFachada;
	private BaseDelegado<Usuario> delegado;
	
	//constructor
	@SuppressWarnings("unchecked")
	public UsuarioLogica() {
		usuarioDelegado = new UsuarioDelegado();
		usuarioFachada = usuarioDelegado.getFachada();
		delegado = new BaseDelegado<Usuario>();
		baseFachada = delegado.getFachada();
	}

	public boolean crearUsuario(Usuario usuarioAInsertar) {
		return baseFachada.create(usuarioAInsertar);
	}
	
	public List<Usuario> consultarUsuarios() {
		return baseFachada.read(Usuario.class);
	}
	
	public Usuario consultarUsuarioPorId(int id) {
		return (Usuario) baseFachada.buscarPorId(Usuario.class, id);
	}
	
	public Usuario consultarUsuarioPorUsuario(String usuario) {
		return (Usuario) usuarioFachada.obtenerPorUsuario(usuario);
	}
	
	public boolean actualizarUsuario(Usuario usuarioAActualizar) {
		return baseFachada.update(usuarioAActualizar);
	}
	
	public boolean eliminarUsuario(Usuario usuarioAEliminar) {
		return baseFachada.delete(usuarioAEliminar);
	}
	
	public boolean existe(String user, String pass) {
		return usuarioFachada.existe(user, pass);
	}
}
	

