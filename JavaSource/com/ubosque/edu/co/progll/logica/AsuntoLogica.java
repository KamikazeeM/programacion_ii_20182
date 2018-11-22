package com.ubosque.edu.co.progll.logica;

import java.util.List;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.delegado.BaseDelegado;
import com.ubosque.edu.co.progll.modelo.Asunto;

public class AsuntoLogica {
	
	private InterfazBaseDAOFachada asuntoFachada;
	private BaseDelegado delegado;
	
	//constructor
	public AsuntoLogica() {
		delegado = new BaseDelegado<Asunto>();
		asuntoFachada = delegado.getFachada();
	}

	public boolean crearAsunto(Asunto asuntoAInsertar) {
		return asuntoFachada.create(asuntoAInsertar);
	}
	
	public List<Asunto> consultarAsuntos() {
		return asuntoFachada.read(Asunto.class);
	}
	
	public Asunto consultarAsuntoPorId(int id) {
		return (Asunto) asuntoFachada.buscarPorId(Asunto.class, id);
	}
	
	public boolean actualizarAsunto(Asunto asuntoAActualizar) {
		return asuntoFachada.update(asuntoAActualizar);
	}
	
	public boolean eliminarAsunto(Asunto asuntoAEliminar) {
		return asuntoFachada.delete(asuntoAEliminar);
	}
}
	

