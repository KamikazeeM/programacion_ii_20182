package com.ubosque.edu.co.progll.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ubosque.edu.co.progll.logica.UsuarioLogica;
import com.ubosque.edu.co.progll.modelo.Usuario;
import com.ubosque.edu.co.progll.util.SessionUtils;

@ManagedBean
@ViewScoped
/**
 * Representa el bean para la vista de login
 * @author kamikazee
 *
 */
public class LoginMB {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new UsuarioLogica()
							.existe(this.getUsuario().getUsuario(), this.getUsuario().getContrasena());
		if(existe) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.usuario.getUsuario());
			return "index?faces-redirect=true";
		}	
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		return "login?faces-redirect=true";
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login?faces-redirect=true";
	}
}
