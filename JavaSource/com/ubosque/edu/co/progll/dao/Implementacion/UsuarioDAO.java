package com.ubosque.edu.co.progll.dao.Implementacion;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ubosque.edu.co.progll.util.HibernateUtilidad;
import com.ubosque.edu.co.progll.util.Security;
import com.ubosque.edu.co.progll.dao.InterfazUsuarioDAOFachada;
import com.ubosque.edu.co.progll.modelo.Usuario;

/**
 * Clase usuario dao que implementa la InterfazUsuarioDAOFachada  y define sus metodos adicionales. 
 * @author kamikazee
 *
 * @param <T>
 */
public class UsuarioDAO extends BaseDAO<Usuario> implements InterfazUsuarioDAOFachada {

	public UsuarioDAO() {
	}

	@Override
	public boolean existe(String username, String password) {
		boolean existe = false;
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		String hashPassword = Security.computeHash(password);
		try {
			s.beginTransaction();
			Criteria crit = s.createCriteria(Usuario.class);
			Criterion rest = Restrictions.and(Restrictions.eq("usuario", username),
					Restrictions.eq("contrasena", hashPassword));
			crit.add(rest);
			
			Usuario usuario = (Usuario) crit.uniqueResult();
			s.getTransaction().commit();
			
			if (usuario != null) {
				existe = true;
			}
		} catch (Exception e) {
			existe = false;
		}
		
		return existe;
	}

	@Override
	public Usuario obtenerPorUsuario(String username) {
		Usuario usuario = null;
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		try {
			s.beginTransaction();
			Criteria crit = s.createCriteria(Usuario.class);
			Criterion rest = Restrictions.eq("usuario", username);
			crit.add(rest);	
			usuario = (Usuario) crit.uniqueResult();
			s.getTransaction().commit();
		} catch (Exception e) {
			usuario = null;
		}		
		return usuario;
	}

	/*
	 * @Override public boolean existe(String username, String password) { boolean r
	 * = false; Session s = HibernateUtilidad.getSf().getCurrentSession();
	 * s.beginTransaction(); TypedQuery<Usuario> query = s.createQuery(
	 * " select u from Usuario u " +
	 * " where u.usuario = :pUsuario and u.contrasena = :pContrasena",
	 * Usuario.class);
	 * 
	 * query.setParameter("pUsuario", username); query.setParameter("pContrasena",
	 * password); try { Usuario resultado = query.getSingleResult(); if (resultado
	 * != null) { r = true; } s.getTransaction().commit(); } catch
	 * (NoResultException ex) { r = false; } return r; }
	 */
}
