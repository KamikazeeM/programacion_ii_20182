package com.ubosque.edu.co.progll.dao;

import java.util.Date;
import java.util.List;

import com.ubosque.edu.co.progll.dao.Implementacion.BaseDAO;
import com.ubosque.edu.co.progll.logica.DestinoLogica;
import com.ubosque.edu.co.progll.modelo.Destino;


public class Ejecutable {
	public static void main(String[] args) {
//		DestinoLogica destinoLogica = new DestinoLogica();
//		List<Destino> destinos = destinoLogica.consultarDestinos();
		BaseDAO<Destino> dao = new BaseDAO<Destino>();
		dao.create(new Destino(0, "joder", "asadsd", "TT", "asdasdasd"));
		System.out.println("Se inseto!");
	}
}
