package com.ubosque.edu.co.progll.dao.Implementacion;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ubosque.edu.co.progll.util.HibernateUtilidad;
import com.ubosque.edu.co.progll.dao.InterfazUsuarioDAOFachada;
import com.ubosque.edu.co.progll.modelo.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario> implements InterfazUsuarioDAOFachada {

	public UsuarioDAO() {
	}
	
	@Override
	public boolean existe(String username, String password) {
		boolean r = false;
		try {
			Session s = HibernateUtilidad.getSf().getCurrentSession();
			s.beginTransaction();
			Criteria crit = s.createCriteria(Usuario.class);
			Criterion rest= Restrictions.and(Restrictions.eq("usuario", username), 
			           Restrictions.eq("contrasena", password));
			crit.add(rest);
			Usuario existe = (Usuario) crit.uniqueResult();
			s.getTransaction().commit();
			if(existe != null) {
				r = true;
			}	
		} catch (Exception e) {
			r = false;
		}
		return r;
	}
	
	/* @Override
	public boolean existe(String username, String password) {
		boolean r = false;
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		s.beginTransaction();
		TypedQuery<Usuario> query = s.createQuery(
				  " select u from Usuario u "
				+ " where u.usuario = :pUsuario and u.contrasena = :pContrasena", Usuario.class);
		
		query.setParameter("pUsuario", username);
		query.setParameter("pContrasena", password);
		try {
			Usuario resultado =  query.getSingleResult();
			if (resultado != null) {
				r = true;
			}
			s.getTransaction().commit();
		} catch (NoResultException ex) {
			r = false;
		}
		return r;
	} */
}
