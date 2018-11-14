package com.ubosque.edu.co.progll.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.UsuarioLogica;
import com.ubosque.edu.co.progll.modelo.Usuario;

@ManagedBean
@SessionScoped

public class LoginMB {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String login() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new UsuarioLogica().existe(this.getUsuario().getUsuario(), this.getUsuario().getContrasena());
		if(existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "listaDestinos?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("encontrado"));
		
		return "login?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
