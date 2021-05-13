package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO2002DAO;

import org.junit.Test;

import static org.junit.Assert.*;

public class CBO2002DAOTest {
        CBO2002Model obj = new CBO2002Model(null,"Desenvolvedor", 0.2, 0.0);
        CBO2002DAO objSql = new CBO2002DAO();
        ConnectionPostgres con = new ConnectionPostgres();
    @Test
    public void create() {
        //Cenário
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
    public void limparTabela() {
    }
}