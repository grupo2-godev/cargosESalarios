package br.com.proway.senior.cargosESalarios.utils;

/**
 * Utilitarios do sistema
 * 
 * Esta classe eh utilizada para definir metodos que sao utilitarios de diversas
 * partes do sistema.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class Validadores {

	private Validadores() {
	}

	/**
	 * Verifica se o numero eh nulo ou se eh igual a zero.
	 * 
	 * @param numero Integer Numero a ser validado.
	 * @return boolean Retorna false se o numero for nulo ou igual a zero.
	 */
	static public boolean ehZeroOuNulo(Integer numero) {
		if (numero == null || numero == 0)
			return true;
		return false;
	}

	/**
	 * Verifica se o objeteh nulo.
	 * 
	 * @param objeto objeto que sera verificado.
	 * @return boolean
	 */
	static public boolean ehObjetoNulo(Object objeto) {
		if (objeto == null)
			return true;
		return false;
	}

	/**
	 * Verifica se ha caracteres nao alfabeticos.
	 * 
	 * @param verificar String a ser verificada
	 * @return boolean
	 */
	static public boolean apenasCaracteresValidos(String verificar) {
		return !verificar.matches(".*[!@#$%^*_+\\=\\[\\]{};':\"\\\\|.<>\\?]+.*");
	}

	/**
	 * Verifica se há caracteres não alfabéticos
	 * 
	 * @param verificar String a ser verificada
	 * @return boolean
	 */
	static public boolean apenasCaracteresNaoEspeciais(String verificar) {
		return !verificar.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
	}

	/**
	 * Verifica se há caracteres invalidos CBO1994.
	 * 
	 * @param verificar String a ser verificada.
	 * @return boolean
	 */
	static public boolean ehValidoCBODescricao(String verificar) {
		return !verificar.matches(".*[!@#$%^*_+\\=\\[\\]{};':\"\\\\|.<>\\/?]+.*");
	}

	/**
	 * Validar a quantidade de caracteres do CBO 2002.
	 * 
	 * Metodo verifica se o codigo de CBO 2002 informado eh valido, o padrao sao 6
	 * caracteres.
	 * 
	 * @param Integer codigoCBO2002 codigo que sera verificado.
	 * @return boolean
	 */
	static public boolean ehValidoCBO2002(Integer codigoCBO2002) {
		if (codigoCBO2002.toString().length() != 6) {
			return false;
		}
		return true;
	}

	/**
	 * Validar a quantidade de caracteres do CBO 1994.
	 * 
	 * Metodo verifica se o codigo de CBO 1994 informado eh valido, o padrao sao 5
	 * caracteres.
	 * 
	 * @param Integer codigo1994 codigo que sera verificado.
	 * @return boolean
	 */
	static public boolean ehValidoCBO1994(Integer codigoCBO2002) {
		if (codigoCBO2002.toString().length() != 5) {
			return false;
		}
		return true;
	}

	/**
	 * Validar numeros validos. Utilizado no HorasMesController, no metodo de
	 * criacao.
	 * 
	 * @param verificar String a ser verificada
	 * @return boolean
	 */
	static public boolean apenasNumerosValidos(String verificar) {
		return verificar.matches("(([0-9]*[.])?[0-9]+)");
	}

}
