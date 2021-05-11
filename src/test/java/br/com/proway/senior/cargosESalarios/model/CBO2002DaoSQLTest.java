package br.com.proway.senior.cargosESalarios.model;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO2002DaoSQL;

import org.junit.Test;

import static org.junit.Assert.*;

public class CBO2002DaoSQLTest {
        Cbo2002Model obj = new Cbo2002Model(null,"Desenvolvedor", 0.2, 0.0);
        CBO2002DaoSQL objSql = new CBO2002DaoSQL();
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