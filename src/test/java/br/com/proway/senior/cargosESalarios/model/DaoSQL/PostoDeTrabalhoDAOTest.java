package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.controller.NivelController;
import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

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
	
	static PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstance(ConexaoHibernate.getSessao());
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nomePosto = "Desenvolvedor(a)";
		
		salario = 1800.00;
		
		limparTabelas();
		new NivelController().deletarTodosNiveis();
		new SetorController().deletarTodosSetores();
		CargoDAO.getInstance(ConexaoHibernate.getSessao()).deleteAll();
		
		popularTabelas();
	}
	
	public static void limparTabelas() throws SQLException {
		postoDAO.deleteAll(); 
		
	}
	
	/**
	 * Devemos popular as tabelas que sao chaves estrangeiras da tabela PostoDeTrabalho.
	 * Essa funcao gera (apenas uma vez) as entradas que vao ser utilizadas em todos os testes.
	 * 
	 * @throws Exception
	 */
	public static void popularTabelas() throws Exception{
		//TODO: Utilizar o novo CargoController ao inves do DAO.
		
		cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), 123456, 12345,
				20, 1, "12", "Administrar Equipes", true, 1);
		idCargo = CargoDAO.getInstance(ConexaoHibernate.getSessao()).create(cargo);
		idNivel = new NivelController().cadastrarNivel("Junior");
		idSetor = new SetorController().cadastrarSetor("Financeiro", idCargo);
		int idSetor2 = new SetorController().cadastrarSetor("Recursos Humanos", idCargo);
		
		cargoRecuperado = CargoDAO.getInstance(ConexaoHibernate.getSessao()).retrieve(idCargo);
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
		Integer idPostoCadastrado = postoDAO.create(novoPosto);
		Object postoConsultado = ConexaoHibernate.getSessao().get(PostoDeTrabalhoModel.class, idPostoCadastrado);
		assertEquals(idPostoCadastrado, ((PostoDeTrabalhoModel) postoConsultado).getIdPosto());
	}

	@Test
	public void testBuscarPostoPorID() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Desenvolvedor ERP", cargo, setor, nivel, 2900.00);
		Integer idPostoCadastrado = postoDAO.create(novoPosto);
		PostoDeTrabalhoModel postoConsultado = postoDAO.retrieve(idPostoCadastrado);
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
		postoDAO.create(novoPosto);
		ArrayList<PostoDeTrabalhoModel> listaRetornada = postoDAO.retrieveByName("Analist");
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
		Integer idCriado = postoDAO.create(novoPosto);
		postoDAO.update(idCriado, postoAlterado);
		PostoDeTrabalhoModel atualizado = postoDAO.retrieve(idCriado);
		assertEquals(novoPosto.getNomePosto(), atualizado.getNomePosto());
		assertEquals(novoPosto.getCargo().getIdCargo(), atualizado.getCargo().getIdCargo());
		assertEquals(novoPosto.getSetor().getId(), atualizado.getSetor().getId());
		assertEquals(novoPosto.getNivel().getId(), atualizado.getNivel().getId());
		assertEquals(novoPosto.getSalario(), atualizado.getSalario());
	}

	@Test
	public void testDeletarPostoDeTrabalho() {
		int size = postoDAO.getAll().size();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Gerente de Marketing Marcas", cargo, setor, nivel, 
				9000.0);
		int idCriada = postoDAO.create(novoPosto);
		postoDAO.delete(idCriada);
		assertEquals(size, postoDAO.getAll().size());
	}

	@Test
	public void testBuscarTodosOsPostosDeTrabalho() {
		PostoDeTrabalhoModel novoPosto1 = new PostoDeTrabalhoModel("Coordenador de Suporte", cargo, setor, nivel, 
				6000.0);
		PostoDeTrabalhoModel novoPosto2 = new PostoDeTrabalhoModel("Coordenador de Atendimento", cargo, setor, nivel, 
				6500.0);
		postoDAO.create(novoPosto1);
		postoDAO.create(novoPosto2);
		assertFalse(postoDAO.getAll().isEmpty());
	}

	@Test
	public void testDeletarTodosOsPostosDeTrabalho() {
		PostoDeTrabalhoModel novoPosto1 = new PostoDeTrabalhoModel("Técnico(a) Segurança do Trabalho", cargo, setor, 
				nivel, 6000.0);
		postoDAO.create(novoPosto1);
		postoDAO.deleteAll();
		assertTrue(postoDAO.getAll().isEmpty());
	}

	@After
	public void limparTabela() throws SQLException {
		postoDAO.deleteAll();
	}
}
