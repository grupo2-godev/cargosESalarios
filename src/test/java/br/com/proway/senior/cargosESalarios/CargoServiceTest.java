package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

public class CargoServiceTest {

	/**
	 * 
	 */
	@Test
	public void testCadastrarCargoConstrutor() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		assertEquals(1, cargo.getIdCargo());
	}

	@Test
	public void testCadastrarCargoRetornoNaoVazio() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		
		cs.cadastrarCargo(listaCargo, 1, "Dev");
		assertTrue(!listaCargo.isEmpty());
	}

	@Test
	public void testCadastrarCargoCom5ParametrosVerificaSeObjetoExiste() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		ArrayList<Setor> listaDeSetores = new ArrayList<Setor>();
		CargoService cs = new CargoService();
		SetorServico sv = new SetorServico();
		
		sv.cadastrarSetor(listaDeSetores, "Recursos Humanos", 2654, 30, 352);
		sv.cadastrarSetor(listaDeSetores, "Comercial", 2758, 30, 657);
		sv.cadastrarSetor(listaDeSetores, "Financeiro", 2123, 30, 984);
		sv.cadastrarSetor(listaDeSetores, "Contabilidade", 2841, 30, 612);

		cs.cadastrarCargo(listaCargo, 1, "Dev 1", listaDeSetores, 2123);
		cs.cadastrarCargo(listaCargo, 2, "Dev 2", listaDeSetores, 2841);
		cs.cadastrarCargo(listaCargo, 3, "Dev 3", listaDeSetores, 2758);
				
		assertNotNull(listaCargo);
	}

	@Test
	public void testRemoverCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		cs.removerCargo(1, listaCargo);
		
		assertTrue(listaCargo.isEmpty());
	}

	@Test
	public void testAlterarCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
				
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		cs.alterarCargo(listaCargo, 1, "Tester");
		
		assertEquals("Tester", listaCargo.get(0).getNomeCargo());
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
	
		assertEquals(cs.visualizarTodosOsCargos(listaCargo), listaCargo.toString());
	}
	
	@Test
	public void testVisualizarCargo() {
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		CargoService cs = new CargoService();
		cs.cadastrarCargo(listaCargo, 1, "Desenvolvedor");
		cs.cadastrarCargo(listaCargo, 2, "Tester");
		cs.cadastrarCargo(listaCargo, 3, "Tester2");
		cs.cadastrarCargo(listaCargo, 4, "Dev2");
		cs.cadastrarCargo(listaCargo, 5, "Dev3");
		
		assertEquals("Tester", cs.visualizarCargo(listaCargo, 2));
	}

}
