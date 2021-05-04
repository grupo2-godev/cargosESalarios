package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Classes de testes para o SetorDaoSql.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class SetorDaoSqlTest {
	
	String nomeSetor1 = "ERP I";
	Integer idPermissao1 = 3;
	SetorModel setor1 = new SetorModel(nomeSetor1, idPermissao1);
	String nomePosto2 = "Gestão de Pessoas";
	Integer idPermissao2 = 4;
	SetorModel setor2 = new SetorModel(nomePosto2, idPermissao2);
	SetorDaoSql setorSQL = new SetorDaoSql();
	ConnectionPostgres conexao = new ConnectionPostgres();
	
	@Test
	public void testCreateSql() throws SQLException {
		assertEquals(1, setorSQL.create(setor1));
	}
	
	@Test
	public void testRetrieveSqlId() {
		setorSQL.create(setor1);
		setorSQL.create(setor2);
		SetorModel setorRecuperado = new SetorModel();
		setorRecuperado = setorSQL.retrieve(1);
		assertEquals(nomeSetor1, setorRecuperado.getNomeSetor());
	}
	
	@Test
	public void testUpdateSql() {
		setorSQL.create(setor1);
		setorSQL.create(setor2);
		assertTrue(setorSQL.update(2, setor2));	
	}
	
	@Test
	public void testRetrieveSqlNome() {
		setorSQL.create(setor1);
		setorSQL.create(setor2);
		SetorModel setor = new SetorModel();
		setor = setorSQL.retrieve("Gestão de Pessoas");
		assertEquals(nomePosto2, setor.getNomeSetor());
	}
	
	@Test
	public void testDeleteSql() {
		setorSQL.create(setor1);
		setorSQL.create(setor2);
		assertTrue(setorSQL.delete(1));
	}
	
	@Test
	public void testGetAll() {
		setorSQL.create(setor1);
		setorSQL.create(setor2);
		ArrayList<SetorModel> listaSetores= new ArrayList<SetorModel>();
		listaSetores = setorSQL.getAll();
		assertFalse(listaSetores.isEmpty());
		assertEquals(2, listaSetores.size());
	}

	@After
	public void limparTabela() throws SQLException {
		setorSQL.limparTabela();
	}
}
