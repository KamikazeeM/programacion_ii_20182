package com.ubosque.edu.co.progll.dao;

import java.util.Date;
import java.util.List;

import com.ubosque.edu.co.progll.dao.Implementacion.BaseDAO;
import com.ubosque.edu.co.progll.dao.Implementacion.UsuarioDAO;
import com.ubosque.edu.co.progll.logica.DestinoLogica;
import com.ubosque.edu.co.progll.modelo.Destino;
import com.ubosque.edu.co.progll.modelo.Usuario;


public class Ejecutable {
	public static void main(String[] args) {
//		DestinoLogica destinoLogica = new DestinoLogica();
//		List<Destino> destinos = destinoLogica.consultarDestinos();
		
//		BaseDAO<Destino> dao = new BaseDAO<Destino>();
//		dao.create(new Destino(0, "joder", "asadsd", "TT", "asdasdasd"));
		testLogin();
		System.out.println("Se inseto!");
	}
	
	public static void testLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.existe("rgarcia", "Joder123,")) {
			System.out.println("Exiate");
		} else {
			System.out.println("noooo");
		}	
	}
}
