package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.PostoDeTrabalhoDAO;

/**
 * Classes de testes para o PostoDeTrabalhoDAO.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> 
 */

public class PostoDeTrabalhoDAOTest {
	
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstance(ConnectionHibernate.getSession());

	String nomePosto = "Desenvolvedor(a)";
	Integer idCargo = 3;
	Integer idSetor = 4;
	Integer idNivel = 1;
	Double salario = 1800.00;
	PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
	String nomePosto2 = "Scrum Master";
	Integer idCargo2 = 6;
	Integer idSetor2 = 3;
	Integer idNivel2 = 4;
	Double salario2 = 3000.00;
	PostoDeTrabalhoModel posto2 = new PostoDeTrabalhoModel(nomePosto2, idCargo2, idSetor2, idNivel2, salario2);
	
	
	@Test
	public void testInserirNovoPostoDeTrabalho() throws SQLException {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Desenvolvedor HCM", 213, 33, 2, 2500.00);
		Integer idPostoCadastrado = postoDAO.create(novoPosto);
		Object postoConsultado = ConnectionHibernate.getSession().get(PostoDeTrabalhoModel.class, idPostoCadastrado);
		assertEquals(idPostoCadastrado, ((PostoDeTrabalhoModel) postoConsultado).getIdPosto());
	}
	
	@Test
	public void testBuscarPostoPorID() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Desenvolvedor ERP", 23, 5, 1, 2900.00);
		Integer idPostoCadastrado = postoDAO.create(novoPosto);
		PostoDeTrabalhoModel postoConsultado = postoDAO.retrieve(idPostoCadastrado);
		assertEquals(novoPosto.getNomePosto(), postoConsultado.getNomePosto());
		assertEquals(novoPosto.getIdCargo(), postoConsultado.getIdCargo());
		assertEquals(novoPosto.getIdSetor(), postoConsultado.getIdSetor());
		assertEquals(novoPosto.getIdNivel(), postoConsultado.getIdNivel());
		assertEquals(novoPosto.getSalario(), postoConsultado.getSalario());
	}
		
	@Test
	public void testBuscarPostoPorNome() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Analista Gestão de Pessoas", 15, 10, 2, 2700.00);
		postoDAO.create(novoPosto);
		ArrayList<PostoDeTrabalhoModel> listaRetornada = postoDAO.retrieveByName("Analist");
		assertEquals(novoPosto.getNomePosto(), listaRetornada.get(0).getNomePosto());		
		assertEquals(novoPosto.getIdCargo(), listaRetornada.get(0).getIdCargo());		
		assertEquals(novoPosto.getIdSetor(), listaRetornada.get(0).getIdSetor());		
		assertEquals(novoPosto.getIdNivel(), listaRetornada.get(0).getIdNivel());		
		assertEquals(novoPosto.getSalario(), listaRetornada.get(0).getSalario());		
	}
	
	@Test
	public void testAtualizarPostoDeTrabalho() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("AnalistaFinanceiroo", 3, 2, 2, 2750.00);
		PostoDeTrabalhoModel postoAlterado = new PostoDeTrabalhoModel("Analista Financeiro", 3, 2, 2, 2800.00);
		Integer idCriado = postoDAO.create(novoPosto);
		postoDAO.update(idCriado, postoAlterado);
		PostoDeTrabalhoModel atualizado = postoDAO.retrieve(idCriado);
		assertEquals(novoPosto.getNomePosto(), atualizado.getNomePosto());		
		assertEquals(novoPosto.getIdCargo(), atualizado.getIdCargo());		
		assertEquals(novoPosto.getIdSetor(), atualizado.getIdSetor());		
		assertEquals(novoPosto.getIdNivel(), atualizado.getIdNivel());		
		assertEquals(novoPosto.getSalario(), atualizado.getSalario());	
	}
	
	@Test
	public void testDeletarPostoDeTrabalho() {
		int size = postoDAO.getAll().size();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Gerente de Marketing Marcas", 3, 5, 3, 9000.0);
		int idCriada = postoDAO.create(novoPosto);
		postoDAO.delete(idCriada);
		assertEquals(size, postoDAO.getAll().size());
	}
	
	@Test
	public void testGetAll() {
	
	}
	
	@After
	public void limparTabela() throws SQLException {
			
	}
}
