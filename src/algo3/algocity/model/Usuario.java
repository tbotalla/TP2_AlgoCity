package algo3.algocity.model;

import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	ArrayList<Personaje> personajes;


	public void setNombre(String nuevoNombre) {
		
		nombre = nuevoNombre;		
	}

	public String getNombre() {
		
		return nombre;
	}

}