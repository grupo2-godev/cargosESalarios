package utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.HorasMesDAO;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;

public class HibernateMethodsTest {

	@Test
	public void listarTabela() {
		HorasMesDAO dao = HorasMesDAO.getInstance(ConnectionHibernate.getSession());
		HorasMesModel entry = new HorasMesModel(240.042);
		int savedId = dao.create(entry);
		
		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		List<HorasMesModel> tableEntries = methods.listarPorTabela(HorasMesModel.class);
		HorasMesModel lastObjectInList = tableEntries.get(tableEntries.size()-1);
		assertEquals((int)lastObjectInList.getIdHorasMes(), savedId);
		assertEquals(lastObjectInList.getQuantidade(), entry.getQuantidade());
	}
	
	@Test
	public void listarPorSelecaoDeId() {
		HorasMesDAO dao = HorasMesDAO.getInstance(ConnectionHibernate.getSession());
		HorasMesModel entry = new HorasMesModel(525.525);
		int savedId = dao.create(entry);

		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		List<HorasMesModel> tableEntries = 
			methods.listarPorValorDeColunaExato(HorasMesModel.class, "idHorasMes", savedId);
		HorasMesModel lastObjectInList = tableEntries.get(tableEntries.size()-1);
		assertEquals((int)lastObjectInList.getIdHorasMes(), savedId);
		assertEquals(lastObjectInList.getQuantidade(), entry.getQuantidade());
		assertEquals(tableEntries.size(), 1);
	}
	
	@Test
	public void listarPorSelecaoDeColuna() {
		HorasMesDAO dao = HorasMesDAO.getInstance(ConnectionHibernate.getSession());
		HorasMesModel entry = new HorasMesModel(525.525);
		int savedId = dao.create(entry);
		entry.setIdHorasMes(savedId);
		
		HibernateMethods<HorasMesModel> methods = new HibernateMethods<HorasMesModel>();
		List<HorasMesModel> tableEntries = 
			methods.listarPorValorDeColunaExato(HorasMesModel.class, "quantidade", 525.525);
		assertTrue(tableEntries.contains(entry));
	}
	
	@Test
	public void listarPorSelecaoDeColunaString() {
		SetorDAO dao = SetorDAO.getInstance(ConnectionHibernate.getSession());
		SetorModel entry = new SetorModel("Setor legal", 42);
		dao.create(entry);
		
		HibernateMethods<SetorModel> methods = new HibernateMethods<SetorModel>();
		List<SetorModel> tableEntries = 
			methods.listarPorValorDeColunaComStringIncompleta(SetorModel.class, "nomeSetor", "Set");
		assertTrue(tableEntries.contains(entry));
	}

}
