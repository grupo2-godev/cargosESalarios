package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;

/**
 * Classes de testes para o SetorDAO.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorDAOTest {

	SetorDAO setorDAO = SetorDAO.getInstance(ConnectionHibernate.getSession());

	@Test
	public void testIserirSetor() throws SQLException {
		SetorModel novoSetor = new SetorModel("Financeiro", 15);
		Integer idSetorCadastrado = setorDAO.create(novoSetor);
		Object setorConsultado = ConnectionHibernate.getSession().get(SetorModel.class, idSetorCadastrado);
		assertEquals(idSetorCadastrado, ((SetorModel) setorConsultado).getId());
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

//	@After
//	public void limparTabela() throws SQLException {
//		
//	}
}
