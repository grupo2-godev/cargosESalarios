package br.com.proway.senior.cargosESalarios.model;


import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.antigos.Dados;
import br.com.proway.senior.cargosESalarios.model.DaoAl.Cbo2002DaoAl;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Classe de testes para CBO2002DAO.
 * 
 * @author Samuel Alves, <samuel.levi@senior.com.br>
 * @version Sprint 4
 *
 */
public class Cbo2002DAOTest {
	Integer codigoId = 1;
	String descricao = "SeniorX";
	Double percInsalubridade = 0.10;
	Double percPericulosidade = 0.4;
	Cbo2002DaoAl dao = new Cbo2002DaoAl();

	@Before
	public void limparArray() {
		dao.limparArray();	
	}
	
	@Test
	public void testCreateCbo2002() {
		dao.limparArray();
		Cbo2002Model cbo2002Model = new Cbo2002Model(codigoId, descricao, percInsalubridade, percPericulosidade);
		dao.create(cbo2002Model);
		assertEquals(cbo2002Model, dao.retrieve(0));
	}
	
	@Test
	public void testUpdatePosto() {
		Cbo2002Model cbo2002T01 = new Cbo2002Model(codigoId, descricao, percInsalubridade, percPericulosidade);
		dao.create(cbo2002T01);
		Cbo2002Model cbo2002T02 = new Cbo2002Model(10, "Scrum Master", percInsalubridade, percPericulosidade);
		dao.create(cbo2002T02);
		Cbo2002Model cbo2002Retornado = dao.retrieve(0);
		assertEquals(cbo2002T01, cbo2002Retornado);
		assertNotEquals(cbo2002T02, cbo2002Retornado);
	}

	@Test
	public void deleteCbo2002(){
		dao.limparArray();
		int codigoId1 = 0;
		Cbo2002Model cbo2002T01 = new Cbo2002Model(codigoId, descricao, percInsalubridade, percPericulosidade);
		
		int tamanhoInicial = Dados.getInstance().getListaCbo2002().size();
		
		dao.create(cbo2002T01);
		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaCbo2002().size());
		dao.delete(codigoId1);
		assertEquals(tamanhoInicial, Dados.getInstance().getListaCbo2002().size());
	}

	@Test
	public void testRetrieveIsNull(){
		int codigoId1 = 10;
		Cbo2002Model cbo2002 = dao.retrieve(codigoId1);
		assertNull(cbo2002);
	}

	@Test
	public void testGetAll(){
		ArrayList<Cbo2002Model> listGetAll = dao.getAll();
		ArrayList<Cbo2002Model> listGetListaCbo = Dados.getInstance().getListaCbo2002();
		assertEquals(listGetAll, listGetListaCbo);
	}

}
