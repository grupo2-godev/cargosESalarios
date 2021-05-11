package br.com.proway.senior.cargosESalarios.antigos;
/**
 *  REFATORAR, ESSA VERSAO UTILIZAVA ARRAY LISTS
 */
package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.Cbo1994DaoAl;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;

/**
 * Classe de teste da classe Cbo1994Controller
 * 
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 * @author Samuel Levi <i>samuel.levi@senior.com.br</i>
 * @author Lorran <i>lorran.santos@senior.com.br</i>
 *
 */

public class Cbo1994ControllerTest {

	@Test
	public void testCadastrarCbo1994() {
		Cbo1994Controller cb = new Cbo1994Controller();
		Cbo1994DaoAl dao = new Cbo1994DaoAl();
		Cbo1994Model cbo = new Cbo1994Model(0, "cbo0", 12.0, 10.2);
		cb.cadastrarCbo1994(0, "cbo0", 10.5, 2.0);
		dao.create(cbo);

		// Asserts de cadastro equals, same e notNull
		assertEquals(dao.retrieve(0).getDescricao(), cbo.getDescricao());
		assertNotNull(dao.create(cbo));
		assertSame(dao.retrieve(0).getDescricao(), cbo.getDescricao());
		dao.limparArray();
	}

	@Test
	public void testDeletarCbo1994() {
		Cbo1994DaoAl dao = new Cbo1994DaoAl();
		Cbo1994Controller cb = new Cbo1994Controller();
		cb.cadastrarCbo1994(0, "cbo", 10.5, 2.0);
		assertTrue(cb.deletarCbo1994(0));
		dao.limparArray();
	}

	@Test
	public void testBuscarCboNome() {
		Cbo1994Model cbo = new Cbo1994Model(0, "cbo1", 12.0, 10.2);
		Cbo1994DaoAl dao = new Cbo1994DaoAl();
		dao.create(cbo);
		Cbo1994Controller cb = new Cbo1994Controller();
		cb.cadastrarCbo1994(0, "cbo1", 12.0, 10.2);

		assertEquals(cbo.getPercentualInsalubridade(), cb.buscarCboNome("cbo1").getPercentualInsalubridade());
		dao.limparArray();
	}

	@Test
	public void buscarCboIdTest() {
		Cbo1994Model cbo = new Cbo1994Model(0, "cbo2", 12.0, 10.2);
		Cbo1994DaoAl dao = new Cbo1994DaoAl();
		dao.create(cbo);
		Cbo1994Controller cb = new Cbo1994Controller();
		cb.cadastrarCbo1994(0, "cbo2", 12.0, 10.2);

		assertEquals(cbo.getPercentualInsalubridade(), cb.buscarCboId(0).getPercentualInsalubridade());

		dao.limparArray();
	}

	@Test
	public void testbuscarTodosCbos() {
		Cbo1994Model cbo = new Cbo1994Model(0, "cbo3", 12.0, 10.2);
		Cbo1994DaoAl dao = new Cbo1994DaoAl();
		Cbo1994Controller cb = new Cbo1994Controller();
		dao.create(cbo);
		Cbo1994Model cbo2 = new Cbo1994Model(0, "cbo4", 12.0, 10.2);
		Cbo1994DaoAl dao2 = new Cbo1994DaoAl();
		dao2.create(cbo2);

		assertEquals(2, cb.buscarTodosCbos().size());
		dao.limparArray();
	}

	@Test
	public void atualizarCbo1994Test() {
		Cbo1994Controller cb = new Cbo1994Controller();
		Cbo1994DaoAl dao = new Cbo1994DaoAl();
		Cbo1994Model cbo = new Cbo1994Model(0, "cbo5", 12.0, 10.2);
		cb.cadastrarCbo1994(0, "cbo", 10.5, 2.0);
		dao.create(cbo);

		assertEquals("cbo", dao.retrieve(0).getDescricao());

		cb.atualizarCbo1994(0, "cbo1", 12.0, 10.0);

		assertNotEquals("cbo", cbo.getDescricao());

		dao.limparArray();
	}
}
