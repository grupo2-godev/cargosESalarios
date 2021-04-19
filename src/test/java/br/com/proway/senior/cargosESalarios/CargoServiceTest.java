package br.com.proway.senior.cargosESalarios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CargoTest {

	/**
	 * 
	 */
	@Test
	void testCadastrarCargoConstrutor() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1);
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

		assertTrue(cs.removerCargo(2, listaCargo));
	}

	@Test
	public void testAlterarCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		assertTrue(cs.alterarCargo(listaCargo, 1, "testDev"));
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
		// System.out.println(cs.visualizarTodosOsCargos(listaCargo));

		assertEquals(cs.visualizarTodosOsCargos(listaCargo), listaCargo.get(0).getNomeCargo().equals("Desenvolvedor"));
	}
}
