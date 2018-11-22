package com.ubosque.edu.co.progll.mb;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.modelo.Usuario;

@ManagedBean
@ViewScoped
public class MenuMB {
	
	private Usuario usuarioLogado  = new Usuario();
	
	public Usuario getUsuario() {
		return usuarioLogado;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuarioLogado = usuario;
	}

	public MenuMB() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		this.setUsuario((Usuario) facesContext.getExternalContext().getSessionMap().get("usuarioLogado"));
		
		if(usuarioLogado != null) {
			return;
		}
		
		NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
		handler.handleNavigation(facesContext, null, "/login?faces-redirect=true");
	}

}
