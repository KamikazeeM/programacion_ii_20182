package com.ubosque.edu.co.progll.dao.Implementacion;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		s.beginTransaction();
		Criteria crit = s.createCriteria(Usuario.class);
		crit.add(Restrictions.eq("usuario", username));
		crit.add(Restrictions.eq("contrasena", password));
		Usuario existe = (Usuario) crit.uniqueResult();
		if(existe != null) {
			r = true;
		}
		return r;
	}
}
