package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

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

public class PostoDeTrabalhoControllerTest{
	
	static String nomePosto = "Desenvolvedor(a)";
	
	static Double salario = 1800.00;
	
	static PostoDeTrabalhoController controller = new PostoDeTrabalhoController();
	
	static CargoModel cargo;
	static int idCargo ;
	static int idNivel ;
	static int idSetor ;
	static CargoModel Cargo ;
	static SetorModel Setor;
	static SetorModel Setor2;
	static NivelModel Nivel;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nomePosto = "Desenvolvedor(a)";
		
		salario = 1800.00;
		
		controller = new PostoDeTrabalhoController();
	}
	
	public static void limparTabelas() throws SQLException {
		controller.postoDAO.deleteAll(); //Cascade!!!!!
		new NivelController().deletarTodosNiveis();
		new SetorController().deletarTodosSetores();
		CargoDAO.getInstance(ConnectionHibernate.getSession()).deleteAll();
		
	}
	
	public static void popularTabelas() throws Exception{
		cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), 123456, 12345,
				20, 1, "12", "HACKERDEHIBERNATE", true, 1);
		idCargo = CargoDAO.getInstance(ConnectionHibernate.getSession()).create(cargo);
		idNivel = new NivelController().cadastrarNivel("supremo");
		idSetor = new SetorController().cadastrarSetor("Setorbom", idCargo);
		int idSetor2 = new SetorController().cadastrarSetor("Setorruim", idCargo);
		
		Cargo = CargoDAO.getInstance(ConnectionHibernate.getSession()).retrieve(idCargo);
		Setor = new SetorController().buscarSetorPorId(idSetor);
		Setor2 = new SetorController().buscarSetorPorId(idSetor2);
		Nivel = new NivelController().buscarNivel(idNivel);
	}
	
	@Before
	public void herewegoagain() throws Exception {
		limparTabelas();
		popularTabelas();
	}
	
	@Test
	public void cadastrarPostoDeTrabalhoTest() throws Exception {

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
		int id = controller.cadastrarPostoDeTrabalho("Inval1d0!", Cargo, Setor, Nivel, salario);
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, Cargo, Setor, Nivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(id));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, Cargo, Setor, Nivel, salario);
		controller.atualizarPostoDeTrabalho(id, "Desenvolvedor(a) Junior", Cargo, Setor2, Nivel, salario);
		PostoDeTrabalhoModel postoAtualizado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals(Setor2.getId(), postoAtualizado.getIdSetor().getId());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, Cargo, Setor, Nivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals((Object)id, postoProcurado.getIdPosto());
		assertEquals(nomePosto, postoProcurado.getNomePosto());
		assertEquals((Integer) idCargo, postoProcurado.getIdCargo().getIdCargo());
		assertEquals((Integer) idSetor, postoProcurado.getIdSetor().getId());
		assertEquals((Integer) idNivel, postoProcurado.getIdNivel().getId());
		assertEquals(salario, postoProcurado.getSalario());
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, Cargo, Setor, Nivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals(postoProcurado.getNomePosto(),
				controller.buscarPostoDeTrabalhoNome(nomePosto).get(0).getNomePosto());
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() throws Exception {
		//int before = controller.buscarTodosPostosDeTrabalho().size();
		controller.cadastrarPostoDeTrabalho(nomePosto, Cargo, Setor, Nivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", Cargo, Setor, Nivel, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", Cargo, Setor2, Nivel, 7000.00);
		assertEquals(3, controller.buscarTodosPostosDeTrabalho().size());
	}
	
	
	
}
