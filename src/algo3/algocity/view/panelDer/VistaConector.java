package algo3.algocity.view.panelDer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;

import javax.swing.ImageIcon;

import algo3.algocity.controller.ControladorMouseMapaSup;
import algo3.algocity.model.Juego;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.mapas.Coordenada;

public class VistaConector extends VistaPosicion {
	
	Conector conector;

public VistaConector(Juego j, Coordenada c, Conector conector) {
	super(j, c);
	this.conector = conector;
	controlador = new ControladorMouseMapaSup(juego, c, this);
	addMouseListener(controlador);
	setImagen();
	revalidate();
	repaint();
	}

	private static final long serialVersionUID = 3597702358238152950L;

	@Override
	public void setImagen() {
		setImagen(conector);
	}
	
	public void setImagen(Conector conector) {
		try {
			System.out.println("try");
			Method method = getClass()
					.getMethod("setImagen", conector.getClass());
			method.invoke(this, conector);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void setImagen(Ruta ruta){
		imagen = new ImageIcon("img/ruta.png").getImage();
		System.out.println("ruta");
	}
	
	public void setImagen(LineaTension linea){
		imagen = new ImageIcon("img/linea_tension.png").getImage();
		System.out.println("linea");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setImagen();
		repaint();

	}

}
