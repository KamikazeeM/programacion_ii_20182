package com.ubosque.edu.co.progll.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.DestinoLogica;
import com.ubosque.edu.co.progll.modelo.Destino;

@ManagedBean
@ViewScoped
/**
 * Representa el bean para la vista de destinos
 * @author kamikazee
 *
 */
public class DestinoMB {
	
	private Destino destino = new Destino();

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	private DestinoLogica destinoLogica = new DestinoLogica();

	private List<Destino> destinos = null;
	
	public List<Destino> getDestinos() {
		if(this.destinos == null) {
			this.destinos = destinoLogica.consultarDestinos();
		}
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public void guardar() {
		if(this.destino.getId() == 0) {			
			destinoLogica.crearDestino(this.destino);
		} 
		else 
		{
			destinoLogica.actualizarDestino(this.destino);
		}
		destinos = destinoLogica.consultarDestinos();
		this.destino = new Destino();
	}
	
	public void editar(int id) {
		this.destino = destinoLogica.consultarDestinoPorId(id);
	}
	
	public void eliminar(int id) {
		boolean r = destinoLogica.eliminarDestino(destinoLogica.consultarDestinoPorId(id));
	}
}
