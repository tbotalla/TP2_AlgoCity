package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.MapaEdilicio;

public class MapaEdilicioTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnidadesAlMapa(){
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		
		Unidad u = new UnidadResidencial();
		
		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));
		
		u = new UnidadComercial();
		
		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));
		
		u = new UnidadIndustrial();
		
		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));
		
	}
	
	@Test
	public void testSePuedeRemoverUnaUnidad(){
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		
		Unidad eb = new EstacionDeBomberos();
				
		m.agregar(eb);

		assertTrue(m.contiene(eb));

		m.remover(1, 1);

		assertFalse(m.contiene(eb));
	}
	
	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		assertTrue(m.agregar(new PozoDeAgua()));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad u = new UnidadResidencial();

		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));
	}
	
	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad eb = new EstacionDeBomberos();

		assertFalse(m.agregar(eb));
		assertFalse(m.contiene(eb));
	}
	
	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad ce = new CentralEolica();

		assertTrue(m.agregar(ce));
		assertTrue(m.contiene(ce));
		assertFalse(m.agregar(ce));
	}
	
}
