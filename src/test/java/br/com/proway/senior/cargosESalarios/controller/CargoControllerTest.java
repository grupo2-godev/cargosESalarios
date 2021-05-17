package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CargoModel;

/**
 * Classe que testa os metodos da classe {@link CargoController}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class CargoControllerTest {

	CargoController controller = new CargoController();

	String nomeCargo = "Desenvolvedor 2";
	LocalDateTime dataCadastro = LocalDateTime.now();
	LocalDateTime dataUltimaRevisao = LocalDateTime.now();
	Integer cbo2002 = 1;
	Integer cbo94 = 1;
	Integer horasMes = 220;
	Integer grauInstrucao = 1;
	String experienciaMinima = "1";
	String atribuicoes = "Desenvolvedor";
	Boolean status = true;
	Integer idPermissao = 1;

	@Test
	public void testconstruir() throws Exception {
		assertEquals(0, controller.buscarTodos().size());

		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);

		assertNotNull(controller.cadastrar(cargo));
		assertEquals(1, controller.buscarTodos().size());
	}

	@Test(expected = Exception.class)
	public void testconstruirNomeInvalido() throws Exception {
		String nomeCargoVazio = "";
		controller.construir(nomeCargoVazio, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirCbo2002Invalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, 0, cbo94, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirCbo94Invalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, 0, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirHorasMesInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, 0, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirGrauInstrucaoInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes, 0, experienciaMinima,
				atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirExperienciaMinimaInvalida() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes, grauInstrucao, "",
				atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirAtribuicoesInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes, grauInstrucao,
				experienciaMinima, "", status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirStatusInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, null, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirIdPermissaoInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, 0);
	}

	@Test
	public void testBuscarPorId() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrar(cargo);
		CargoModel cargoConsultado = controller.buscarPorId(idCadastrado);
		assertNotNull(cargoConsultado);
		assertEquals("Desenvolvedor 2", cargoConsultado.getNomeCargo());
	}

	@Test(expected = Exception.class)
	public void testBuscarPorIdInvalido() throws Exception {
		controller.buscarPorId(0);
	}

	@Test
	public void testAlterar() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrar(cargo);
		CargoModel cargoNovo = new CargoModel();
		cargoNovo.setNomeCargo("Novo cargo");
		cargoNovo.setDataCadastro(dataCadastro);
		cargoNovo.setDataUltimaRevisao(dataUltimaRevisao);
		cargoNovo.setCbo2002(cbo2002);
		cargoNovo.setCbo94(cbo94);
		cargoNovo.setHoraMes(horasMes);
		cargoNovo.setGrauInstrucao(grauInstrucao);
		cargoNovo.setExperienciaMinima(experienciaMinima);
		cargoNovo.setAtribuicoes(atribuicoes);
		cargoNovo.setStatus(status);
		cargoNovo.setIdPermissao(idPermissao);
		controller.alterar(idCadastrado, cargoNovo);
		assertEquals("Novo cargo", controller.buscarPorId(idCadastrado).getNomeCargo());
	}

	@Test(expected = Exception.class)
	public void testAlterarObjetoNulo() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrar(cargo);
		CargoModel cargoNovo = null;

		controller.alterar(idCadastrado, cargoNovo);
	}
	
	@Test(expected = Exception.class) 
	public void testAlterarIdInexistente() throws Exception {
		CargoModel cargoModel = new CargoModel();
		controller.alterar(2, cargoModel);
	}

	@Test
	public void buscarTodos() throws Exception {
		assertEquals(0, controller.buscarTodos().size());
		CargoModel cargo1 = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrar(cargo1);
		CargoModel cargo2 = controller.construir("Cargo dois", dataCadastro, dataUltimaRevisao, cbo2002, cbo94,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrar(cargo2);
		assertEquals(2, controller.buscarTodos().size());
	}

	@Test
	public void testDeletarTodos() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrar(cargo);
		assertEquals(1, controller.buscarTodos().size());
		controller.deletarTodos();
		assertEquals(0, controller.buscarTodos().size());
	}

	@Before
	public void beforeAll() {
		controller.deletarTodos();
	}
}
