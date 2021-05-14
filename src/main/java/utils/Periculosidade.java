package utils;

public enum Periculosidade {
	
	Zero(0.0), Trinta(0.3);

	private double valor;

	private Periculosidade(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}
	
}