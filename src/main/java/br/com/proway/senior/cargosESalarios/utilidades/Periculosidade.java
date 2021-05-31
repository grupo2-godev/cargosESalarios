package br.com.proway.senior.cargosESalarios.utilidades;

/**
 * Enum considerando checkbox de clique
 */
public enum Periculosidade {
	
	Zero(0.0), Trinta(0.3);

	private double valor;

	private Periculosidade(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}
	
	public static Periculosidade getValor(double valor) {
		if(valor == 0.0) {
			return Periculosidade.Zero;
		} else if(valor == 0.3) {
			return Periculosidade.Trinta;
		} else {
			return Periculosidade.Zero;
		}
	}
	
}
