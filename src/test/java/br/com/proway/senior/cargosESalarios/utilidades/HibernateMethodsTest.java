package br.com.proway.senior.cargosESalarios.utilidades;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.controller.CBO1994Controller;
import br.com.proway.senior.cargosESalarios.controller.CBO2002Controller;
import br.com.proway.senior.cargosESalarios.controller.CargoController;
import br.com.proway.senior.cargosESalarios.controller.GrauInstrucaoController;
import br.com.proway.senior.cargosESalarios.controller.HorasMesController;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.HorasMesDAO;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

public class HibernateMethodsTest {
	static String nomeCargo = "Desenvolvedor 2";
	static LocalDateTime dataCadastro = LocalDateTime.now();
	static LocalDateTime dataUltimaRevisao = LocalDateTime.now();
	static Integer codigoCbo2002;
	static Integer codigoCbo1994;
	static Integer idHorasMes;
	static Integer idGrauInstrucao;
	static String experienciaMinima = "1";
	static String atribuicoes = "Desenvolvedor";
	static Boolean status = true;
	static Integer idPermissao = 1;

	static GrauInstrucaoModel grauInstrucao;
	static CBO2002Model cbo2002;
	static CBO1994Model cbo1994;
	static HorasMesModel horasMes;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new CargoController().deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();

		popularTabelas();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		new CargoController().deletarTodos();
		new GrauInstrucaoController().deletarTodos();
		new CBO2002Controller().deletarTodosCBO2002();
		new CBO1994Controller().deletarTodosCBO1994();
		new HorasMesController().deletarTodosHorasMes();
	}
	
	public static void popularTabelas() throws Exception {
		idGrauInstrucao = new GrauInstrucaoController().cadastrar("Ensino superior completo");
		grauInstrucao = new GrauInstrucaoController().buscarPorId(idGrauInstrucao);

		codigoCbo2002 = new CBO2002Controller().cadastrarCBO2002(666666, "Desenvolvedor", Insalubridade.Dez,
				Periculosidade.Trinta);
		cbo2002 = new CBO2002Controller().buscarCBO2002PorCodigo(codigoCbo2002);

		codigoCbo1994 = new CBO1994Controller().cadastrarCBO1994(55555, "Desenvolvedor", Insalubridade.Dez,
				Periculosidade.Trinta);
		cbo1994 = new CBO1994Controller().buscarCBO1994(codigoCbo1994);

		idHorasMes = new HorasMesController().cadastrarHorasMes(240d);
		horasMes = new HorasMesController().buscarHorasMes(idHorasMes);
	}
	
	@Test
	public void listarTabela() {
		HorasMesDAO dao = HorasMesDAO.getInstancia(ConexaoHibernate.getSessao());
		HorasMesModel entry = new HorasMesModel(240.042);
		int savedId = dao.criar(entry);
		
		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		List<HorasMesModel> tableEntries = methods.listarPorTabela(HorasMesModel.class);
		HorasMesModel lastObjectInList = tableEntries.get(tableEntries.size()-1);
		assertEquals((int)lastObjectInList.getIdHorasMes(), savedId);
		assertEquals(lastObjectInList.getQuantidade(), entry.getQuantidade());
	}
	
	@Test
	public void listarPorSelecaoDeId() {
		HorasMesDAO dao = HorasMesDAO.getInstancia(ConexaoHibernate.getSessao());
		HorasMesModel entry = new HorasMesModel(525.525);
		int savedId = dao.criar(entry);

		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		List<HorasMesModel> tableEntries = 
			methods.listarPorValorDeColunaExato(HorasMesModel.class, "idHorasMes", savedId);
		HorasMesModel lastObjectInList = tableEntries.get(tableEntries.size()-1);
		assertEquals((int)lastObjectInList.getIdHorasMes(), savedId);
		assertEquals(lastObjectInList.getQuantidade(), entry.getQuantidade());
		assertEquals(tableEntries.size(), 1);
	}
	
	@Test
	public void listarPorSelecaoDeColunaDouble() {
		HorasMesDAO dao = HorasMesDAO.getInstancia(ConexaoHibernate.getSessao());
		HorasMesModel entry = new HorasMesModel(525.525);
		int savedId = dao.criar(entry);
		entry.setIdHorasMes(savedId);
		
		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		List<HorasMesModel> tableEntries = 
			methods.listarPorValorDeColunaExato(HorasMesModel.class, "quantidade", 525.525);
		assertTrue(tableEntries.contains(entry));
	}
	
	@Test
	public void listarPorSelecaoDeColunaBoolean() throws Exception {
		CargoModel cargo = new CargoController().construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		new CargoController().cadastrar(cargo);
		
		HibernateMethods<CargoModel> methods = new HibernateMethods<CargoModel>();
		List<CargoModel> tableEntries = 
			methods.listarPorValorDeColunaExato(CargoModel.class, "status", true);
		assertTrue(tableEntries.contains(cargo));
	}
	
	@Test
	public void listarPorSelecaoDeColunaInteger() throws Exception {
		CargoModel cargo = new CargoController().construir(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		new CargoController().cadastrar(cargo);
		
		HibernateMethods<CargoModel> methods = new HibernateMethods<CargoModel>();
		List<CargoModel> tableEntries = 
			methods.listarPorValorDeColunaExato(CargoModel.class, "idPermissao", idPermissao);
		assertTrue(tableEntries.contains(cargo));
	}
	
	@Test
	public void listarPorSelecaoDeColunaString() {
		SetorDAO dao = SetorDAO.getInstancia(ConexaoHibernate.getSessao());
		SetorModel entry = new SetorModel("RH", 42);
		int id = dao.criar(entry);
		entry.setId(id);
		
		HibernateMethods<SetorModel> methods = new HibernateMethods<SetorModel>();
		List<SetorModel> tableEntries = 
			methods.listarPorValorDeColunaExato(SetorModel.class, "nomeSetor", "RH");
		assertTrue(tableEntries.contains(entry));
	}
	
	@Test
	public void listarPorSelecaoDeColunaStringIncompleta() {
		SetorDAO dao = SetorDAO.getInstancia(ConexaoHibernate.getSessao());
		SetorModel entry = new SetorModel("Compras", 44);
		int id = dao.criar(entry);
		entry.setId(id);
		
		HibernateMethods<SetorModel> methods = new HibernateMethods<SetorModel>();
		List<SetorModel> tableEntries = 
			methods.listarPorValorDeColunaComStringIncompleta(SetorModel.class, "nomeSetor", "Com");
		assertTrue(tableEntries.contains(entry));
	}

}
