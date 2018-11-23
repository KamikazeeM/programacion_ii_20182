package com.ubosque.edu.co.progll.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.AsuntoLogica;
import com.ubosque.edu.co.progll.logica.DestinoLogica;
import com.ubosque.edu.co.progll.logica.DocumentoLogica;
import com.ubosque.edu.co.progll.logica.UsuarioLogica;
import com.ubosque.edu.co.progll.modelo.Asunto;
import com.ubosque.edu.co.progll.modelo.Destino;
import com.ubosque.edu.co.progll.modelo.Documento;
import com.ubosque.edu.co.progll.modelo.Usuario;

import javax.faces.application.FacesMessage;


@ManagedBean
@ViewScoped
public class DocumentoMB {

	public DocumentoMB() {
	}

	private Boolean isEdit = false;

	public Boolean getIsEdit() {
		return isEdit ;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	private Documento documento = new Documento();;

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	private List<Documento> documentos;

	public List<Documento> getDocumentos() {

		if (this.documentos == null) {
			this.documentos = documentoLogica.consultarDocumentos();
		}

		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	private Integer subjectId;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private List<Destino> destinos = null;

	public List<Destino> getDestinos() {
		if (this.destinos == null) {
			this.destinos = destinoLogica.consultarDestinos();
		}
		return destinos;
	}

	public void setUsuarios(List<Destino> destinos) {
		this.destinos = destinos;
	}
	
	public Destino getDestinoById(int id) {
		return destinoLogica.consultarDestinoPorId(id);
	}

	public Asunto getAsuntoById(int id) {
		return asuntoLogica.consultarAsuntoPorId(id);
	}

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

	private DocumentoLogica documentoLogica = new DocumentoLogica();
	private AsuntoLogica asuntoLogica = new AsuntoLogica();
	private UsuarioLogica usuarioLogica = new UsuarioLogica();
	private DestinoLogica destinoLogica = new DestinoLogica();

	public void guardar() {
		if(!isEdit) {			
			documentoLogica.crearDocumento(this.documento);
		} 
		else 
		{
			documentoLogica.actualizarDocumento(this.documento);
		}
		documentos = documentoLogica.consultarDocumentos();
		this.documento = new Documento();
		this.isEdit = false;
	}
	
	public void editar(int id) {
		this.isEdit = true;
		this.documento = documentoLogica.consultarDocumentoPorId(id);
		if (this.documento != null) {
			this.documento.setId(id);
		}
	}
	
	public void eliminar(int id) {
		documentoLogica.eliminarDocumento(documentoLogica.consultarDocumentoPorId(id));
	}
}
