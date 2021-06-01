package br.com.proway.senior.cargosESalarios.model.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.controller.CBO1994Controller;
import br.com.proway.senior.cargosESalarios.controller.CBO2002Controller;
import br.com.proway.senior.cargosESalarios.controller.CargoController;
import br.com.proway.senior.cargosESalarios.controller.GrauInstrucaoController;
import br.com.proway.senior.cargosESalarios.controller.HorasMesController;
import br.com.proway.senior.cargosESalarios.controller.NivelController;
import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

/**
 * Classes de testes para o PostoDeTrabalhoDAO.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b>
 */

public class PostoDeTrabalhoDAOTest {

	static String nomePosto = "Desenvolvedor(a)";
	
	static Double salario = 1800.00;
	
	static CargoModel cargo;
	static int idCargo;
	static int idNivel;
	static int idSetor;
	static CargoModel cargoRecuperado;
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
	
	static PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstancia();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nomePosto = "Desenvolvedor(a)";
		
		salario = 1800.00;
		
		limparTabelas();
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
		
		limparTabelas();
		NivelController.getInstancia().deletarTodosNiveis();
		SetorController.getInstancia().deletarTodosSetores();
		CargoController.getInstancia().deletarTodosCargos();
		GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
		CBO2002Controller.getInstancia().deletarTodosCBO2002();
		CBO1994Controller.getInstancia().deletarTodosCBO1994();
		HorasMesController.getInstancia().deletarTodosHorasMes();
	}
	
	public static void limparTabelas() throws SQLException {
		postoDAO.deletarTodos("posto_de_trabalho"); 
		
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

		codigoCbo2002 = CBO2002Controller.getInstancia().cadastrarCBO2002(666666, "Desenvolvedor", 0.1,
				0.3);
		cbo2002 = CBO2002Controller.getInstancia().buscarCBO2002PorCodigo(codigoCbo2002);

		codigoCbo1994 = CBO1994Controller.getInstancia().cadastrarCBO1994(55555, "Desenvolvedor", 0.1,
				0.3);
		cbo1994 = CBO1994Controller.getInstancia().buscarCBO1994(codigoCbo1994);

		idHorasMes = HorasMesController.getInstancia().cadastrarHorasMes(240d);
		horasMes = HorasMesController.getInstancia().buscarHorasMes(idHorasMes);
		
		cargo = CargoController.getInstancia().construirCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Administrar Equipes", true, 1);
		idCargo = CargoDAO.getInstancia().criar(cargo);
		idNivel = NivelController.getInstancia().cadastrarNivel("Junior");
		idSetor = SetorController.getInstancia().cadastrarSetor("Financeiro", idCargo);
		int idSetor2 = SetorController.getInstancia().cadastrarSetor("Recursos Humanos", idCargo);
		
		cargoRecuperado = CargoDAO.getInstancia().buscar(CargoModel.class, idCargo);
		setor = SetorController.getInstancia().buscarSetorPorId(idSetor);
		setor2 = SetorController.getInstancia().buscarSetorPorId(idSetor2);
		nivel = NivelController.getInstancia().buscarNivel(idNivel);
		
	}
	
	@Test
	public void testCriarPostoDeTrabalho() throws SQLException {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Gerente Gestão de Pessoas", cargo, setor, nivel, 
				salario);
		Integer idPostoCadastrado = postoDAO.criar(novoPosto);
		Object postoConsultado = ConexaoHibernate.getSessao().get(PostoDeTrabalhoModel.class, idPostoCadastrado);
		assertEquals(idPostoCadastrado, ((PostoDeTrabalhoModel) postoConsultado).getIdPosto());
	}

	@Test
	public void testBuscarPostoDeTrabalhoPorID() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Desenvolvedor ERP", cargo, setor, nivel, 2900.00);
		Integer idPostoCadastrado = postoDAO.criar(novoPosto);
		PostoDeTrabalhoModel postoConsultado = postoDAO.buscar(PostoDeTrabalhoModel.class, idPostoCadastrado);
		assertEquals(novoPosto.getNomePosto(), postoConsultado.getNomePosto());
		assertEquals(novoPosto.getCargo().getIdCargo(), postoConsultado.getCargo().getIdCargo());
		assertEquals(novoPosto.getSetor().getId(), postoConsultado.getSetor().getId());
		assertEquals(novoPosto.getNivel().getId(), postoConsultado.getNivel().getId());
		assertEquals(novoPosto.getSalario(), postoConsultado.getSalario());
	}

	@Test
	public void testBuscarPostoDeTrabalhoPorNome() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Analista Gestão de Pessoas", cargo, setor, nivel, 
				2700.00);
		postoDAO.criar(novoPosto);
		ArrayList<PostoDeTrabalhoModel> listaRetornada = (ArrayList<PostoDeTrabalhoModel>) postoDAO.listarPorValorDeColunaComStringIncompleta(PostoDeTrabalhoModel.class, "nomePosto", "Analist");
		assertEquals(novoPosto.getNomePosto(), listaRetornada.get(0).getNomePosto());
		assertEquals(novoPosto.getCargo().getIdCargo(), listaRetornada.get(0).getCargo().getIdCargo());
		assertEquals(novoPosto.getSetor().getId(), listaRetornada.get(0).getSetor().getId());
		assertEquals(novoPosto.getNivel().getId(), listaRetornada.get(0).getNivel().getId());
		assertEquals(novoPosto.getSalario(), listaRetornada.get(0).getSalario());
	}

	@Test
	public void testAtualizarPostoDeTrabalho() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Analista Financeiro", cargo, setor, nivel, 2750.00);
		PostoDeTrabalhoModel postoAlterado = new PostoDeTrabalhoModel("Analista Financeiro", cargo, setor2, nivel, 
				2800.00);
		Integer idCriado = postoDAO.criar(novoPosto);
		postoAlterado.setIdPosto(idCriado);
		
		postoDAO.atualizar(postoAlterado);
		PostoDeTrabalhoModel atualizado = postoDAO.buscar(PostoDeTrabalhoModel.class, idCriado);
		
		System.out.println();
		assertEquals(postoAlterado.getNomePosto(), atualizado.getNomePosto());
		assertEquals(postoAlterado.getCargo().getIdCargo(), atualizado.getCargo().getIdCargo());
		assertEquals(postoAlterado.getSetor().getId(), atualizado.getSetor().getId());
		assertEquals(postoAlterado.getNivel().getId(), atualizado.getNivel().getId());
		assertEquals(postoAlterado.getSalario(), atualizado.getSalario());
	}

	@Test
	public void testDeletarPostoDeTrabalho() {
		int size = postoDAO.listarPorTabela(PostoDeTrabalhoModel.class).size();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Gerente de Marketing Marcas", cargo, setor, nivel, 
				9000.0);
		int idCriada = postoDAO.criar(novoPosto);
		postoDAO.deletar(PostoDeTrabalhoModel.class, idCriada);
		assertEquals(size, postoDAO.listarPorTabela(PostoDeTrabalhoModel.class).size());
	}

	@Test
	public void testBuscarTodosOsPostosDeTrabalho() {
		PostoDeTrabalhoModel novoPosto1 = new PostoDeTrabalhoModel("Coordenador de Suporte", cargo, setor, nivel, 
				6000.0);
		PostoDeTrabalhoModel novoPosto2 = new PostoDeTrabalhoModel("Coordenador de Atendimento", cargo, setor, nivel, 
				6500.0);
		postoDAO.criar(novoPosto1);
		postoDAO.criar(novoPosto2);
		assertFalse(postoDAO.listarPorTabela(PostoDeTrabalhoModel.class).isEmpty());
	}

	@Test
	public void testDeletarTodosOsPostosDeTrabalho() {
		PostoDeTrabalhoModel novoPosto1 = new PostoDeTrabalhoModel("Técnico(a) Segurança do Trabalho", cargo, setor, 
				nivel, 6000.0);
		postoDAO.criar(novoPosto1);
		postoDAO.deletarTodos("posto_de_trabalho");
		assertTrue(postoDAO.listarPorTabela(PostoDeTrabalhoModel.class).isEmpty());
	}
	
	@Test
	public void testConstrutorVazio() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setNomePosto("Vendedor de Loja");
		novoPosto.setSalario(1700.00);
		assertEquals("Vendedor de Loja", novoPosto.getNomePosto());
		assertEquals(1700.00, novoPosto.getSalario(), 0.01);
	}

	@Test
	public void testConstrutorComID() {
		CargoModel cargo = new CargoModel();
		SetorModel setor = new SetorModel();
		NivelModel nivel = new NivelModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel(1, "Coordenador de Suporte", cargo, setor, nivel, 
				7000.00);
		assertEquals((Integer) 1, novoPosto.getIdPosto());
		assertEquals("Coordenador de Suporte", novoPosto.getNomePosto());
		assertEquals(7000.00, novoPosto.getSalario(), 0.01);	
	}
	
	@Test
	public void testConstrutorSemID() {
		CargoModel cargo = new CargoModel();
		SetorModel setor = new SetorModel();
		NivelModel nivel = new NivelModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Coordenador de Suporte", cargo, setor, nivel, 
				7000.00);
		assertEquals("Coordenador de Suporte", novoPosto.getNomePosto());
		assertEquals(7000.00, novoPosto.getSalario(), 0.01);	
	}
	
	@Test
	public void testGetESetIdPosto() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setIdPosto(3);
		assertEquals((Integer) 3, novoPosto.getIdPosto());
	}
	
	@Test
	public void testGetESetNomePosto() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setNomePosto("Assistente de E-commerce");
		assertEquals("Assistente de E-commerce", novoPosto.getNomePosto());
	}
	
	@Test
	public void testGetESetCargo() {
		CargoModel cargo = new CargoModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setCargo(cargo);
		assertEquals(cargo, novoPosto.getCargo());
	}
	
	@Test
	public void testGetESetSetor() {
		SetorModel setor = new SetorModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setSetor(setor);
		assertEquals(setor, novoPosto.getSetor());
	}
	
	@Test
	public void testGetESetNivel() {
		NivelModel nivel = new NivelModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setNivel(nivel);
		assertEquals(nivel, novoPosto.getNivel());
	}
	
	@Test
	public void testGetESetSalario() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setSalario(15000.00);
		assertEquals(15000.00, novoPosto.getSalario(), 0.01);
	}
	
	@Test
	public void testToString() {
		PostoDeTrabalhoModel postoVazio = new PostoDeTrabalhoModel();
		postoVazio.setSalario(3000.00);
		System.out.println(postoVazio);
		assertEquals("PostoDeTrabalhoModel [idPosto=null, nomePosto=null, cargo=null, setor=null, "
				+ "nivel=null, salario=3000.0]", postoVazio.toString());
	}

	@After
	public void limparTabela() throws SQLException {
		postoDAO.deletarTodos("posto_de_trabalho");
	}
}
