package utils;

/**
 * Utilitários do sistema
 * 
 * Esta classe é utilizada para definir métodos que são utilitários de diversas
 * partes do sistema.
 * 
 * @author * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class Validators {
	
	private Validators() {}
	
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
}


