package utils;

/**
 * Utilitários do sistema
 * 
 * Esta classe é utilizada para definir métodos que são utilitários de diversas
 * partes do sistema.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class Validators {
	
	private Validators() {}
	
	/**
	 * Verifica se o numero eh nulo ou se eh igual a zero.
	 * 
	 * @param numero Integer Numero a ser validado.
	 * @return boolean Retorna false se o numero for nulo ou igual a zero.
	 */
	static public boolean isZeroOrNull(Integer numero) {
		if(numero == null || numero == 0) 
			return true;
		return false;
	}
	
	static public boolean isNullObject(Object objeto) {
		if(objeto == null) 
			return true;
		return false;
	}
	
	/**
	 * Verifica se há caracteres não alfabéticos
	 * 
	 * @param verify String a ser verificada
	 * @return boolean 
	 */
	static public boolean onlyValidChars(String verify) {
		return !verify.matches(
				".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
	}
	
	/**
	 * Validar a quantidade de caracteres do CBO 2002.
	 * 
	 * Metodo verifica se o codigo de CBO 2002 informado eh valido, o padrao
	 * sao 6 caracteres.
	 * 
	 * @param Integer codigoCBO2002
	 * @return boolean
	 */
	static public boolean isCBO2002Valid(Integer codigoCBO2002) {
		if(codigoCBO2002.toString().length() != 6) {
			return false;
		}
		return true;
	}
	
	/**
	 * Validar a quantidade de caracteres do CBO 1994.
	 * 
	 * Metodo verifica se o codigo de CBO 1994 informado eh valido, o padrao
	 * sao 5 caracteres.
	 * 
	 * @param Integer codigo1994
	 * @return boolean
	 */
	static public boolean isCBO1994Valid(Integer codigoCBO2002) {
		if(codigoCBO2002.toString().length() != 5) {
			return false;
		}
		return true;
	}

	/*
	 * Utilizar no HorasMesController, create
	 */
	static public boolean onlyValidNumber(String verify) {
		return verify.matches(
				"(([0-9]*[.])?[0-9]+)");
	}
	

}


