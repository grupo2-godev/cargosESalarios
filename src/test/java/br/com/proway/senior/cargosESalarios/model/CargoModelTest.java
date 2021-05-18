package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CargoModelTest {

	Integer id = 2;
	String nomeCargo = "Desenvolvedor Junior";
	
	@Test
	public void testSetId() {
		CargoModel cargo = new CargoModel();
		cargo.setIdCargo(id);
		assertEquals(id, cargo.getIdCargo());
	}
	
	@Test
	public void testConstrutor() {
		CargoModel cargo = new CargoModel(id, nomeCargo);
		assertEquals(nomeCargo, cargo.getNomeCargo());
	}

}
