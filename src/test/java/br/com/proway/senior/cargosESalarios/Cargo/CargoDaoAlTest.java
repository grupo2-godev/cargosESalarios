package br.com.proway.senior.cargosESalarios.Cargo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.recursos.Dados;

/**
 * Classe de testes do CargoDaoAl.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi
 * @version Sprint3:
 *  - Implementação dos testes.
 */
public class CargoDaoAlTest {

	@Test
	public void testCreateAndRetrieveCargo() {
		int idCargo1 = 5;
		int idCargo2 = 6;
		Cargo cargo1 = new Cargo(idCargo1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);

		new CargoDaoAl().create(cargo1);

		Cargo cargo2 = new Cargo(idCargo2, "Assistente", 5, "Lider", 666.40, LocalDateTime.now(), LocalDateTime.now(),
				"9563214-32", "85236", 55, "Superior Incompleto", "18 meses", "Redator", "media", 2, 2);

		new CargoDaoAl().create(cargo2);

		Cargo cargoRetornado = new CargoDaoAl().retrieve(idCargo1);
		assertEquals(cargo1, cargoRetornado);
	}

	@Test
	public void testUpdateCargo() {
		int idCargo = 1;
		Cargo cargo1 = new Cargo(idCargo, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);

		new CargoDaoAl().create(cargo1);

		Cargo cargo2 = new Cargo(idCargo, "Assistente", 5, "Lider", 666.40, LocalDateTime.now(), LocalDateTime.now(),
				"9563214-32", "85236", 55, "Superior Incompleto", "18 meses", "Redator", "media", 2, 2);

		new CargoDaoAl().update(cargo2);

		Cargo cargoRetornado = new CargoDaoAl().retrieve(idCargo);

		assertEquals(cargo2, cargoRetornado);
		assertNotEquals(cargo1, cargoRetornado);
		assertSame(cargo2, cargoRetornado);
	}

	@Test
	public void testDeleteCargo() {
		int idCargo1 = 0;
		Cargo cargo1 = new Cargo(idCargo1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
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
		Cargo cargo = cargoDao.retrieve(idCargo);
		assertNull(cargo);
	}
	
	@Test
	public void testGetAll() {
		CargoDaoAl cargoDao = new CargoDaoAl();
		ArrayList<Cargo> listGetAll = cargoDao.getAll();
		ArrayList<Cargo> listGetListaCargos = Dados.getInstance().getListaCargos();
		assertEquals(listGetAll, listGetListaCargos);
	}
	
}
