package br.com.proway.senior.cargosESalarios.Cargo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class CargoDaoAlTest {
	
	@Test
	public void testCreateAndRetrieveCargo() {
		int idCargo1 = 5;
		int idCargo2 = 6;
		Cargo cargo1 = new Cargo(idCargo1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		
		new CargoDaoAl().Create(cargo1);
		
		Cargo cargo2 = new Cargo(idCargo2, "Assistente", 5, "Lider", 666.40, LocalDateTime.now(), LocalDateTime.now(),
				"9563214-32", "85236", 55, "Superior Incompleto", "18 meses", "Redator", "media", 2, 2);
		
		new CargoDaoAl().Create(cargo2);
		
		Cargo cargoRetornado = new CargoDaoAl().Retrieve(idCargo1);
		assertEquals(cargo1, cargoRetornado);
		//assertNotEquals(cargo2, cargoRetornado);
	}
	@Test
	public void testUpdateCargo() {
		Cargo cargo1 = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		
		new CargoDaoAl().Create(cargo1);
		
		Cargo cargo2 = new Cargo(1, "Assistente", 5, "Lider", 666.40, LocalDateTime.now(), LocalDateTime.now(),
				"9563214-32", "85236", 55, "Superior Incompleto", "18 meses", "Redator", "media", 2, 2);
		
		new CargoDaoAl().Update(cargo2);
		
		Cargo cargoRetornado = new CargoDaoAl().Retrieve(1);
			
		assertEquals(cargo2, cargoRetornado);
		assertNotEquals(cargo1, cargoRetornado);
		assertSame(cargo2, cargoRetornado);
	}
		@Test
	public void testDeleteCargo2() {
		int idCargo1 = 0;
		Cargo cargo1 = new Cargo(idCargo1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		CargoDaoAl cargoDao = new CargoDaoAl();
		int tamanhoInicial = cargoDao.getAll().size();
		
		cargoDao.Create(cargo1);
		assertEquals(tamanhoInicial + 1,cargoDao.getAll().size());
		cargoDao.Delete(idCargo1);
		assertEquals(tamanhoInicial,cargoDao.getAll().size());
	}
}
