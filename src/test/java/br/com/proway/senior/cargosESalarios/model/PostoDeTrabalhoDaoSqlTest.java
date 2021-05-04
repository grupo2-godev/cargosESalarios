package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Classes de testes para o PostoDeTrabalhoDaoSql.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class PostoDeTrabalhoDaoSqlTest {

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
	PostoDeTrabalhoDaoSql postoSql = new PostoDeTrabalhoDaoSql();
	ConnectionPostgres conexao = new ConnectionPostgres();
	
	
	@Test
	public void testCreateSql() throws SQLException {
		assertEquals(1, postoSql.create(posto));
	}
	
	@Test
	public void testRetrieveSqlId() {
		postoSql.create(posto);
		postoSql.create(posto2);
		PostoDeTrabalhoModel postoRecuperado = new PostoDeTrabalhoModel();
		postoRecuperado = postoSql.retrieve(2);
		assertEquals(nomePosto2, postoRecuperado.getNomePosto());
	}
		
	@Test
	public void testUpdateSql() {
		postoSql.create(posto);
		postoSql.create(posto2);
		assertTrue(postoSql.update(2, posto2));	
	}
	
	@Test
	public void testRetrieveSqlNome() {
		postoSql.create(posto);
		postoSql.create(posto2);
		PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel();
		posto = postoSql.retrieve("Scrum Master");
		assertEquals(idSetor2, posto.getIdSetor());
	}
	
	@Test
	public void testDeleteSql() {
		postoSql.create(posto);
		postoSql.create(posto2);
		assertTrue(postoSql.delete(1));
	}
	
	@Test
	public void testGetAll() {
		postoSql.create(posto);
		postoSql.create(posto2);
		ArrayList<PostoDeTrabalhoModel> listaPostos = new ArrayList<PostoDeTrabalhoModel>();
		listaPostos = postoSql.getAll();
		assertFalse(listaPostos.isEmpty());
		assertEquals(2, listaPostos.size());
	}
	
	@After
	public void limparTabela() throws SQLException {
			postoSql.limparTabela();
	}
}
