package com.ubosque.edu.co.progll.logica;

import java.util.List;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.delegado.BaseDelegado;
import com.ubosque.edu.co.progll.modelo.Documento;
import com.ubosque.edu.co.progll.modelo.Documento;

/**
 * Representa la logica para el modelo Documento
 * @author kamikazee
 *
 */
public class DocumentoLogica {
	
	private InterfazBaseDAOFachada documentoFachada;
	private BaseDelegado delegado;
	
	//constructor
	public DocumentoLogica() {
		delegado = new BaseDelegado<Documento>();
		documentoFachada = delegado.getFachada();
	}

	public boolean crearDocumento(Documento documentoAInsertar) {
		return documentoFachada.create(documentoAInsertar);
	}
	
	public List<Documento> consultarDocumentos() {
		return documentoFachada.read(Documento.class);
	}
	
	public Documento consultarDocumentoPorId(int id) {
		return (Documento) documentoFachada.buscarPorId(Documento.class, id);
	}
	
	public boolean actualizarDocumento(Documento documentoAActualizar) {
		return documentoFachada.update(documentoAActualizar);
	}
	
	public boolean eliminarDocumento(Documento documentoAEliminar) {
		return documentoFachada.delete(documentoAEliminar);
	}
}
	

