package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Classes de testes para o PostoDeTrabalhoController.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 * @author Willian Kenji Nishizawa, willian.kenji@senior.com.br
 */

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.CargoDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

public class PostoDeTrabalhoControllerTest{
	
	static String nomePosto = "Desenvolvedor(a)";
	
	static Double salario = 1800.00;
	
	static PostoDeTrabalhoController controller = PostoDeTrabalhoController.getInstancia();
	
	static CargoModel cargo;
	static int idCargo;
	static int idNivel;
	static int idSetor;
	static CargoModel cargo1;
	static SetorModel setor;
	static SetorModel setor2;
	static NivelModel nivel;
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
		nomePosto = "Desenvolvedor(a)";
		
		salario = 1800.00;
		
		controller.deletarTodos(); 
		NivelController.getInstancia().deletarTodosNiveis();
		SetorController.getInstancia().deletarTodosSetores();
		CargoController.getInstancia().deletarTodosCargos();
		GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
		CBO2002Controller.getInstancia().deletarTodosCBO2002();
		CBO1994Controller.getInstancia().deletarTodosCBO1994();
		HorasMesController.getInstancia().deletarTodosHorasMes();
		
		popularTabelas();
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
		controller.deletarTodos(); 
		NivelController.getInstancia().deletarTodosNiveis();
		SetorController.getInstancia().deletarTodosSetores();
		CargoController.getInstancia().deletarTodosCargos();
		GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
		CBO2002Controller.getInstancia().deletarTodosCBO2002();
		CBO1994Controller.getInstancia().deletarTodosCBO1994();
		HorasMesController.getInstancia().deletarTodosHorasMes();
	}
	
	/**
	 * Devemos popular as tabelas que sao chaves estrangeiras da tabela PostoDeTrabalho.
	 * Essa funcao gera (apenas uma vez) as entradas que vao ser utilizadas em todos os testes.
	 * 
	 * @throws Exception
	 */
	public static void popularTabelas() throws Exception{
		idGrauInstrucao = GrauInstrucaoController.getInstancia().cadastrarInstrucao("Ensino superior completo");
		grauInstrucao = GrauInstrucaoController.getInstancia().buscarInstrucaoPorID(idGrauInstrucao);

		codigoCbo2002 = CBO2002Controller.getInstancia().cadastrarCBO2002(666666, "Desenvolvedor", Insalubridade.Dez,
				Periculosidade.Trinta);
		cbo2002 = CBO2002Controller.getInstancia().buscarCBO2002PorCodigo(codigoCbo2002);

		codigoCbo1994 = CBO1994Controller.getInstancia().cadastrarCBO1994(55555, "Desenvolvedor", Insalubridade.Dez,
				Periculosidade.Trinta);
		cbo1994 = CBO1994Controller.getInstancia().buscarCBO1994(codigoCbo1994);

		idHorasMes = HorasMesController.getInstancia().cadastrarHorasMes(240d);
		horasMes = HorasMesController.getInstancia().buscarHorasMes(idHorasMes);
		
		cargo = CargoController.getInstancia().construirCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Administrar Equipes", true, 1);
		
		idCargo = CargoController.getInstancia().cadastrarCargo(cargo);
		idNivel = NivelController.getInstancia().cadastrarNivel("Junior");
		idSetor = SetorController.getInstancia().cadastrarSetor("Financeiro", idCargo);
		int idSetor2 = SetorController.getInstancia().cadastrarSetor("Recursos Humanos", idCargo);
		
		cargo = CargoDAO.getInstancia().buscar(CargoModel.class, idCargo);
		setor = SetorController.getInstancia().buscarSetorPorId(idSetor);
		setor2 = SetorController.getInstancia().buscarSetorPorId(idSetor2);
		nivel = NivelController.getInstancia().buscarNivel(idNivel);
	}
	
	@Before
	public void before() throws Exception {
		controller.postoDAO.deletarTodos("posto_de_trabalho"); 
		
	}
	
	@Test
	public void cadastrarPostoDeTrabalhoTest() throws Exception {

		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		PostoDeTrabalhoModel postoRecuperado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a)", postoRecuperado.getNomePosto());
		assertEquals((Integer) idCargo, postoRecuperado.getCargo().getIdCargo());
		assertEquals((Integer) idSetor, postoRecuperado.getSetor().getId());
		assertEquals((Integer) idNivel, postoRecuperado.getNivel().getId());
		assertEquals((Double) salario, postoRecuperado.getSalario());
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarPostoDeTrabalhoNomeInvalido() throws Exception {
		controller.cadastrarPostoDeTrabalho("Inval1d0!", cargo, setor, nivel, salario);
	}
	
	@Test
	public void testDeletarPostoDeTrabalho() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(id));
	}
	
	@Test
	public void testAualizarPostoDeTrabalho() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		controller.atualizarPostoDeTrabalho(id, "Desenvolvedor(a) Junior", cargo, setor2, nivel, salario);
		PostoDeTrabalhoModel postoAtualizado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals(setor2.getId(), postoAtualizado.getSetor().getId());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void testBuscarPostoDeTrabalhoId() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals((Integer) id, postoProcurado.getIdPosto());
		assertEquals(nomePosto, postoProcurado.getNomePosto());
		assertEquals((Integer) idCargo, postoProcurado.getCargo().getIdCargo());
		assertEquals((Integer) idSetor, postoProcurado.getSetor().getId());
		assertEquals((Integer) idNivel, postoProcurado.getNivel().getId());
		assertEquals(salario, postoProcurado.getSalario());
	}
	
	@Test
	public void testBuscarPostoDeTrabalhoNome() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals(postoProcurado.getNomePosto(),
				controller.buscarPostoDeTrabalhoNome(nomePosto).get(0).getNomePosto());
	}
	
	@Test
	public void testBuscarTodosPostosDeTrabalho() throws Exception {
		controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", cargo, setor, nivel, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", cargo, setor, nivel, 7000.00);
		assertEquals(3, controller.buscarTodosPostosDeTrabalho().size());
	}	
}
