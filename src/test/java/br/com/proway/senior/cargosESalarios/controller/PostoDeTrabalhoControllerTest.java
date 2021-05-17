package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.After;

/**
 * Classes de testes para o PostoDeTrabalhoController.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;

public class PostoDeTrabalhoControllerTest {
	
	//static Integer idPosto = 1;
	static String nomePosto = "Desenvolvedor(a)";
	
	static Double salario = 1800.00;
	
	
	
	@Test
	public void cadastrarPostoDeTrabalhoTest() throws Exception {

		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), 123456, 12345,
				20, 1, "12", "HACKER DE HIBERNATE", true, 1);
		int idCargo = CargoDAO.getInstance(ConnectionHibernate.getSession()).create(cargo);
		int idNivel = new NivelController().cadastrarNivel("supremo");
		int idSetor = new SetorController().cadastrarSetor("Setor bom", idCargo);
		
		CargoModel Cargo = CargoDAO.getInstance(ConnectionHibernate.getSession()).retrieve(idCargo);
		SetorModel Setor = new SetorController().buscarSetorPorId(idSetor);
		NivelModel Nivel = new NivelController().buscarNivel(idNivel);
		
		/// Teste de fato
		PostoDeTrabalhoModel postoModel = new PostoDeTrabalhoModel(nomePosto, Cargo, Setor, Nivel, salario);
		
		PostoDeTrabalhoController controller = new PostoDeTrabalhoController();
		
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, Cargo, Setor, Nivel, salario);
		PostoDeTrabalhoModel postoRecuperado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a)", postoRecuperado.getNomePosto());
		assertEquals((Integer) idCargo, postoRecuperado.getIdCargo().getIdCargo());
		assertEquals((Integer) idSetor, postoRecuperado.getIdSetor().getId());
		assertEquals((Integer) idNivel, postoRecuperado.getIdNivel().getId());
		assertEquals((Double) salario, postoRecuperado.getSalario());
	}
	
	@Test(expected = Exception.class)
	public void cadastrarPostoDeTrabalhoTestNomeInvalido() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho("Inval1d0!", idCargo, idSetor, idNivel, salario);
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(id));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.atualizarPostoDeTrabalho(id, "Desenvolvedor(a) Junior", idCargo, 7, idNivel, salario);
		PostoDeTrabalhoModel postoAtualizado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals((Integer) 7, postoAtualizado.getIdSetor());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals((Object)id, postoProcurado.getIdPosto());
		assertEquals(nomePosto, postoProcurado.getNomePosto());
		assertEquals(idCargo, postoProcurado.getIdCargo());
		assertEquals(idSetor, postoProcurado.getIdSetor());
		assertEquals(idNivel, postoProcurado.getIdNivel());
		assertEquals(salario, postoProcurado.getSalario());
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals(postoProcurado.getNomePosto(),
				controller.buscarPostoDeTrabalhoNome(nomePosto).get(0).getNomePosto());
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() throws Exception {
		int before = controller.buscarTodosPostosDeTrabalho().size();
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", 8, 2, 2, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", 7, 3, 3, 7000.00);
		assertEquals(before+3, controller.buscarTodosPostosDeTrabalho().size());
	}
	
//	@After
//	public void limparTabela() throws SQLException {
//		controller.postoDAO.deleteAll();
//		//assertEquals(0, controller.buscarTodosPostosDeTrabalho().size());
//	}
	
}
