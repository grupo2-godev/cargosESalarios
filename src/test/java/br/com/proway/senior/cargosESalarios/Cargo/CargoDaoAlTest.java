package br.com.proway.senior.cargosESalarios.Cargo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.recursos.Dados;

public class CargoDaoAlTest {
	
//		for (Cargo cargop : Dados.getInstance().getListaCargos()) {
//			System.out.println(cargop.toString());
//		}

	@Test
	public void testCreateCargo() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		
		new CargoDaoAl().Create(cargo);

		assertEquals(1, (int) Dados.getInstance().getListaCargos().get(0).getIdCargo());
		assertNotEquals(2, (int) Dados.getInstance().getListaCargos().get(0).getIdCargo());
	}
	
	@Test
	public void testRetrieveCargo() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		
		new CargoDaoAl().Create(cargo);
		
		Cargo cargo2 = new Cargo(2, "Assistente", 5, "Lider", 666.40, LocalDateTime.now(), LocalDateTime.now(),
				"9563214-32", "85236", 55, "Superior Incompleto", "18 meses", "Redator", "media", 2, 2);
		
		new CargoDaoAl().Create(cargo2);
		
		Cargo cargoRetornado = new CargoDaoAl().Retrieve(1);
		
		assertEquals("Superior Completo", cargoRetornado.getGrauDeInstrucao());
		assertNotEquals("18 meses", cargoRetornado.getExperienciaMinima());
	}
	

//	@Test
//	void testRetrieveCargo(int id) {
//		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
//		CargoService cs = new CargoService();
//		
//		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
//		cs.cadastrarCargo(listaCargo, 2, "Tester");
//		cs.cadastrarCargo(listaCargo, 3, "Tester2");
//		cs.cadastrarCargo(listaCargo, 4, "Dev2");
//		cs.cadastrarCargo(listaCargo, 5, "Dev3");
//		
//		assertEquals(Dados.getInstance().getListaCargos().get(id));

}
