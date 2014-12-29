package algo3.algocity.view.panelDer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import algo3.algocity.model.catastrofes.Catastrofe;
import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.catastrofes.GeneradorCatastrofe;

public class VistaCatastrofe implements Observer {

	VistaMapa contenedor;
	AudioStream audioStream;

	public VistaCatastrofe(GeneradorCatastrofe genCatastrofe,
			VistaMapa vistaMapa) {
		contenedor = vistaMapa;
		genCatastrofe.addObserver(this);

		try {
			InputStream in = new FileInputStream(
					new File("sound/terremoto.wav"));
			audioStream = new AudioStream(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		enviarMensaje((Catastrofe) arg1);
		AudioPlayer.player.start(audioStream);
	}

	private void enviarMensaje(Catastrofe arg1) {
		String mensaje = (arg1.getClass().equals(CatastrofeTerremoto.class)) ? "TERREMOTO!!!!"
				: "GODZILLA!!!!";
		contenedor.getContenedor().getVentana().getControladorMensajes()
				.recibirYNotificar(mensaje);

	}
}
