package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

/**
 * Testes referentes aos métodos da classe {@link CargoDAO}.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CargoDAOTest {
	static CargoDAO cargoDAO = CargoDAO.getInstancia();
	static GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstancia();
	static CBO2002DAO cbo2002DAO = CBO2002DAO.getInstancia();
	static CBO1994DAO cbo1994DAO = CBO1994DAO.getInstancia();
	static HorasMesDAO horasMesDAO = HorasMesDAO.getInstancia();
	static LocalDateTime dataCadastro;
	static LocalDateTime dataUltimaRevisao;
	static Integer codigoCbo2002;
	static Integer codigoCbo1994;
	static Integer idHorasMes;
	static Integer idGrauInstrucao;
	static String experienciaMinima;
	static String atribuicoes;
	static Boolean status;
	static Integer idPermissao;

	static GrauInstrucaoModel grauInstrucao;
	static CBO2002Model cbo2002;
	static CBO1994Model cbo1994;
	static HorasMesModel horasMes;

	@BeforeClass
	public static void setUpBeforeClass() {
		cargoDAO.deletarTodos("cargo");
		grauInstrucaoDAO.deletarTodos("grau_instrucao");
		cbo2002DAO.deletarTodos("cbo2002");
		cbo1994DAO.deletarTodos("cbo1994");
		horasMesDAO.deletarTodos("horas_mes");

		popularTabelas();
	}
	
	@AfterClass
	public static void setUpAfterClass() {
		cargoDAO.deletarTodos("cargo");
		grauInstrucaoDAO.deletarTodos("grau_instrucao");
		cbo2002DAO.deletarTodos("cbo2002");
		cbo1994DAO.deletarTodos("cbo1994");
		horasMesDAO.deletarTodos("horas_mes");
	}

	@Before
	public void limparTabelas() {
		cargoDAO.deletarTodos("cargo");
	}

	public static void popularTabelas() {
		idGrauInstrucao = grauInstrucaoDAO.criar(new GrauInstrucaoModel("Ensino superior completo"));
		grauInstrucao = grauInstrucaoDAO.buscar(GrauInstrucaoModel.class, idGrauInstrucao);

		codigoCbo2002 = cbo2002DAO.criar(new CBO2002Model(666666, "Desenvolvedor", Insalubridade.Dez.getValor(),
				Periculosidade.Trinta.getValor()));
		cbo2002 = cbo2002DAO.buscar(CBO2002Model.class, codigoCbo2002);

		codigoCbo1994 = cbo1994DAO.criar(new CBO1994Model(55555, "Desenvolvedor", Insalubridade.Dez.getValor(),
				Periculosidade.Trinta.getValor()));
		cbo1994 = cbo1994DAO.buscar(CBO1994Model.class, codigoCbo1994);

		idHorasMes = horasMesDAO.criar(new HorasMesModel(240d));
		horasMes = horasMesDAO.buscar(HorasMesModel.class, idHorasMes);
	}

	@Test
	public void testCreate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		Object cargoConsultado = ConexaoHibernate.getSessao().get(CargoModel.class, idObjetoCadastrado);
		assertEquals(idObjetoCadastrado, ((CargoModel) cargoConsultado).getIdCargo());
	}

	@Test
	public void testRetrieveId() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		CargoModel cargoConsultado = cargoDAO.buscar(CargoModel.class, idObjetoCadastrado);
		assertEquals(cargo.getNomeCargo(), cargoConsultado.getNomeCargo());
	}

	@Test
	public void testUpdate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor 1", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		CargoModel novoCargo = new CargoModel("Inspetor", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor 2", true, 1);
		cargoDAO.atualizar(idObjetoCadastrado, novoCargo);
		CargoModel cargoAlterado = cargoDAO.buscar(CargoModel.class, idObjetoCadastrado);
		assertEquals(novoCargo.getNomeCargo(), cargoAlterado.getNomeCargo());
	}

	@Test
	public void testDelete() {
		int totalRegistros = cargoDAO.listarPorTabela(CargoModel.class).size();
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor 1", true, 1);
		Integer idObjetoCadastrado = cargoDAO.criar(cargo);
		assertEquals(totalRegistros + 1, cargoDAO.listarPorTabela(CargoModel.class).size());
		cargoDAO.deletar(CargoModel.class, idObjetoCadastrado);
		assertEquals(totalRegistros, cargoDAO.listarPorTabela(CargoModel.class).size());

	}

	@Test
	public void testGetAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor", true, 1);
		CargoModel cargo2 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.criar(cargo);
		cargoDAO.criar(cargo2);
		ArrayList<CargoModel> lista = (ArrayList<CargoModel>) cargoDAO.listarPorTabela(CargoModel.class);

		assertEquals(2, lista.size());
	}

	@Test
	public void deletarTodos() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.criar(cargo);
		assertEquals(1, cargoDAO.listarPorTabela(CargoModel.class).size());
		cargoDAO.deletarTodos("cargo");
		assertEquals(0, cargoDAO.listarPorTabela(CargoModel.class).size());
	}
}