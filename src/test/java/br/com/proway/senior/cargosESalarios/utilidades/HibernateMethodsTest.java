package br.com.proway.senior.cargosESalarios.utilidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.controller.CargoController;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.HorasMesDAO;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;

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
		new HibernateMethods<CargoModel>().deletarTodos("cargo");
		new HibernateMethods<GrauInstrucaoModel>().deletarTodos("grau_instrucao");
		new HibernateMethods<CBO2002Model>().deletarTodos("CBO2002");
		new HibernateMethods<CBO1994Model>().deletarTodos("cbo1994");
		new HibernateMethods<HorasMesModel>().deletarTodos("horas_mes");
		new HibernateMethods<SetorModel>().deletarTodos("setor");
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		new HibernateMethods<CargoModel>().deletarTodos("cargo");
		new HibernateMethods<GrauInstrucaoModel>().deletarTodos("grau_instrucao");
		new HibernateMethods<CBO2002Model>().deletarTodos("CBO2002");
		new HibernateMethods<CBO1994Model>().deletarTodos("cbo1994");
		new HibernateMethods<HorasMesModel>().deletarTodos("horas_mes");
		new HibernateMethods<SetorModel>().deletarTodos("setor");		
	}
	
	public static void popularTabelas() throws Exception {
		
		grauInstrucao = new GrauInstrucaoModel("Ensino superior completo");
		idGrauInstrucao = new HibernateMethods<GrauInstrucaoModel>().criar(grauInstrucao);
		grauInstrucao = new HibernateMethods<GrauInstrucaoModel>().buscar(GrauInstrucaoModel.class, idGrauInstrucao);
		
		cbo1994 = new CBO1994Model(12345, "desenvolvedor", Insalubridade.Dez.getValor(), Periculosidade.Zero.getValor());
		codigoCbo1994 = new HibernateMethods<CBO1994Model>().criar(cbo1994);
				
		cbo2002 = new CBO2002Model(123456, "desenvolvedor", Insalubridade.Dez.getValor(), Periculosidade.Zero.getValor());
		codigoCbo2002 = new HibernateMethods<CBO2002Model>().criar(cbo2002);
		
		horasMes = new HorasMesModel(220.0);
		idHorasMes = new HibernateMethods<HorasMesModel>().criar(horasMes);
		horasMes = new HibernateMethods<HorasMesModel>().buscar(HorasMesModel.class, idHorasMes);	
	}
	
	@Before
	public void limparTabelas() throws Exception {
		new HibernateMethods<PostoDeTrabalhoModel>().deletarTodos("posto_de_trabalho");
		new HibernateMethods<CargoModel>().deletarTodos("cargo");
		
		new HibernateMethods<CBO1994Model>().deletarTodos("cbo1994");
		new HibernateMethods<CBO2002Model>().deletarTodos("CBO2002");
		new HibernateMethods<GrauInstrucaoModel>().deletarTodos("grau_instrucao");
		new HibernateMethods<HorasMesModel>().deletarTodos("horas_mes");
		
		new HibernateMethods<SetorModel>().deletarTodos("setor");	
		new HibernateMethods<NivelModel>().deletarTodos("nivelmodel");	
		popularTabelas();
		System.out.println();
	}
	
	@Test
	public void salvarEBuscarObjeto() {
		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		HorasMesModel entry = new HorasMesModel(240.042);
		int savedId = methods.criar(entry);
		
		HorasMesModel created = methods.buscar(HorasMesModel.class, savedId);
		assertEquals((Integer) savedId, created.getIdHorasMes());
	}
	
	@Test
	public void deletarObjeto() {
		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		HorasMesModel entry = new HorasMesModel(240.042);
		int savedId = methods.criar(entry);
		
		boolean success = methods.deletar(HorasMesModel.class, savedId);
		assertTrue(success);
	}
	
	@Test
	public void listarTabela() {
		HorasMesDAO dao = HorasMesDAO.getInstancia();
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
		HorasMesDAO dao = HorasMesDAO.getInstancia();
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
		HorasMesDAO dao = HorasMesDAO.getInstancia();
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
	
	@Test
	public void atualizarObjetoNoBancoDeDados() throws Exception {
		CargoModel cargo = new CargoModel(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo1994, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
		HibernateMethods<CargoModel> hibernateMethods = HibernateMethods.getInstancia();
		int id = hibernateMethods.criar(cargo);
		CargoModel cargoBanco = hibernateMethods.buscar(CargoModel.class, id);
		cargoBanco.setAtribuicoes("Andar de bicicleta, bater palmas");
		hibernateMethods.atualizar(cargoBanco);
		assertEquals("Andar de bicicleta, bater palmas", hibernateMethods.buscar(CargoModel.class, id).getAtribuicoes());
	}
	
	@Test
	public void deletarTodosObjetosNoBancoDeDados() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasMes, grauInstrucao, "12", "Desenvolvedor", true, 1);
		
		HibernateMethods<CargoModel> hibernateMethods = HibernateMethods.getInstancia();
		hibernateMethods.criar(cargo);
		assertEquals(1, hibernateMethods.listarPorTabela(CargoModel.class).size());
		hibernateMethods.deletarTodos("cargo");
		assertEquals(0, hibernateMethods.listarPorTabela(CargoModel.class).size());
	}
}
