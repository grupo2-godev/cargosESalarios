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
        
	CBO2002DAO cbo2002 = CBO2002DAO.getInstance(ConnectionHibernate.getSession());
	
    @Test
    public void testInserirCBO2002() {
        CBO2002Model novoCBO = new CBO2002Model(784205, "Abastecedor de máquinas de linha de produção", 0.0, 0.2);
    }

    @Test
    public void readById() {
    }

    @Test
    public void readAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteAll() {
    }
}