package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

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
		controller.deletarTodosCargos();
		GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
		CBO2002Controller.getInstancia().deletarTodosCBO2002();
		CBO1994Controller.getInstancia().deletarTodosCBO1994();
		HorasMesController.getInstancia().deletarTodosHorasMes();

		popularTabelas();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		controller.deletarTodosCargos();
		GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
		CBO2002Controller.getInstancia().deletarTodosCBO2002();
		CBO1994Controller.getInstancia().deletarTodosCBO1994();
		HorasMesController.getInstancia().deletarTodosHorasMes();
	}

	@Before
	public void beforeAll() {
		controller.deletarTodosCargos();
	}

	public static void popularTabelas() throws Exception {
		idGrauInstrucao = GrauInstrucaoController.getInstancia().cadastrarInstrucao("Ensino superior completo");
		grauInstrucao = GrauInstrucaoController.getInstancia().buscarInstrucaoPorID(idGrauInstrucao);

		codigoCbo2002 = CBO2002Controller.getInstancia().cadastrarCBO2002(666666, "Desenvolvedor", 0.1,
				0.3);
		cbo2002 = CBO2002Controller.getInstancia().buscarCBO2002PorCodigo(codigoCbo2002);

		codigoCbo1994 = CBO1994Controller.getInstancia().cadastrarCBO1994(55555, "Desenvolvedor", 0.1,
				0.3);
		cbo1994 = CBO1994Controller.getInstancia().buscarCBO1994(codigoCbo1994);

		idHorasMes = HorasMesController.getInstancia().cadastrarHorasMes(240d);
		horasMes = HorasMesController.getInstancia().buscarHorasMes(idHorasMes);
	}

	@Test
	public void testConstruirCargo() throws Exception {
		assertEquals(0, controller.buscarTodosCargos().size());

		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);

		assertNotNull(controller.cadastrarCargo(cargo));
		assertEquals(1, controller.buscarTodosCargos().size());
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComNomeInvalido() throws Exception {
		String nomeCargoVazio = "";
		controller.construirCargo(nomeCargoVazio, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComCBO2002Invalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, null, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComCBO94Invalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, null, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComHorasMesInvalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, null, grauInstrucao,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComGrauInstrucaoInvalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, null,
				experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComExperienciaMinimaInvalida() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao, "",
				atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComAtribuicoesInvalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, "", status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComStatusInvalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, null, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testConstruirCargoComIdPermissaoInvalido() throws Exception {
		controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes, grauInstrucao,
				experienciaMinima, atribuicoes, status, 0);
	}

	@Test
	public void testBuscarCargoPorId() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrarCargo(cargo);
		CargoModel cargoConsultado = controller.buscarCargoPorID(idCadastrado);
		assertNotNull(cargoConsultado);
		assertEquals("Desenvolvedor 2", cargoConsultado.getNomeCargo());
	}

	@Test(expected = Exception.class)
	public void testBuscarCargoPorIdInvalido() throws Exception {
		controller.buscarCargoPorID(0);
	}

	@Test
	public void testAtualizarCargo() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrarCargo(cargo);
		CargoModel cargoNovo = new CargoModel();
		cargoNovo.setNomeCargo("Novo cargo");
		cargoNovo.setDataCadastro(dataCadastro);
		cargoNovo.setDataUltimaRevisao(dataUltimaRevisao);
		cargoNovo.setCbo2002(cbo2002);
		cargoNovo.setCbo94(cbo1994);
		cargoNovo.setHorasMes(horasMes);
		cargoNovo.setGrauInstrucao(grauInstrucao);
		cargoNovo.setExperienciaMinima(experienciaMinima);
		cargoNovo.setAtribuicoes(atribuicoes);
		cargoNovo.setStatus(status);
		cargoNovo.setIdPermissao(idPermissao);
		controller.atualizarCargo(idCadastrado, cargoNovo);
		assertEquals("Novo cargo", controller.buscarCargoPorID(idCadastrado).getNomeCargo());
	}

	@Test(expected = Exception.class)
	public void testAtualizarCargoParaObjetoNulo() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrarCargo(cargo);
		CargoModel cargoNovo = null;

		controller.atualizarCargo(idCadastrado, cargoNovo);
	}

	@Test(expected = Exception.class)
	public void testAtualizarCargoParaIDInexistente() throws Exception {
		CargoModel cargoModel = new CargoModel();
		controller.atualizarCargo(2, cargoModel);
	}

	@Test
	public void testDeletarCargoPorID() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		Integer idCadastrado = controller.cadastrarCargo(cargo);
		assertEquals(1, controller.buscarTodosCargos().size());
		controller.deletarCargoPorID(idCadastrado);
		assertEquals(0, controller.buscarTodosCargos().size());
	}

	@Test(expected = Exception.class)
	public void testDeletarCargoPorIdInexistente() throws Exception {
		assertEquals(0, controller.buscarTodosCargos().size());
		controller.deletarCargoPorID(2);
	}

	@Test(expected = Exception.class)
	public void testDeletarCargoPorIdIgualAZero() throws Exception {
		assertNull(controller.deletarCargoPorID(0));
	}

	@Test(expected = Exception.class)
	public void testDeletarCargoPorIdNulo() throws Exception {
		assertNull(controller.deletarCargoPorID(null));
	}

	@Test
	public void testBuscarTodosCargos() throws Exception {
		assertEquals(0, controller.buscarTodosCargos().size());
		CargoModel cargo1 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrarCargo(cargo1);
		CargoModel cargo2 = controller.construirCargo("Cargo dois", dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrarCargo(cargo2);
		assertEquals(2, controller.buscarTodosCargos().size());
	}

	@Test
	public void testDeletarTodosCargos() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrarCargo(cargo);
		assertEquals(1, controller.buscarTodosCargos().size());
		controller.deletarTodosCargos();
		assertEquals(0, controller.buscarTodosCargos().size());
	}
	
	@Test
	public void testBuscarCargoPeloNomeCargo() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrarCargo(cargo);
		
		assertEquals(1, controller.buscarCargoPorNomeCargo("Desenvolvedor 2").size());

	}

}
