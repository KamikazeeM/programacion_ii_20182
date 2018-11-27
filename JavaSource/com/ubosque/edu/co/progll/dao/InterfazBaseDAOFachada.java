package com.ubosque.edu.co.progll.dao;

import java.util.List;

/**
 * Define el comportamiento de un crup
 * @author kamikazee
 *
 */
public interface InterfazBaseDAOFachada<T> {
	
	public boolean create(T modeloAInsertar);

	public List<T> read(Class<T> claseALeer);
	
	public boolean update(T modeloAActualizar);
	
	public boolean delete(T modeloAEliminar);
	
	public T buscarPorId(final Class<T> claseALeer, Integer id);
}
