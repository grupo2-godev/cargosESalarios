package br.com.proway.senior.cargosESalarios.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Implementar os m�todos CRUD para o Banco de dados.
 *
 * @author Samuel Alves <samuel.levi@senior.com.br>
 * @version Sprint 4
 */
public class CBO2002DaoSQL {

    ConnectionPostgres con = new ConnectionPostgres();

    /**
     * Criar um objeto. Cria um objeto do tipo Cbo2002.
     * @param obj
     * @throws SQLException
     */
    public void create(Cbo2002Model obj) throws SQLException {

        String insert = "INSERT INTO cbo2002 (descricao, percentual_insalubridade, percentual_periculosidade) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = con.conectar().prepareStatement(insert);
            preparedStatement.setString(1, obj.getDescricao());
            preparedStatement.setDouble(2, obj.getPercentualInsalubridade());
            preparedStatement.setDouble(3, obj.getPercentualPericulosidade());
            preparedStatement.execute();
            System.out.println("CBO 2002 cadastrado com sucesso!");
        } catch (SQLException exception) {
            System.out.println("Falha ao cadastrar o CBO 2002");
            exception.getErrorCode();
            exception.getSQLState();
            exception.printStackTrace();
        }
    }

    /**
     * Retornar um objeto de acordo com o Id informado, adiciona
     * � um ArrayList e retorna o conte�do.
     * @param index
     * @return result
     */
    public ArrayList<String> readById(int index) {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * FROM cbo2002 WHERE id = " + index;
        ResultSet rs;
        try {
            rs = con.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();
            if (rs.next()) {
                for (int i = 0; i < totalColumns; i++) {
                    result.add(rs.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Retornar todos os objetos da tabela. Percorre a tabela cbo2002,
     * salva todos as tuplas em um ArrayList e retorna o resultado salvo.
     * @return results
     */
    public ArrayList<ArrayList<String>> readAll() {
        ArrayList<ArrayList<String>> results =
                new ArrayList<ArrayList<String>>();
        String query = "SELECT * FROM cbo2002";
        ResultSet rs;
        try {
            rs = con.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                for (int i = 0; i < totalColumns; i++) {
                    row.add(rs.getString(i));
                }
                results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Apagar um registro da tabela. Busca na tabela o registro
     * que possui o Id id�ntico ao par�metro informado e apaga.
     * @param index
     */
    public void delete(int index) {
        String query = "DELETE FROM cbo2002 WHERE id =" + index;
        try {
            con.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualizar um registro na tabela. Busca na tabela o
     * �ndice correspondente, na coluna informada e modifica
     * o conte�do existente, pela String informada na vari�vel
     * data.
     * @param index
     * @param col
     * @param data
     */
    public void update(int index, String col, String data) {
        String query =
                "UPDATE cbo2002 SET " + col + "=" + data + " WHERE id =" + index;
        try {
            con.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletar todo o conte�do da tabela. Ser� usado para
     * fins de testes unit�rios.
     * @throws SQLException
     */
    public void limparTabela() throws SQLException {
        String limpar = "DELETE TABLE grupo2.cbo2002";
        con.executeQuery(limpar);
    }
}
