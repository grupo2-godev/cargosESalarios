package br.com.proway.senior.cargosESalarios.model;

import br.com.proway.senior.cargosESalarios.antigos.Cbo2002DAO;
import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import org.junit.Test;

import static org.junit.Assert.*;

public class CBO2002DaoSQLTest {
        Cbo2002Model obj = new Cbo2002Model(null,"Desenvolvedor", 0.2, 0.0);
        Cbo2002DAO objSql = new Cbo2002DAO();
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