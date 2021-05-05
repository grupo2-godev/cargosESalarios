package br.com.proway.senior.cargosESalarios.model;

import java.sql.*;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Implementar os métodos CRUD para o Banco de dados.
 *
 * @author Samuel Alves <samuel.levi@senior.com.br>
 * @version Sprint 4
 */
public class CBO2002DaoSQL {

    ConnectionPostgres con = new ConnectionPostgres();

    /**
     * Criar um objeto. Cria um objeto do tipo Cbo2002.
     * @param obj Cbo2002Model
     * @throws SQLException exception
     */
    public int create(Cbo2002Model obj){

        String insert = "INSERT INTO grupo2.cbo2002 (descricao, percentual_insalubridade, percentual_periculosidade) VALUES (?,?,?)";
        int qtd =0;
        try {
            PreparedStatement prepStmt = con.conectar().prepareStatement(insert);
            prepStmt.setString(1, obj.getDescricao());
            prepStmt.setDouble(2, obj.getPercentualInsalubridade());
            prepStmt.setDouble(3, obj.getPercentualPericulosidade());
            prepStmt.execute();
            String sqlCount = "SELECT COUNT(*) FROM grupo2.cbo2002";
            ResultSet rs = con.executeQuery(sqlCount);
            rs.next();
            qtd = rs.getInt(1);
            System.out.println("CBO 2002 cadastrado com sucesso!");
            return qtd;
        } catch (SQLException exception) {
            System.out.println("Falha ao cadastrar o CBO 2002");
            exception.getErrorCode();
            exception.getSQLState();
            exception.printStackTrace();
        }
        return qtd;
    }

    public Cbo2002Model retrieve(int codigoCbo) {
        String sqlRetrieveId = "SELECT * FROM grupo2.cbo2002 WHERE codigo_cbo = " + codigoCbo;
        try {
            Statement stmt = con.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sqlRetrieveId);
            Cbo2002Model cbo2002 = new Cbo2002Model();
            while (rs.next()) {
                cbo2002.setDescricao(rs.getString(1));
                cbo2002.setPercentualInsalubridade(rs.getDouble(2));
                cbo2002.getPercentualPericulosidade(rs.getDouble(3));

                System.out.println(cbo2002.toString());
            }
            return cbo2002;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
            rs = ConnectionPostgres.executeQuery(query);
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
     * que possui o Id idêntico ao parâmetro informado e apaga.
     * @param index int
     */
    public void delete(int index) {
        String query = "DELETE FROM cbo2002 WHERE id =" + index;
        try {
            ConnectionPostgres.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualizar um registro na tabela. Busca na tabela o
     * índice correspondente, na coluna informada e modifica
     * o conteúdo existente, pela String informada na variável
     * data.
     * @param index int
     * @param col String
     * @param data String
     */
    public void update(int index, String col, String data) {
        String query =
                "UPDATE cbo2002 SET " + col + "=" + data + " WHERE id =" + index;
        try {
            ConnectionPostgres.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletar todo o conteúdo da tabela. Será usado para
     * fins de testes unitários.
     * @throws SQLException
     */
    public void limparTabela() throws SQLException {
        String limpar = "DELETE TABLE grupo2.cbo2002";
        ConnectionPostgres.executeQuery(limpar);
    }
}
