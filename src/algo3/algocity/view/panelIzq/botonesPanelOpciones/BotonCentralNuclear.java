package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonCentralNuclear;

public class BotonCentralNuclear extends Boton {

	private static final long serialVersionUID = -8374245446334969423L;
	
	public BotonCentralNuclear() {
		super("img/b_central_nuclear.png");
		setToolTipText("Central Nuclear");
		accion = new AccionBotonCentralNuclear();
		addActionListener(accion);
	}

}