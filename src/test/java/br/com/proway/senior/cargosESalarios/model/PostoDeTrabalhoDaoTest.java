package br.com.proway.senior.cargosESalarios.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.antigos.Dados;
import br.com.proway.senior.cargosESalarios.antigos.PostoDeTrabalhoDaoAl;

/**
 * Classe de testes para PostoDeTrabalhoDao.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 *
 */
public class PostoDeTrabalhoDaoTest {
	
	Integer idPosto = 1;
	String nomePosto = "Desenvolvedor(a)";
	Integer idCargo = 3;
	Integer idSetor = 4;
	Integer idNivel = 1;
	Double salario = 1800.00;
	PostoDeTrabalhoDaoAl dao = new PostoDeTrabalhoDaoAl();
	
	@Before
	public void limparArray() {
		dao.limparArray();	
	}
	
	@Test
	public void testCreatePostoDeTrabalho() {
		dao.limparArray();
		PostoDeTrabalhoModel postoModel = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
		dao.create(postoModel);
		assertEquals(postoModel, dao.retrieve(0));
	}
	
	@Test
	public void testUpdatePosto() {
		PostoDeTrabalhoModel posto1 = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
		dao.create(posto1);
		PostoDeTrabalhoModel posto2 = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, 1900.00);
		dao.update(posto2);
		PostoDeTrabalhoModel postoRetornado = dao.retrieve(0);
		assertNotEquals(posto2, postoRetornado);
		assertEquals(posto1, postoRetornado);
	}
	
	@Test
	public void testDeletePosto() {
		dao.limparArray();
		int idPosto1 = 0;
		PostoDeTrabalhoModel posto1 = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
		
		int tamanhoInicial = Dados.getInstance().getListaPostos().size();
		
		dao.create(posto1);
		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaPostos().size());
		dao.delete(idPosto1);
		assertEquals(tamanhoInicial, Dados.getInstance().getListaPostos().size());
	}
	
	@Test
	public void testRetrieveIsNull() {
		int idPosto = 10;
		PostoDeTrabalhoModel posto = dao.retrieve(idPosto);
		assertNull(posto);
	}
	
	@Test
	public void testGetAll() {
		ArrayList<PostoDeTrabalhoModel> listGetAll = dao.getAll();
		ArrayList<PostoDeTrabalhoModel> listGetListaPostos = Dados.getInstance().getListaPostos();
		assertEquals(listGetAll, listGetListaPostos);
	}

}
