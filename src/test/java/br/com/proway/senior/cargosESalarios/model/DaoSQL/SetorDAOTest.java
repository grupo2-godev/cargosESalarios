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
	public void testBuscarSetorPorID() {
		SetorModel novoSetor = new SetorModel("Gestão de Pessoas", 3);
		SetorModel setorRetornado = setorDAO.retrieve(setorDAO.create(novoSetor));
		assertEquals(novoSetor.getNomeSetor(), setorRetornado.getNomeSetor());
		assertEquals(novoSetor.getIdPermissao(), setorRetornado.getIdPermissao());
	}
	
	@Test
	public void testBuscarSetorPorNome() {
		SetorModel novoSetor = new SetorModel("Gestão de Pessoas", 3);
		setorDAO.create(novoSetor);
		ArrayList<SetorModel> setorRetornado = setorDAO.retrieveByName("tão");
		assertEquals(novoSetor.getNomeSetor(), setorRetornado.get(1).getNomeSetor());
		assertEquals(novoSetor.getIdPermissao(), setorRetornado.get(1).getIdPermissao());
	}

	@Test
	public void testAlterarSetor() {
		SetorModel novoSetor = new SetorModel("Desenvolvimento I", 3);
		SetorModel setorAlterado = new SetorModel("Desenvolvimento II", 3);
		Integer idcriado = setorDAO.create(novoSetor);
		setorDAO.update(idcriado, setorAlterado);
		SetorModel atualizado = setorDAO.retrieve(idcriado);
		assertEquals(setorAlterado.getNomeSetor(), atualizado.getNomeSetor());
		assertEquals(setorAlterado.getIdPermissao(), atualizado.getIdPermissao());
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
