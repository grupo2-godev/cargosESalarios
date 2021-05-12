package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.antigos.Dados;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.DaoAl.CargoDaoAl;

/**
 * Classe de testes do CargoDaoAl.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grij�, Samuel Levi
 * @version Sprint3:
 *  - Implementa��o dos testes.
 */
public class CargoDaoAlTest {

	Integer gi = 0;
	Integer cbo2002 = 0;
	Integer cbo1994 = 0;
	Integer hm = 0;
	Dados db = Dados.getInstance();
	CargoDaoAl dao = new CargoDaoAl();

	
	@Before
	public void limparArray() {
		dao.limparArray();	
	}
	
	@Test
	public void testCreateAndRetrieveCargo() {
		dao.limparArray();	
		CargoModel cargo1 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		dao.create(cargo1);
		assertEquals(cargo1, dao.retrieve(0));
	}

	@Test
	public void testUpdateCargo() {
		CargoModel cargo1 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);

		new CargoDaoAl().create(cargo1);

		CargoModel cargo2 = new CargoModel("Analista", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);

		new CargoDaoAl().update(cargo2);

		CargoModel cargoRetornado = new CargoDaoAl().retrieve(0);

		assertNotEquals(cargo2, cargoRetornado);
		assertEquals(cargo1, cargoRetornado);
	}

	@Test
	public void testDeleteCargo() {
		int idCargo1 = 0;
		CargoModel cargo1 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		CargoDaoAl cargoDao = new CargoDaoAl();
		int tamanhoInicial = Dados.getInstance().getListaCargos().size();

		cargoDao.create(cargo1);
		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaCargos().size());
		cargoDao.delete(idCargo1);
		assertEquals(tamanhoInicial, Dados.getInstance().getListaCargos().size());
	}
	
	@Test
	public void testRetrieveIsNull() {
		int idCargo = 10;
		CargoDaoAl cargoDao = new CargoDaoAl();
		CargoModel cargo = cargoDao.retrieve(idCargo);
		assertNull(cargo);
	}
	
	@Test
	public void testGetAll() {
		CargoDaoAl cargoDao = new CargoDaoAl();
		ArrayList<CargoModel> listGetAll = cargoDao.getAll();
		ArrayList<CargoModel> listGetListaCargos = Dados.getInstance().getListaCargos();
		assertEquals(listGetAll, listGetListaCargos);
	}
	
}
