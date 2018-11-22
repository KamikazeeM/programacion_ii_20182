package com.ubosque.edu.co.progll.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ubosque.edu.co.progll.logica.AsuntoLogica;
import com.ubosque.edu.co.progll.logica.DestinoLogica;
import com.ubosque.edu.co.progll.logica.DocumentoLogica;
import com.ubosque.edu.co.progll.logica.UsuarioLogica;
import com.ubosque.edu.co.progll.modelo.Asunto;
import com.ubosque.edu.co.progll.modelo.Documento;
import com.ubosque.edu.co.progll.modelo.Usuario;

import javax.faces.application.FacesMessage;


@ManagedBean
@SessionScoped
public class DocumentoMB {

	public DocumentoMB() {
	}

	private Boolean isRead = false;

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
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

	private List<Usuario> usuarios = null;

	public List<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			this.usuarios = usuarioLogica.consultarUsuarios();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario getUsuarioById(int id) {
		return usuarioLogica.consultarUsuarioPorId(id);
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

	public void guardar() {
		if(this.documento.getId() == 0) {			
			documentoLogica.crearDocumento(this.documento);
		} 
		else 
		{
			documentoLogica.actualizarDocumento(this.documento);
		}
		documentos = documentoLogica.consultarDocumentos();
		this.documento = new Documento();
	}
	
	public void editar(int id) {
		this.documento = documentoLogica.consultarDocumentoPorId(id);
	}
	
	public void eliminar(int id) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean r = documentoLogica.eliminarDocumento(documentoLogica.consultarDocumentoPorId(id));
		if(r) {
			context.addMessage(null, new FacesMessage("Actualización OK"));
		} else {
			context.addMessage(null, new FacesMessage("Actualización ERROR"));
		}
	}
	
	public String crear() {
		return "documento?faces-redirect=true";
	}
}
