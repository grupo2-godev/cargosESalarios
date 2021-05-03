package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostoDeTrabalhoDaoSqlTest {

	String nomePosto = "Desenvolvedor(a)";
	Integer idCargo = 3;
	Integer idSetor = 4;
	Integer idNivel = 1;
	Double salario = 1800.00;
	PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
	PostoDeTrabalhoDaoSql postoSql = new PostoDeTrabalhoDaoSql();
	
	@Test
	public void testCreateSql() {
		postoSql.create(posto);
	}

}
