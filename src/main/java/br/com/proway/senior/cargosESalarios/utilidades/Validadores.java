package br.com.proway.senior.cargosESalarios.utilidades;

import br.com.proway.senior.cargosESalarios.exceptions.AtribuicoesNaoInformadasException;
import br.com.proway.senior.cargosESalarios.exceptions.CBO1994NuloException;
import br.com.proway.senior.cargosESalarios.exceptions.CBO2002NuloException;
import br.com.proway.senior.cargosESalarios.exceptions.ExperienciaMinimaNulaException;
import br.com.proway.senior.cargosESalarios.exceptions.GrauInstrucaoNuloException;
import br.com.proway.senior.cargosESalarios.exceptions.HorasMesNuloException;
import br.com.proway.senior.cargosESalarios.exceptions.IdPermissaoNuloException;
import br.com.proway.senior.cargosESalarios.exceptions.NomeDoCargoInvalidoException;
import br.com.proway.senior.cargosESalarios.exceptions.StatusInvalidoException;
import br.com.proway.senior.cargosESalarios.model.CargoModel;

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


	static public boolean validacaoCargo(CargoModel cargo) throws Exception {	
	
	if (Validadores.ehObjetoNulo(cargo.getNomeCargo()) || cargo.getNomeCargo().isEmpty())
		throw (new NomeDoCargoInvalidoException("O nome do cargo não foi informado."));
	if (Validadores.ehObjetoNulo(cargo.getCbo2002()))
		throw (new CBO2002NuloException("O cbo2002 não foi informado."));
	if (Validadores.ehObjetoNulo(cargo.getCbo94()))
		throw (new CBO1994NuloException("O cbo94 não foi informado."));
	if (Validadores.ehObjetoNulo(cargo.getHoraMes()))
		throw (new HorasMesNuloException("A quantidade de horas trabalhadas por mês não pode ser igual a zero."));
	if (Validadores.ehObjetoNulo(cargo.getGrauInstrucao()))
		throw (new GrauInstrucaoNuloException("O grau de instrução não foi informado."));
	if (Validadores.ehObjetoNulo(cargo.getExperienciaMinima()) || cargo.getExperienciaMinima().isEmpty())
		throw (new ExperienciaMinimaNulaException("A experiencia mínima não foi informada."));
	if (Validadores.ehObjetoNulo(cargo.getAtribuicoes()) || cargo.getAtribuicoes().isEmpty())
		throw (new AtribuicoesNaoInformadasException("As atribuicoes não foram informadas."));
	if (Validadores.ehObjetoNulo(cargo.getStatus()))
		throw (new StatusInvalidoException("O status não foi informado."));
	if (Validadores.ehZeroOuNulo(cargo.getIdPermissao()))
		throw (new IdPermissaoNuloException("A permissao não foi informada."));
	
	return true;
	}
}
