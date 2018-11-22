package com.ubosque.edu.co.progll.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.UsuarioLogica;
import com.ubosque.edu.co.progll.modelo.Usuario;

@ManagedBean
@ViewScoped
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
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "index?faces-redirect=true";
		}	
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		return "login?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
