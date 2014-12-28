package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaTuberias;

public class AccionBotonTuberia extends AccionBoton{
	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaTuberias());
		controladorMsj.recibirYNotificar("$" + Constantes.COSTO_TUBERIA);
	}
}