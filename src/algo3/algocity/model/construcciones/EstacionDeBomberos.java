package algo3.algocity.model.construcciones;

import java.awt.Point;
import java.util.ArrayList;

import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class EstacionDeBomberos extends Unidad implements Visitante {

	private Conector conexion;

	public EstacionDeBomberos() {
		costo = 1500;
		consumo = 0;
	}

	public EstacionDeBomberos(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		
		coordenadas = new Point(x, y);
		costo = 1500;
		consumo = 0;
		if (!esConstruibleEn(mapa.getSuperficie(coordenadas))){
			throw new NoSeCumplenLosRequisitosException();
		}
	}


	public EstacionDeBomberos(int x, int y) {
		costo = 1500;
		consumo = 0;
		conexion = null;
		this.coordenadas = new Point(x, y);
	}

	public void actuar(ArrayList<Visitable> objetivos) {
		for (Visitable v : objetivos) {
			v.aceptar(this);
		}
	}

	// TODO Revisar si sirve el metodo
	public void conectarTuberia(Conector unaTuberia) {
		conexion = unaTuberia;
	}

	public Conector getConexion() {
		return conexion;
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		unaUnidadResidencial.repararse();
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		unaUnidadComercial.repararse();
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		unaUnidadIndustrial.repararse();
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		unaUnidadEnergetica.repararse();
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		unaLineaTension.repararse();
	}

	@Override
	public void visitar(Ruta unaRuta) {
		unaRuta.repararse();
	}

	@Override
	public void visitar(Unidad unaUnidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return (superficie.esTierra());
	}

	@Override
	public void aplicarDanio(double i) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}

}