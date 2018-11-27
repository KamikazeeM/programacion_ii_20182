package com.ubosque.edu.co.progll.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.AsuntoLogica;
import com.ubosque.edu.co.progll.modelo.Asunto;

@ManagedBean
@ViewScoped
/**
 * Representa el bean para la vista de asuntos
 * @author kamikazee
 *
 */
public class AsuntoMB {
	
	private Asunto asunto = new Asunto();

	public Asunto getAsunto() {
		return asunto;
	}

	public void setAsunto(Asunto asunto) {
		this.asunto = asunto;
	}

	private AsuntoLogica asuntoLogica = new AsuntoLogica();

	private List<Asunto> asuntos = null;
	
	public List<Asunto> getAsuntos() {
		if (this.asuntos == null) {
			this.asuntos = asuntoLogica.consultarAsuntos();
		}
		return asuntos;
	}

	public void setAsuntos(List<Asunto> asuntos) {
		this.asuntos = asuntos;
	}

	public void guardar() {
		if(this.asunto.getId() == 0) {			
			asuntoLogica.crearAsunto(this.asunto);
		} 
		else 
		{
			asuntoLogica.actualizarAsunto(this.asunto);
		}
		asuntos = asuntoLogica.consultarAsuntos();
		this.asunto = new Asunto();
	}
	
	public void editar(int id) {
		this.asunto = asuntoLogica.consultarAsuntoPorId(id);
	}
	
	public void eliminar(int id) {
		asuntoLogica.eliminarAsunto(asuntoLogica.consultarAsuntoPorId(id));
	}
}
