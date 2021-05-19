package br.com.proway.senior.cargosESalarios.utilidades;

/**
 * Enum considerando checkbox de clique
 */
public enum Insalubridade {

	Zero(0.0), Dez(0.1), Vinte(0.2), Quarenta(0.4);

	private double valor;

	private Insalubridade(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}
	
}
