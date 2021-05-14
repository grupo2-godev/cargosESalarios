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
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Desenvolvedor I", 213, 33, 2, 2500.00);
		Integer idPostoCadastrado = postoDAO.create(novoPosto);
		Object postoConsultado = ConnectionHibernate.getSession().get(PostoDeTrabalhoModel.class, idPostoCadastrado);
		assertEquals(idPostoCadastrado, ((PostoDeTrabalhoModel) postoConsultado).getIdPosto());
	}
	
	@Test
	public void testRetrieveSqlId() {
	
	}
		
	@Test
	public void testUpdateSql() {

	}
	
	@Test
	public void testRetrieveSqlNome() {
	
	}
	
	@Test
	public void testDeleteSql() {
	
	}
	
	@Test
	public void testGetAll() {
	
	}
	
	@After
	public void limparTabela() throws SQLException {
			
	}
}
