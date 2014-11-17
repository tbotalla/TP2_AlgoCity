package algo3.algocity.model;

public class Edificador {
	
	int costoUnidadResidencial;
	int costoUnidadIndustrial;
	int costoUnidadComercial;
	int costoCentralEolica;
	int costoCentralMinera;
	int costoCentralNuclear;
	int costoEstacionDebomberos;
	int costoPozoDeAgua;
	//Porque el consumo y la capacidad no son atributos tambien?
	int consumoUnidadResidencial;
	int consumoUnidadIndustrial;
	int consumoUnidadComercial;
	
	int capacidadUnidadResidencial;
	int capacidadUnidadIndustrial;
	
	
	public Edificador(){
		this.costoUnidadResidencial = 5;
		this.costoUnidadIndustrial = 10;
		this.costoUnidadComercial = 5;
		this.costoCentralEolica = 1000;
		this.costoCentralMinera = 3000;
		this.costoCentralNuclear = 10000;
		this.costoEstacionDebomberos = 1500;
		this.costoPozoDeAgua = 250;
		
		this.consumoUnidadResidencial = 1;
		this.consumoUnidadComercial = 2;
		this.consumoUnidadIndustrial = 5;
		
		this.capacidadUnidadResidencial = 100;
		this.capacidadUnidadIndustrial = 25;
		
	}
	
	public UnidadComercial construirUnidadComercial(){
		return new UnidadComercial(this.costoUnidadComercial,this.consumoUnidadComercial);
	}
	
	public UnidadOcupable construirUnidadIndustrial(){
		return new UnidadOcupable(this.costoUnidadIndustrial, this.consumoUnidadIndustrial, this.capacidadUnidadIndustrial);
	}
	
	public UnidadOcupable construirUnidadResidencial(){
		return new UnidadOcupable(this.costoUnidadResidencial, this.consumoUnidadResidencial, this.capacidadUnidadResidencial);
	}
	
	public PozoDeAgua construirPozoDeAgua(){
		return new PozoDeAgua(this.costoPozoDeAgua);
	}
	
	public EstacionDeBomberos construirEstacionDeBomberos(){
		return new EstacionDeBomberos(this.costoEstacionDebomberos);
	}
}
