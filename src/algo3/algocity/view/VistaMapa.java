package algo3.algocity.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class VistaMapa extends JPanel {

	private static final long serialVersionUID = 5750354545703155652L;

	Mapa mapa;

	public VistaMapa(Mapa mapa) {
		this.mapa = mapa;
		setBackground(new Color(0));
		setLayout(new GridLayout(mapa.getTamanio(), mapa.getTamanio()));
		inicializarVistaTerreno();
	}

	private void inicializarVistaTerreno() {
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				add(new VistaTerreno(mapa.superficie(new Coordenada(i, j))));
			}
		}
	}

}
