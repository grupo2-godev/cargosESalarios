package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

public class HoraMesDAOTest {

	HorasMesDAO horasMesDao = HorasMesDAO.getInstance(ConnectionHibernate.getSession());
	
	@Test
	public void testInserirHoraMes() {
		try {
			HorasMesModel novaHoraMes = new HorasMesModel(5, 220.0);
			Integer idObjetoCadastrado = horasMesDao.create(novaHoraMes);
			Object horasMesConsultado = ConnectionHibernate.getSession().get(HorasMesModel.class, idObjetoCadastrado);
			assertEquals(idObjetoCadastrado, ((HorasMesModel) horasMesConsultado).getIdHorasMes());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBuscarTodosHorarios() {
		
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
	public void testBuscarTodos() {
		assertFalse(horasMesDao.getAll().isEmpty());
	}
	
}
