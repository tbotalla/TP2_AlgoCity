package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoblacionTest {

	@Test
	public void testSeCreaConEstadoValido() {
		Poblacion p = new Poblacion();
		
		assertEquals(0, p.getCantidad());
	}
	
	@Test
	public void testLaPoblacionPuedeCrecer(){
		Poblacion p = new Poblacion();
		
		assertTrue(p.getCantidad() == 0);
		
		p.aumentar();
		
		assertTrue(p.getCantidad() > 0);
	}

}
