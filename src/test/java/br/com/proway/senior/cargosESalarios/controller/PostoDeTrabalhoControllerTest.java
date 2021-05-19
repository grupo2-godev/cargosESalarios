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

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

public class PostoDeTrabalhoControllerTest{
	
	static String nomePosto = "Desenvolvedor(a)";
	
	static Double salario = 1800.00;
	
	static PostoDeTrabalhoController controller = new PostoDeTrabalhoController();
	
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
		
		controller.deletarTodosPostosDeTrabalho(); 
		new NivelController().deletarTodosNiveis();
		new SetorController().deletarTodosSetores();
		new CargoController().deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
		controller = new PostoDeTrabalhoController();
		
		popularTabelas();
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
		controller.deletarTodosPostosDeTrabalho(); 
		new NivelController().deletarTodosNiveis();
		new SetorController().deletarTodosSetores();
		new CargoController().deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
		controller = new PostoDeTrabalhoController();
	}
	
	/**
	 * Devemos popular as tabelas que sao chaves estrangeiras da tabela PostoDeTrabalho.
	 * Essa funcao gera (apenas uma vez) as entradas que vao ser utilizadas em todos os testes.
	 * 
	 * @throws Exception
	 */
	public static void popularTabelas() throws Exception{
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
		
		cargo = new CargoController().construir("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Administrar Equipes", true, 1);
		
		idCargo = new CargoController().cadastrar(cargo);
		idNivel = new NivelController().cadastrarNivel("Junior");
		idSetor = new SetorController().cadastrarSetor("Financeiro", idCargo);
		int idSetor2 = new SetorController().cadastrarSetor("Recursos Humanos", idCargo);
		
		cargo = CargoDAO.getInstancia(ConexaoHibernate.getSessao()).buscar(idCargo);
		setor = new SetorController().buscarSetorPorId(idSetor);
		setor2 = new SetorController().buscarSetorPorId(idSetor2);
		nivel = new NivelController().buscarNivel(idNivel);
	}
	
	@Before
	public void before() throws Exception {
		controller.postoDAO.deletarTodos(); 
		
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
	public void cadastrarPostoDeTrabalhoTestNomeInvalido() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho("Inval1d0!", cargo, setor, nivel, salario);
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(id));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		controller.atualizarPostoDeTrabalho(id, "Desenvolvedor(a) Junior", cargo, setor2, nivel, salario);
		PostoDeTrabalhoModel postoAtualizado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals(setor2.getId(), postoAtualizado.getSetor().getId());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() throws Exception {
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
	public void buscarPostoDeTrabalhoNomeTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals(postoProcurado.getNomePosto(),
				controller.buscarPostoDeTrabalhoNome(nomePosto).get(0).getNomePosto());
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() throws Exception {
		controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", cargo, setor, nivel, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", cargo, setor, nivel, 7000.00);
		assertEquals(3, controller.buscarTodosPostosDeTrabalho().size());
	}
	
	
	
}
