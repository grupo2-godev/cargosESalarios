package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO2002DAO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe CBO2002DAOTest.
 * 
 * Classe que testa os métodos da classe CBO2002DAO.
 * 
 * @author @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */
public class CBO2002DAOTest {
        
	CBO2002DAO cbo2002DAO = CBO2002DAO.getInstance(ConnectionHibernate.getSession());
	
    @Test
    public void testInserirCBO2002() {
        CBO2002Model novoCBO = new CBO2002Model(784205, "Abastecedor de máquinas de "
        		+ "linha de produção", 0.0, 0.2);
        Integer codigoCboCadastrado = cbo2002DAO.create(novoCBO);
        Object CBOConsultado = ConnectionHibernate.getSession().get(CBO2002Model.class, codigoCboCadastrado);
        assertEquals(codigoCboCadastrado, ((CBO2002Model) CBOConsultado).getCodigoCBO2002());   
    }

    @Test
    public void testBuscarCBO2002PorID() {
    	CBO2002Model novoCBO = new CBO2002Model(765010, "Padronista de chapéus", 0.0, 0.0);
    	CBO2002Model cboRetornado = cbo2002DAO.retrieve(cbo2002DAO.create(novoCBO));
    	assertEquals(novoCBO.getDescricao(), cboRetornado.getDescricao());
    	assertEquals(novoCBO.getPercentualInsalubridade(), cboRetornado.getPercentualInsalubridade());
    	assertEquals(novoCBO.getPercentualPericulosidade(), cboRetornado.getPercentualPericulosidade());
    }

    @Test
    public void update() {
    	CBO2002Model novoCBO = new CBO2002Model(223405, "Farmacêutico", 0.2, 0.0);
    	CBO2002Model cboAlterado = new CBO2002Model(223405, "Farmacêutico(a)", 0.2, 0.0);
    	int codigo = cbo2002DAO.create(novoCBO);
    	cbo2002DAO.update(codigo, cboAlterado);
    	CBO2002Model alterado = cbo2002DAO.retrieve(codigo);
    	assertEquals(alterado.getDescricao(), cboAlterado.getDescricao());
    	assertEquals(alterado.getPercentualInsalubridade(), cboAlterado.getPercentualInsalubridade());
    	assertEquals(alterado.getPercentualPericulosidade(), cboAlterado.getPercentualPericulosidade());
    }
    
    @Test
    public void readAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteAll() {
    }
}