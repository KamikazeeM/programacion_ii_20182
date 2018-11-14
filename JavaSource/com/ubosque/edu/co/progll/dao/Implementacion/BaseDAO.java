package com.ubosque.edu.co.progll.dao.Implementacion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.ubosque.edu.co.progll.dao.InterfazBaseDAOFachada;
import com.ubosque.edu.co.progll.util.HibernateUtilidad;

public class BaseDAO<T> implements InterfazBaseDAOFachada<T> {

	public BaseDAO() {
	}

	@Override
	public boolean create(T modeloAInsertar) {
		boolean r = false;
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		try {
			s.beginTransaction();
			s.persist(modeloAInsertar);
			s.getTransaction().commit();
			r = true;
		} catch (Exception e) {
			s.getTransaction().rollback();
		}
		return r;
	}

	@Override
	public List<T> read(final Class<T> claseALeer) {
		List<T> r = null; 
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		s.beginTransaction();
		Criteria crit = s.createCriteria(claseALeer);
		r = crit.list();
		s.getTransaction().commit();
		return r;
	}

	@Override
	public boolean update(T modeloAActualizar) {
		boolean r = false;
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		try {
			s.beginTransaction();
			s.merge(modeloAActualizar);
			s.getTransaction().commit();
			r = true;
		} catch (Exception e) {
			s.getTransaction().rollback();
		}
		return r;
	}

	@Override
	public boolean delete(T modeloAEliminar) {
		boolean r = false;
		Session s = HibernateUtilidad.getSf().getCurrentSession();
		try {
			s.beginTransaction();
			s.remove(modeloAEliminar);
			s.getTransaction().commit();
			r = true;
		} catch (Exception e) {
			s.getTransaction().rollback();
		}
		return r;
	}
}
