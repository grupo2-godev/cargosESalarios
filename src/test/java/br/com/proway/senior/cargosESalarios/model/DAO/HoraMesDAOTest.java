package br.com.proway.senior.cargosESalarios.model.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
/**
 * Classe HoraMesDAOTest
 * 
 * Classe que realiza os testes da classe HoraMesDAO.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class HoraMesDAOTest {

	HorasMesDAO horasMesDao = HorasMesDAO.getInstancia();
	
	@Test
	public void testInserirHoraMes() {
			HorasMesModel novaHoraMes = new HorasMesModel(5, 220.0);
			Integer idObjetoCadastrado = horasMesDao.criar(novaHoraMes);
			Object horasMesConsultado = ConexaoHibernate.getSessao().get(HorasMesModel.class, idObjetoCadastrado);
			assertEquals(idObjetoCadastrado, ((HorasMesModel) horasMesConsultado).getIdHorasMes());
	}
	
	@Test
	public void testBuscarHorarioPorId() {
		HorasMesModel novoModel = new HorasMesModel(215.0);
		HorasMesModel horasRetornado = horasMesDao.buscar(HorasMesModel.class, horasMesDao.criar(novoModel));
		assertEquals(novoModel.getQuantidade(), horasRetornado.getQuantidade());
	}

	@Test
	public void testAtualizarHorario() {
		HorasMesModel modelAntigo = new HorasMesModel(220.0);
		HorasMesModel modelAlterado = new HorasMesModel(100.0);
		int id = horasMesDao.criar(modelAntigo);
		modelAlterado.setIdHorasMes(id);
		horasMesDao.atualizar(modelAlterado);
		HorasMesModel atualizado = horasMesDao.buscar(HorasMesModel.class, id);
		assertEquals(atualizado.getQuantidade(), modelAlterado.getQuantidade());
	}
	
	@Test
	public void testDeletarHorario() {
		int size = horasMesDao.listarPorTabela(HorasMesModel.class).size();
		HorasMesModel horasModel = new HorasMesModel(220.0);
		int id = horasMesDao.criar(horasModel);
		horasMesDao.deletar(HorasMesModel.class, id);
		assertEquals(size, horasMesDao.listarPorTabela(HorasMesModel.class).size());
	}
	
	@Test
	public void testBuscarTodosHorarios() {
		HorasMesModel horasModel = new HorasMesModel(220.0);
		horasMesDao.criar(horasModel);
		assertFalse(horasMesDao.listarPorTabela(HorasMesModel.class).isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistros() {
		HorasMesModel horasModel = new HorasMesModel(220.0);
		horasMesDao.criar(horasModel);
		
		horasMesDao.deletarTodos("horas_mes");
		
		assertTrue(horasMesDao.listarPorTabela(HorasMesModel.class).isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistrosSemRegistrosADeletar() {
		horasMesDao.deletarTodos("horas_mes");
		Boolean itensDeletados = horasMesDao.deletarTodos("horas_mes");
		assertFalse(itensDeletados);
		assertTrue(horasMesDao.listarPorTabela(HorasMesModel.class).isEmpty());
	}
	
	@Test
	public void testSetQuantidade() {
		HorasMesModel horasModel = new HorasMesModel();
		horasModel.setQuantidade(240.0);
		assertEquals(horasModel.getQuantidade(), 240.0);
	}
}
