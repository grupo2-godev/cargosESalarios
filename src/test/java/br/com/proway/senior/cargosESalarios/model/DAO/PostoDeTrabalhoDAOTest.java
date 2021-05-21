package br.com.proway.senior.cargosESalarios.model.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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
import br.com.proway.senior.cargosESalarios.model.DAO.CargoDAO;
import br.com.proway.senior.cargosESalarios.model.DAO.PostoDeTrabalhoDAO;
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
		new NivelController().deletarTodosNiveis();
		new SetorController().deletarTodosSetores();
		new CargoController().deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
		
		popularTabelas();
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
		limparTabelas();
		new NivelController().deletarTodosNiveis();
		new SetorController().deletarTodosSetores();
		new CargoController().deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
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
		idCargo = CargoDAO.getInstancia().criar(cargo);
		idNivel = new NivelController().cadastrarNivel("Junior");
		idSetor = new SetorController().cadastrarSetor("Financeiro", idCargo);
		int idSetor2 = new SetorController().cadastrarSetor("Recursos Humanos", idCargo);
		
		cargoRecuperado = CargoDAO.getInstancia().buscar(CargoModel.class, idCargo);
		setor = new SetorController().buscarSetorPorId(idSetor);
		setor2 = new SetorController().buscarSetorPorId(idSetor2);
		nivel = new NivelController().buscarNivel(idNivel);
		
	}
	
	@Before
	public void herewegoagain() throws Exception {
		limparTabelas();
		}
		
	
	@Test
	public void testInserirNovoPostoDeTrabalho() throws SQLException {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Gerente Gestão de Pessoas", cargo, setor, nivel, 
				salario);
		Integer idPostoCadastrado = postoDAO.criar(novoPosto);
		Object postoConsultado = ConexaoHibernate.getSessao().get(PostoDeTrabalhoModel.class, idPostoCadastrado);
		assertEquals(idPostoCadastrado, ((PostoDeTrabalhoModel) postoConsultado).getIdPosto());
	}

	@Test
	public void testBuscarPostoPorID() {
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
	public void testBuscarPostoPorNome() {
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
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("AnalistaFinanceiroo", cargo, setor, nivel, 2750.00);
		PostoDeTrabalhoModel postoAlterado = new PostoDeTrabalhoModel("Analista Financeiro", cargo, setor2, nivel, 
				2800.00);
		Integer idCriado = postoDAO.criar(novoPosto);
		postoDAO.atualizar(idCriado, postoAlterado);
		PostoDeTrabalhoModel atualizado = postoDAO.buscar(PostoDeTrabalhoModel.class, idCriado);
		assertEquals(novoPosto.getNomePosto(), atualizado.getNomePosto());
		assertEquals(novoPosto.getCargo().getIdCargo(), atualizado.getCargo().getIdCargo());
		assertEquals(novoPosto.getSetor().getId(), atualizado.getSetor().getId());
		assertEquals(novoPosto.getNivel().getId(), atualizado.getNivel().getId());
		assertEquals(novoPosto.getSalario(), atualizado.getSalario());
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

	@After
	public void limparTabela() throws SQLException {
		postoDAO.deletarTodos("posto_de_trabalho");
	}
}
