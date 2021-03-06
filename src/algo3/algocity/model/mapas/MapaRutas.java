package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;

public class MapaRutas extends MapaConexiones {

	ArrayList<Ruta> listado;

	public MapaRutas(Mapa mapa) {
		super(mapa);
		listado = new ArrayList<Ruta>();
	}

	public boolean agregar(Ruta ruta) {
		if (contiene(ruta) || tieneCoordenadaOcupada(ruta.coordenada())) {
			return false;
		}
		listado.add(ruta);
		grafo.addVertex(ruta);
		actualizarGrafo(ruta);
		setChanged();
		notifyObservers(ruta);
		return true;
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		return hayConectorAdyacente(coord);
	}

	public boolean hayConectorAdyacente(Coordenada coord) {
		for (Conector c : grafo.vertexSet()) {
			if (hayDistanciaMinima(coord, c.coordenada())) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Daniable> unidadesDaniables() {
		ArrayList<Daniable> lista = new ArrayList<Daniable>();
		Iterator<Ruta> it = listado.iterator();
		while (it.hasNext()) {
			lista.add(it.next());
		}
		return lista;
	}

	public Conector getConectorEn(Coordenada coord) {
		for (Conector c : grafo.vertexSet()) {
			if (c.coordenada().equals(coord)) {
				return c;
			}
		}
		return null;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**
	 * @throws CoordenadaInvalidaException
	 * @throws FondosInsuficientesException
	 * @throws NoSeCumplenLosRequisitosException
<<<<<<< Updated upstream
	 * @throws SuperficieInvalidaParaConstruir 
=======
	 * @throws SuperficieInvalidaParaConstruir
>>>>>>> Stashed changes
	 ********************************************************************/

	public static MapaRutas fromElement(Node tuberias, Mapa mapa, Dinero d)
			throws NoSeCumplenLosRequisitosException,

			FondosInsuficientesException, CoordenadaInvalidaException,
			SuperficieInvalidaParaConstruir {
		MapaRutas mapaRutas = new MapaRutas(mapa);
		NodeList hijosDeRed = tuberias.getChildNodes();

		for (int i = 0; i < hijosDeRed.getLength(); i++) {
			Node hijoDeRed = hijosDeRed.item(i);
			if (hijoDeRed.getNodeName().equals("mapa")) {
				NodeList hijosDeMapa = hijoDeRed.getChildNodes();
				for (int j = 0; j < hijosDeMapa.getLength(); j++) {
					Node hijoDeMapa = hijosDeMapa.item(j);
					if (hijoDeMapa.getNodeName().equals("Nodo")) {
						NodeList hijosDeNodo = hijoDeMapa.getChildNodes();
						String stringPunto = "";
						Coordenada puntoAAgregar = new Coordenada();
						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
							Node hijoDeNodo = hijosDeNodo.item(k);
							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
								stringPunto = hijoDeNodo.getTextContent();
								String[] arrayPunto = stringPunto.split(",");
								puntoAAgregar = new Coordenada(
										Integer.valueOf(arrayPunto[0]),
										Integer.valueOf(arrayPunto[1]));
							} else if (hijoDeNodo.getNodeName().equals("Ruta")) {
								Ruta rt = new Ruta(mapa, d, puntoAAgregar);
								rt.fromElement(hijoDeNodo);
								mapaRutas.agregar(rt);
								d.add(rt.costo());
							}
						}
					}
				}
			}
		}
		return mapaRutas;
	}
}
