package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonResidencia;

public class BotonUnidadResidencial extends Boton{

	private static final long serialVersionUID = 6553651246003455535L;

	public BotonUnidadResidencial() {
		super("img/b_residencial.png");
		setToolTipText("Unidad Residencial");
		accion = new AccionBotonResidencia();
		addActionListener(accion);
	}
}