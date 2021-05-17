package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
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

	HorasMesDAO horasMesDao = HorasMesDAO.getInstance(ConexaoHibernate.getSessao());
	
	@Test
	public void testInserirHoraMes() {
			HorasMesModel novaHoraMes = new HorasMesModel(5, 220.0);
			Integer idObjetoCadastrado = horasMesDao.create(novaHoraMes);
			Object horasMesConsultado = ConexaoHibernate.getSessao().get(HorasMesModel.class, idObjetoCadastrado);
			assertEquals(idObjetoCadastrado, ((HorasMesModel) horasMesConsultado).getIdHorasMes());
	}
	
	@Test
	public void testBuscarHorarioPorId() {
		HorasMesModel novoModel = new HorasMesModel(215.0);
		HorasMesModel horasRetornado = horasMesDao.retrieve(horasMesDao.create(novoModel));
		assertEquals(novoModel.getQuantidade(), horasRetornado.getQuantidade());
	}

	@Test
	public void testAtualizarHorario() {
		HorasMesModel modelAntigo = new HorasMesModel(220.0);
		HorasMesModel modelAlterado = new HorasMesModel(100.0);
		int id = horasMesDao.create(modelAntigo);
		horasMesDao.update(id, modelAlterado);
		HorasMesModel atualizado = horasMesDao.retrieve(id);
		assertEquals(atualizado.getQuantidade(), modelAlterado.getQuantidade());
	}
	
	@Test
	public void testDeletarHorario() {
		int size = horasMesDao.getAll().size();
		HorasMesModel horasModel = new HorasMesModel(220.0);
		int id = horasMesDao.create(horasModel);
		horasMesDao.delete(id);
		assertEquals(size, horasMesDao.getAll().size());
	}
	
	@Test
	public void testBuscarTodosHorarios() {
		HorasMesModel horasModel = new HorasMesModel(220.0);
		horasMesDao.create(horasModel);
		assertFalse(horasMesDao.getAll().isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistros() {
		HorasMesModel horasModel = new HorasMesModel(220.0);
		horasMesDao.create(horasModel);
		
		Boolean ret = horasMesDao.deleteAll();
		
		assertTrue(horasMesDao.getAll().isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistrosSemRegistrosADeletar() {
		horasMesDao.deleteAll();
		Boolean itensDeletados = horasMesDao.deleteAll();
		assertFalse(itensDeletados);
		assertTrue(horasMesDao.getAll().isEmpty());
	}
}
