package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaConexionesTest {
	
	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnConectorAlMapa() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c = new Conector(0);
		
		assertTrue(mc.agregar(c, 3, 3));		
	}
	
	@Test
	public void testSePuedeAgregarMasDeUnConectorAlMapa(){
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Conector(0);
		Conector c2 = new Conector(0);
		Conector c3 = new Conector(0);
		
		assertTrue(mc.agregar(c1, 1, 1));
		assertTrue(mc.agregar(c2, 2, 1));
		assertTrue(mc.agregar(c3, 3, 3));		
	}
	
	@Test
	public void testNoSePuedeAgregarDosConectoresDeIgualCoordenada(){
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Conector(0);
		Conector c2 = new Conector(0);
		
		assertTrue(mc.agregar(c1, 1, 1));
		assertTrue(mc.contiene(c1));
		assertFalse(mc.agregar(c2, 1, 1));
		assertFalse(mc.contiene(c2));
	}

	@Test
	public void testSePuedeConsultarSiDosCoordenadasEstanConectadas() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Conector(0);
		Conector c2 = new Conector(0);

		mc.agregar(c1, 1, 1);
		mc.agregar(c2, 2, 2);

		assertFalse(mc.hayConexion(mc.getCoordenadas(c1), mc.getCoordenadas(c2)));

		Conector c3 = new Conector(0);
		Conector c4 = new Conector(0);

		mc.agregar(c3, 4, 4);
		mc.agregar(c4, 3, 4);

		assertFalse(mc
				.hayConexion(mc.getCoordenadas(c1), mc.getCoordenadas(c3)));
		assertFalse(mc
				.hayConexion(mc.getCoordenadas(c1), mc.getCoordenadas(c4)));
		assertFalse(mc
				.hayConexion(mc.getCoordenadas(c2), mc.getCoordenadas(c3)));
		assertFalse(mc
				.hayConexion(mc.getCoordenadas(c2), mc.getCoordenadas(c4)));
		assertTrue(mc.hayConexion(mc.getCoordenadas(c3), mc.getCoordenadas(c4)));

	}

}
