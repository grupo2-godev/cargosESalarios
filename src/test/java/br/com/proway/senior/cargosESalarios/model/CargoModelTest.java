package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

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

	@Test
	public void testDataCadastro() {
		CargoModel cargo = new CargoModel(id, nomeCargo);
		cargo.setDataCadastro(LocalDateTime.of(2020, 10, 5, 10, 5));
		
		assertEquals(LocalDateTime.of(2020, 10, 5, 10, 5), cargo.getDataCadastro());		
	}
	
	@Test
	public void testIdPermissao() {
		CargoModel cargo = new CargoModel(id, nomeCargo);
		cargo.setIdPermissao(10);
		
		assertEquals(10, (int)cargo.getIdPermissao());
	}
}
