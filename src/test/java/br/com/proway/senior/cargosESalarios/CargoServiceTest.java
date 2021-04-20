package br.com.proway.senior.cargosESalarios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CargoServiceTest {

	/**
	 * 
	 */
	@Test
	void testCadastrarCargoConstrutor() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		cargo.setCbo94("1651515");
		assertEquals(1, cargo.getIdCargo());

	}

	@Test
	public void testCadastrarCargoRetornoNaoVazio() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		assertTrue(!cs.cadastrarCargo(listaCargo, 2, "Desenvolvedor").isEmpty());

	}

	@Test
	public void testCadastrarCargoVerificaSeObjetoExiste() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		ArrayList<Cargo> recebeTodaAListaDeCargos = cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		assertEquals(recebeTodaAListaDeCargos.get(0).getIdCargo() == 1,
				recebeTodaAListaDeCargos.get(0).getNomeCargo() == "Desenvolvedor");

	}

	@Test
	public void testRemoverCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		cs.cadastrarCargo(listaCargo, 2, "Tester");
		assertNotNull(cs.removerCargo(2, listaCargo));
	}

	@Test
	public void testAlterarCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		assertNotNull(cs.alterarCargo(listaCargo, 1, "Tester"));
	}

	@Test
	public void testVisualizarTodosOsCargos() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		cs.cadastrarCargo(listaCargo, 2, "Tester");
		cs.cadastrarCargo(listaCargo, 3, "Tester2");
		cs.cadastrarCargo(listaCargo, 4, "Dev2");
		cs.cadastrarCargo(listaCargo, 5, "Dev3");
		assertTrue(cs.visualizarTodosOsCargos(listaCargo).contains("Desenvolvedor"));
	}
	
	@Test
	public void testVisualizarCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		cs.cadastrarCargo(listaCargo, 0, "Desenvolvedor");
		cs.cadastrarCargo(listaCargo, 1, "Tester");
		System.out.println(cs.visualizarCargo(listaCargo, 0));
		assertNotNull(cs.visualizarCargo(listaCargo, 0));
	}
}
