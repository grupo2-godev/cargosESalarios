package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Testes da Classe PostoDeTrabalhoModel {@link PostoDeTrabalhoModel}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public class PostoDeTrabalhoModelTest {


	@Test
	public void testConstrutorVazio() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setNomePosto("Vendedor de Loja");
		novoPosto.setSalario(1700.00);
		assertEquals("Vendedor de Loja", novoPosto.getNomePosto());
		assertEquals(1700.00, novoPosto.getSalario(), 0.01);
	}

	@Test
	public void testConstrutorComID() {
		CargoModel cargo = new CargoModel();
		SetorModel setor = new SetorModel();
		NivelModel nivel = new NivelModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel(1, "Coordenador de Suporte", cargo, setor, nivel, 
				7000.00);
		assertEquals((Integer) 1, novoPosto.getIdPosto());
		assertEquals("Coordenador de Suporte", novoPosto.getNomePosto());
		assertEquals(7000.00, novoPosto.getSalario(), 0.01);	
	}
	
	@Test
	public void testConstrutorSemID() {
		CargoModel cargo = new CargoModel();
		SetorModel setor = new SetorModel();
		NivelModel nivel = new NivelModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel("Coordenador de Suporte", cargo, setor, nivel, 
				7000.00);
		assertEquals("Coordenador de Suporte", novoPosto.getNomePosto());
		assertEquals(7000.00, novoPosto.getSalario(), 0.01);	
	}
	
	@Test
	public void testGetESetIdPosto() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setIdPosto(3);
		assertEquals((Integer) 3, novoPosto.getIdPosto());
	}
	
	@Test
	public void testGetESetNomePosto() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setNomePosto("Assistente de E-commerce");
		assertEquals("Assistente de E-commerce", novoPosto.getNomePosto());
	}
	
	@Test
	public void testGetESetCargo() {
		CargoModel cargo = new CargoModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setCargo(cargo);
		assertEquals(cargo, novoPosto.getCargo());
	}
	
	@Test
	public void testGetESetSetor() {
		SetorModel setor = new SetorModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setSetor(setor);
		assertEquals(setor, novoPosto.getSetor());
	}
	
	@Test
	public void testGetESetNivel() {
		NivelModel nivel = new NivelModel();
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setNivel(nivel);
		assertEquals(nivel, novoPosto.getNivel());
	}
	
	@Test
	public void testGetESetSalario() {
		PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel();
		novoPosto.setSalario(15000.00);
		assertEquals(15000.00, novoPosto.getSalario(), 0.01);
	}
	
	@Test
	public void testToString() {
		PostoDeTrabalhoModel postoVazio = new PostoDeTrabalhoModel();
		postoVazio.setSalario(3000.00);
		System.out.println(postoVazio);
		assertEquals("PostoDeTrabalhoModel [idPosto=null, nomePosto=null, cargo=null, setor=null, "
				+ "nivel=null, salario=3000.0]", postoVazio.toString());
	}
	
}