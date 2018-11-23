package com.ubosque.edu.co.progll.logica;

import java.util.List;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.delegado.BaseDelegado;
import com.ubosque.edu.co.progll.modelo.Destino;
import com.ubosque.edu.co.progll.modelo.Documento;

public class DestinoLogica {
	
	private InterfazBaseDAOFachada destinoFachada;
	private BaseDelegado delegado;
	
	//constructor
	public DestinoLogica() {
		delegado = new BaseDelegado<Destino>();
		destinoFachada = delegado.getFachada();
	}

	public boolean crearDestino(Destino destinoAInsertar) {
		return destinoFachada.create(destinoAInsertar);
	}
	
	public List<Destino> consultarDestinos() {
		return destinoFachada.read(Destino.class);
	}
	
	public Destino consultarDestinoPorId(int id) {
		return (Destino) destinoFachada.buscarPorId(Destino.class, id);
	}
	
	public boolean actualizarDestino(Destino destinoAActualizar) {
		return destinoFachada.update(destinoAActualizar);
	}
	
	public boolean eliminarDestino(Destino destinoAEliminar) {
		return destinoFachada.delete(destinoAEliminar);
	}
}
	

