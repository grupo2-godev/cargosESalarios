package br.com.proway.senior.cargosESalarios.controller.API;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

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
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6 
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
		new GrauInstrucaoController().deletarTodasInstrucoes();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();

		popularTabelas();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		controller.deletarTodosCargos();
		new GrauInstrucaoController().deletarTodasInstrucoes();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
	}

	@Before
	public void beforeAll() {
		controller.deletarTodosCargos();
	}
	

	public static void popularTabelas() throws Exception {
		idGrauInstrucao = new GrauInstrucaoController().cadastrarInstrucao("Ensino superior completo");
		grauInstrucao = new GrauInstrucaoController().buscarInstrucaoPorID(idGrauInstrucao);

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
	public void testBuscarCargoPorID() throws Exception {

		CargoModel cargo = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);

		int idCargo = controller.cadastrarCargo(cargo);
		
		CargoModelDTO cargoDTO = cargoAPI.buscarPorID(idCargo);
		
		assertNotNull(cargoDTO);
		assertEquals(cargoDTO.getExperienciaMinima(), experienciaMinima);
		assertEquals(cargoDTO.getStatus(), status);
		assertEquals(cargoDTO.getDataUltimaRevisao(), dataUltimaRevisao);
		assertEquals(cargoDTO.getNomeCargo(), nomeCargo);
		assertEquals((int)cargoDTO.getIdCargo(), idCargo);		
		assertTrue(cargoDTO.getCbo94().equals(cbo1994));
		assertTrue(cargoDTO.getCbo2002().equals(cbo2002));
		assertTrue(cargoDTO.getGrauInstrucao().equals(grauInstrucao));
		assertTrue(cargoDTO.getHoraMes().equals(horasMes));
	
	}

	@Test
	public void testBuscarTodosCargos() throws Exception {
		CargoModel cargo1 = controller.construirCargo(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		CargoModel cargo2 = controller.construirCargo("Desenvolvedor 1", dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
				
		controller.cadastrarCargo(cargo1);
		controller.cadastrarCargo(cargo2);
		
		assertFalse(cargoAPI.buscarTodos().isEmpty());		
	}
}
