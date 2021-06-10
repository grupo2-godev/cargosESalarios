package br.com.proway.senior.cargosESalarios.controller.API;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.controller.CBO1994Controller;
import br.com.proway.senior.cargosESalarios.controller.CBO2002Controller;
import br.com.proway.senior.cargosESalarios.controller.CargoController;
import br.com.proway.senior.cargosESalarios.controller.GrauInstrucaoController;
import br.com.proway.senior.cargosESalarios.controller.HorasMesController;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.DTO.CargoModelDTO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

/**
 * Classe que testa os metodos da classe {@link CargoControllerAPI}.
 * 
 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong>
 *         - Sprint 6
 *
 */
public class CargoControllerAPITest {

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

	CargoControllerAPI cargoAPI = new CargoControllerAPI();
	static CargoController controller = new CargoController();

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
	public void testBuscarCargoPorID() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		int idCargo = controller.cadastrarCargo(cargo);
		CargoModelDTO cargoDTO = (CargoModelDTO) (cargoAPI.buscarPorID(idCargo).getBody());
		assertNotNull(cargoDTO);
		assertEquals(cargoDTO.getExperienciaMinima(), experienciaMinima);
		assertEquals(cargoDTO.getStatus(), status);
		assertEquals(cargoDTO.getNomeCargo(), nomeCargo);
		assertEquals((int) cargoDTO.getIdCargo(), idCargo);
		assertTrue(cargoDTO.getCbo94().equals(cbo1994));
		assertTrue(cargoDTO.getCbo2002().equals(cbo2002));
		assertTrue(cargoDTO.getGrauInstrucao().equals(grauInstrucao));
		assertTrue(cargoDTO.getHorasMes().equals(horasMes));
	}
	
	@Test
	public void testBuscarCargoPorIDComIDInvalido() throws Exception {
		String textoDeErro = (String) (cargoAPI.buscarPorID(0).getBody());
		assertEquals("Nao ha cargo cadastrado com este ID", textoDeErro);
	}
	
	@Test
	public void testBuscarTodosCargos() throws Exception {
		CargoModel cargo1 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		CargoModel cargo2 = controller.construirCargo("Desenvolvedor 1", dataCadastro, dataUltimaRevisao, cbo2002,
				cbo1994, horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);

		controller.cadastrarCargo(cargo1);
		controller.cadastrarCargo(cargo2);

		assertEquals(((ArrayList<CargoModelDTO>) (cargoAPI.buscarTodos().getBody())).size(), 2);
	}

	@Test
	public void testPostCargo() throws Exception {
		CargoModel cargo1 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		int id = (int) cargoAPI.postCargo(cargo1).getBody();
		assertTrue(id > 0);
	}

	@Test
	public void testDeletarCargo() throws Exception {
		CargoModel cargo1 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		int id = (int) cargoAPI.postCargo(cargo1).getBody();
		assertTrue((boolean) cargoAPI.deletarCargo(id).getBody());
	}
	
	@Test
	public void testDeletarCargoComIdInvalido() throws Exception {
		assertEquals((String) cargoAPI.deletarCargo(0).getBody(), "Objeto não encontrado! Id: 0, Tipo: CargoModel");
	}

	@Test
	public void testAtualizarCargo() throws Exception {
		CargoModel cargo1 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		int id = controller.cadastrarCargo(cargo1);
		cargo1.setAtribuicoes("Programar em python");
		cargoAPI.atualizarCargo(id, cargo1);
		assertTrue((boolean) cargoAPI.deletarCargo(id).getBody());
	}
	
	@Test
	public void testAtualizarCargoComCargoInvalido() throws Exception {
		CargoModel cargo1 = null;
		CargoModel cargo2 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		int id = controller.cadastrarCargo(cargo2);
		assertEquals((String) cargoAPI.atualizarCargo(id, cargo1).getBody(), "Objeto não encontrado! Id: " + id + ", Tipo: CargoModel");
	}

	@Test
	public void testBuscarCargoPeloNomeCargo() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrarCargo(cargo);

		assertEquals(1,
				((ArrayList<CargoModelDTO>) (cargoAPI.buscarCargosPeloNome("Desenvolvedor 2").getBody())).size());
	}

	@Test
	public void testBuscarCargoPeloNomeCargoSemCargosCadastrados() throws Exception {
		String texto = (String) cargoAPI.buscarCargosPeloNome("Desenvolvedor 2").getBody();
		assertEquals("Não foram encontrados cargos com o nome informado", texto);
	}
	
	@Test
	public void testBuscarCargoPeloNomeCargoComNomeInvalido() throws Exception {
		String texto = (String) cargoAPI.buscarCargosPeloNome("Desenvolvedor./#$").getBody();
		assertEquals("O nome informado é invalido", texto);
	}
	
	@Test
	public void testBuscarCargoPeloNomeCargoComNomeNulo() throws Exception {
		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994,
				horasMes, grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		controller.cadastrarCargo(cargo);
		ArrayList<CargoModelDTO> listaCargos = (ArrayList<CargoModelDTO>) cargoAPI.buscarCargosPeloNome(null).getBody();
		assertEquals(1, listaCargos.size());
	}

	@Test
	public void testBuscarCargoPeloNomeCargoComNomeNuloESemCargoCadastrado() throws Exception {
		String texto = (String) cargoAPI.buscarCargosPeloNome(null).getBody();
		assertEquals("Nao ha cargos cadastrados", texto);
	}
}
