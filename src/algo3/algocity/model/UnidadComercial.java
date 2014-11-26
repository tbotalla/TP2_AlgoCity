package algo3.algocity.model;

public class UnidadComercial extends Unidad implements Reparable, Visitable{

	int consumo;
	final int ESTADOINICIAL = 100;
	int porcentajeDanios;

	public UnidadComercial() {
		this.costo = 5;
		this.consumo = 2;
	}

	public int getConsumo() {
		return this.consumo;
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarDanio(int cantidad) {
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		} else {
			this.porcentajeDanios += cantidad;
		}
	}

	@Override
	public int getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}
	
	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 75;
		
	}

}