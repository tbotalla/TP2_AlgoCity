package algo3.algocity.controller.estadoControladorMouse;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.mapas.Coordenada;

public class StateConstruirCentralEolica implements StateConstruir {
	
	FabricaCentralEolica fabrica;
	
	public StateConstruirCentralEolica(FabricaCentralEolica f) {
		fabrica = f;
	}

	@Override
	public void construir(Juego j, Coordenada c)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		System.out.println("state " + c.getX() + c.getY());
		j.mapa().agregar(fabrica.construir(j.mapa(), j.dinero(), c));
	}

}
