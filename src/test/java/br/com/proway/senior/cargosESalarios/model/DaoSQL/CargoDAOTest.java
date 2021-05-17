package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CargoModel;

/**
 * Testes referentes aos métodos da classe {@link CargoDAO}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDAOTest {
	CargoDAO cargoDAO = CargoDAO.getInstancia(ConexaoHibernate.getSessao());

	Integer grauinstrucao = 0;
	Integer cbo2002 = 0;
	Integer cbo1994 = 0;
	Integer horasmes = 0;

	@Test
	public void testCreate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		Object cargoConsultado = ConexaoHibernate.getSessao().get(CargoModel.class, idObjetoCadastrado);
		assertEquals(idObjetoCadastrado, ((CargoModel) cargoConsultado).getIdCargo());
	}

	@Test
	public void testRetrieveId() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		CargoModel cargoConsultado = cargoDAO.buscar(idObjetoCadastrado);
		assertEquals(cargo.getNomeCargo(), cargoConsultado.getNomeCargo());
	}

	@Test
	public void testUpdate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor 1", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		CargoModel novoCargo = new CargoModel("Inspetor", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor 2", true, 1);
		cargoDAO.atualizar(idObjetoCadastrado, novoCargo);
		CargoModel cargoAlterado = cargoDAO.buscar(idObjetoCadastrado);
		assertEquals(novoCargo.getNomeCargo(), cargoAlterado.getNomeCargo());
	}
	
	@Test
	public void testDelete() {
		int totalRegistros = cargoDAO.buscarTodos().size();
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor 1", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		assertEquals(totalRegistros + 1, cargoDAO.buscarTodos().size());
		cargoDAO.deletar(idObjetoCadastrado);
		assertEquals(totalRegistros, cargoDAO.buscarTodos().size());
	}
	
	@Test
	public void testGetAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		CargoModel cargo2 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.criar(cargo);
		cargoDAO.criar(cargo2);
		ArrayList<CargoModel> lista = cargoDAO.buscarTodos();
		assertEquals(2, lista.size());
	}

	@Test
	public void deleteAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.criar(cargo);
		assertEquals(1, cargoDAO.buscarTodos().size());
		cargoDAO.deletarTodos();
		assertEquals(0, cargoDAO.buscarTodos().size());
	}

	@Before
	public void limparTabela() throws SQLException {
		cargoDAO.deletarTodos();
		assertEquals(0, cargoDAO.buscarTodos().size());
	}
}