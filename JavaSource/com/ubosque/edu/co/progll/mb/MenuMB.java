package com.ubosque.edu.co.progll.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ubosque.edu.co.progll.logica.UsuarioLogica;
import com.ubosque.edu.co.progll.modelo.Usuario;
import com.ubosque.edu.co.progll.util.SessionUtils;

@ManagedBean
@ViewScoped
/**
 * Representa el bean para la vista de layout
 * @author kamikazee
 *
 */
public class MenuMB {
	
	private UsuarioLogica usuarioLogica = new UsuarioLogica();
	
	private Usuario user = null;
	
	public Usuario getUser() {
		if (user == null) {
			user = usuarioLogica.consultarUsuarioPorUsuario(this.usuario);
		}
		return user;
	}
	
	private String usuario = null;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public MenuMB() {
		this.usuario = SessionUtils.getUserName();
	}

}
