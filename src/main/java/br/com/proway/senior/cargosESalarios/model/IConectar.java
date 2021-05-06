package br.com.proway.senior.cargosESalarios.model;
/**
 * Classe que cria a assinatura do metodo para a conexão com o BD
 * 
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i>
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 */
public interface IConectar<T> {
	
	
	public T conectar();

}
