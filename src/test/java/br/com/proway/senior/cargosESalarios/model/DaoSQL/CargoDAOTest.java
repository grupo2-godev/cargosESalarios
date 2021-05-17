package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import utils.Insalubridade;
import utils.Periculosidade;

/**
 * Testes referentes aos métodos da classe {@link CargoDAO}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDAOTest {
	CargoDAO cargoDAO = CargoDAO.getInstance(ConnectionHibernate.getSession());
	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstance(ConnectionHibernate.getSession());
	CBO2002DAO cbo2002DAO = CBO2002DAO.getInstance(ConnectionHibernate.getSession());
	CBO1994DAO cbo1994DAO = CBO1994DAO.getInstance(ConnectionHibernate.getSession());
	HorasMesDAO horasMesDAO = HorasMesDAO.getInstance(ConnectionHibernate.getSession());

	LocalDateTime dataCadastro;
	LocalDateTime dataUltimaRevisao;
	Integer codigoCbo2002;
	Integer codigoCbo1994;
	Integer idHorasMes;
	Integer idGrauInstrucao;
	String experienciaMinima;
	String atribuicoes;
	Boolean status;
	Integer idPermissao;

	GrauInstrucaoModel grauInstrucao;
	CBO2002Model cbo2002;
	CBO1994Model cbo1994;
	HorasMesModel horasMes;

	@BeforeClass
	public void setUpBeforeClass() {
		cargoDAO.deleteAll();
		grauInstrucaoDAO.deleteAll();
		cbo2002DAO.deleteAll();
		cbo1994DAO.deleteAll();
		horasMesDAO.deleteAll();
		
		popularTabelas();
	}

	public void popularTabelas() {
		idGrauInstrucao = grauInstrucaoDAO.create(new GrauInstrucaoModel("Ensino superior completo"));
		grauInstrucao = grauInstrucaoDAO.retrieve(idGrauInstrucao);

		codigoCbo2002 = cbo2002DAO.create(new CBO2002Model(666666, "Desenvolvedor", Insalubridade.Dez.getValor(),
				Periculosidade.Trinta.getValor()));
		cbo2002 = cbo2002DAO.retrieve(codigoCbo2002);

		codigoCbo1994 = cbo1994DAO.create(new CBO1994Model(55555, "Desenvolvedor", Insalubridade.Dez.getValor(),
				Periculosidade.Trinta.getValor()));
		cbo1994 = cbo1994DAO.retrieve(codigoCbo1994);
		
		idHorasMes = horasMesDAO.create(new HorasMesModel(240d));
		horasMes = horasMesDAO.retrieve(idHorasMes);
	}

	@Test
	public void testCreate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.create(cargo);
		Object cargoConsultado = ConnectionHibernate.getSession().get(CargoModel.class, idObjetoCadastrado);
		assertEquals(idObjetoCadastrado, ((CargoModel) cargoConsultado).getIdCargo());
	}

	@Test
	public void testRetrieveId() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.create(cargo);
		CargoModel cargoConsultado = cargoDAO.retrieve(idObjetoCadastrado);
		assertEquals(cargo.getNomeCargo(), cargoConsultado.getNomeCargo());
	}

	@Test
	public void testUpdate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor 1", true, 1);
		Integer idObjetoCadastrado = cargoDAO.create(cargo);
		CargoModel novoCargo = new CargoModel("Inspetor", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor 2", true, 1);
		cargoDAO.update(idObjetoCadastrado, novoCargo);
		CargoModel cargoAlterado = cargoDAO.retrieve(idObjetoCadastrado);
		assertEquals(novoCargo.getNomeCargo(), cargoAlterado.getNomeCargo());
	}

	@Test
	public void testDelete() {
		int totalRegistros = cargoDAO.getAll().size();
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor 1", true, 1);
		Integer idObjetoCadastrado = cargoDAO.create(cargo);
		assertEquals(totalRegistros + 1, cargoDAO.getAll().size());
		cargoDAO.delete(idObjetoCadastrado);
		assertEquals(totalRegistros, cargoDAO.getAll().size());
	}

	@Test
	public void testGetAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		CargoModel cargo2 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.create(cargo);
		cargoDAO.create(cargo2);
		ArrayList<CargoModel> lista = cargoDAO.getAll();
		assertEquals(2, lista.size());
	}

	@Test
	public void deleteAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.create(cargo);
		assertEquals(1, cargoDAO.getAll().size());
		cargoDAO.deleteAll();
		assertEquals(0, cargoDAO.getAll().size());
	}

}