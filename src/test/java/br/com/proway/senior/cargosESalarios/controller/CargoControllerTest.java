package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.utils.Insalubridade;
import br.com.proway.senior.cargosESalarios.utils.Periculosidade;

/**
 * Classe que testa os metodos da classe {@link CargoController}.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 *
 */
public class CargoControllerTest {

	static CargoController controller = new CargoController();

	static String nomeCargo = "Desenvolvedor 2";
	static LocalDateTime dataCadastro = LocalDateTime.now();
	static LocalDateTime dataUltimaRevisao = LocalDateTime.now();
	static Integer codigoCbo2002;
	static Integer codigoCbo1994;
	static Integer idHorasMes;
	static Integer idGrauInstrucao;
	static String experienciaMinima = "1";
	static String atribuicoes = "Desenvolvedor";
	static Boolean status = true;
	static Integer idPermissao = 1;

	static GrauInstrucaoModel grauInstrucao;
	static CBO2002Model cbo2002;
	static CBO1994Model cbo1994;
	static HorasMesModel horasMes;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controller.deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();

		popularTabelas();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		controller.deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
	}

	@Before
	public void beforeAll() {
		controller.deletarTodos();
	}

	public static void popularTabelas() throws Exception {
		idGrauInstrucao = new GrauInstrucaoController().cadastrar("Ensino superior completo");
		grauInstrucao = new GrauInstrucaoController().buscarPorId(idGrauInstrucao);

		codigoCbo2002 = new CBO2002Controller().cadastrarCBO2002(666666, "Desenvolvedor", Insalubridade.Dez,
				Periculosidade.Trinta);
		cbo2002 = new CBO2002Controller().buscarCBO2002PorCodigo(codigoCbo2002);

		codigoCbo1994 = new CBO1994Controller().cadastrarCBO1994(55555, "Desenvolvedor", Insalubridade.Dez,
				Periculosidade.Trinta);
		cbo1994 = new CBO1994Controller().buscarCBO1994(codigoCbo1994);

		idHorasMes = new HorasMesController().cadastrarHorasMes(240d);
		horasMes = new HorasMesController().buscarHorasMes(idHorasMes);
	}

	@Test
	public void testconstruir() throws Exception {
		assertEquals(0, controller.buscarTodos().size());

		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);

		assertNotNull(controller.cadastrar(cargo));
		assertEquals(1, controller.buscarTodos().size());
	}

	@Test(expected = Exception.class)
	public void testconstruirNomeInvalido() throws Exception {
		String nomeCargoVazio = "";
		controller.construir(nomeCargoVazio, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirCbo2002Invalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, null, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirCbo94Invalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, null, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirHorasMesInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, null, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirGrauInstrucaoInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, null,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirExperienciaMinimaInvalida() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao, "",
				atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirAtribuicoesInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, "", status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirStatusInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, null, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testconstruirIdPermissaoInvalido() throws Exception {
		controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, 0);
	}

	@Test
	public void testBuscarPorId() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
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
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrar(cargo);
		CargoModel cargoNovo = new CargoModel();
		cargoNovo.setNomeCargo("Novo cargo");
		cargoNovo.setDataCadastro(dataCadastro);
		cargoNovo.setDataUltimaRevisao(dataUltimaRevisao);
		cargoNovo.setCbo2002(cbo2002);
		cargoNovo.setCbo94(cbo1994);
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
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
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
	public void testDeletarPorId() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrar(cargo);
		assertEquals(1, controller.buscarTodos().size());
		controller.deletarPorId(idCadastrado);
		assertEquals(0, controller.buscarTodos().size());
	}

	@Test(expected = Exception.class)
	public void testDeletarPorIdInexistente() throws Exception {
		assertEquals(0, controller.buscarTodos().size());
		controller.deletarPorId(2);
	}

	@Test(expected = Exception.class)
	public void testDeletarPorIdIgualAZero() throws Exception {
		assertNull(controller.deletarPorId(0));
	}

	@Test(expected = Exception.class)
	public void testDeletarPorIdNulo() throws Exception {
		assertNull(controller.deletarPorId(null));
	}

	@Test
	public void testBuscarTodos() throws Exception {
		assertEquals(0, controller.buscarTodos().size());
		CargoModel cargo1 = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrar(cargo1);
		CargoModel cargo2 = controller.construir("Cargo dois", dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrar(cargo2);
		assertEquals(2, controller.buscarTodos().size());
	}

	@Test
	public void testDeletarTodos() throws Exception {
		CargoModel cargo = controller.construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrar(cargo);
		assertEquals(1, controller.buscarTodos().size());
		controller.deletarTodos();
		assertEquals(0, controller.buscarTodos().size());
	}

}
