package com.ubosque.edu.co.progll.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.DestinoLogica;
import com.ubosque.edu.co.progll.modelo.Destino;

@ManagedBean
@SessionScoped
public class DestinoMB {

	private DestinoLogica destinoLogica = new DestinoLogica();

	private List<Destino> destino = new ArrayList<Destino>();

	private Destino crearDestino = new Destino();
	private Destino actualizarDestino = new Destino();
	private Destino eliminarDestino = new Destino();

	public DestinoMB() {
		destino = destinoLogica.consultarDestinos();
	}

	public String guardar() {
		destinoLogica.crearDestino(crearDestino);
		destino = destinoLogica.consultarDestinos();
		return "listaDestinos?faces-redirect=true";
	}

	public String actualizar() {
		destinoLogica.actualizarDestino(actualizarDestino);
		destino = destinoLogica.consultarDestinos();
		return "listaDestinos?faces-redirect=true";
	}

	public void eliminar() {
		destinoLogica.eliminarDestino(eliminarDestino);
		destino = destinoLogica.consultarDestinos();
	}

	public void inicializarNuevo() {
		crearDestino = new Destino();
		try {
	        FacesContext.getCurrentInstance().getExternalContext().redirect("MYSERVERADDRESS" + "/destino/crearDestino?faces-redirect=true");
	    } catch (IOException ex) {
	    }
	}

	public List<Destino> getDestino() {
		return destino;
	}

	public void setDestino(List<Destino> destino) {
		this.destino = destino;
	}

	public Destino getCrearDestino() {
		return crearDestino;
	}

	public void setCrearDestino(Destino crearDestino) {
		this.crearDestino = crearDestino;
	}

	public Destino getActualizarDestino() {
		return actualizarDestino;
	}

	public void setActualizarDestino(Destino actualizarDestino) {
		this.actualizarDestino = actualizarDestino;
	}

	public Destino getEliminarDestino() {
		return eliminarDestino;
	}

	public void setEliminarDestino(Destino eliminarDestino) {
		this.eliminarDestino = eliminarDestino;
	}

}
