package br.com.proway.senior.cargosESalarios.model;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/***
 * CargoDaoSQL
 * Classe DAO que implementa a InterfaceDaoCrud, com os métodos
 * necessários para a interação com o banco de dados.
 * @author Samuel Levi <samuel.levi@senior.com.br>
 */
public class CargoDaoSql implements InterfaceDaoCrud<CargoModel>{
    ConnectionPostgres con = new ConnectionPostgres();

    /***
     *
     * @param obj CargoModel
     * @return ca
     */
    public int create(CargoModel obj) {
        String insertDB = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo_2002, cbo_94, hora_mes, grau_instrucao, experiencia_minima, atribuicoes, status, id_permissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int qtd = 0;
        try {
            PreparedStatement prepStmt = con.conectar().prepareStatement(insertDB);
            prepStmt.setString(1, obj.getNomeCargo());
            prepStmt.setDate(2, obj.getDataCadastro());
            prepStmt.setDate(3, obj.getDataUltimaRevisao());
            prepStmt.setInt(4, obj.getCbo2002());
            prepStmt.setInt(5, obj.getCbo94());
            prepStmt.setInt(6, obj.getHoraMes());
            prepStmt.setInt(7, obj.getGrauInstrucao());
            prepStmt.setString(8, obj.getExperienciaMinima());
            prepStmt.setString(9, obj.getAtribuicoes());
            prepStmt.setBoolean(10, obj.getStatus());
            prepStmt.setInt(11, obj.getIdPermissao());
            prepStmt.execute();
            String sqlCount = "SELECT COUNT(*) FROM grupo2.cargo";
            ResultSet rs = con.executeQuery(sqlCount);
            rs.next();
            qtd = rs.getInt(1);
            System.out.println("Cargo cadastrado com sucesso.");
            return qtd;
        } catch (SQLException e) {
            System.out.println("Falha ao cadastrar Cargo");
            e.printStackTrace();
        }
        return qtd;
    }

    /***
     * Recuperar um cargo pelo ID do cargo.
     * Realiza uma busca no banco de dados pelo ID informado
     * e retorna a tupla com os dados correspondentes.
     * @param idCargo int
     * @return cargo CargoModel
     */
    public CargoModel retrieve(int idCargo) {
        String retrieveById = "SELECT * FROM grupo2.cargo WHERE id_cargo = " + idCargo;
        try {
            Statement stmt = con.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(retrieveById);
            CargoModel cargo = new CargoModel();
            while (rs.next()) {
                cargo.setIdCargo(rs.getInt(1));
                cargo.setNomeCargo(rs.getString(2));
                cargo.setDataCadastro(rs.getDate(3));
                cargo.setDataUltimaRevisao(rs.getDate(4));
                cargo.setCbo2002(rs.getInt(5));
                cargo.setCbo94(rs.getInt(6));
                cargo.setHoraMes(rs.getInt(7));
                cargo.setGrauInstrucao(rs.getInt(8));
                cargo.setExperienciaMinima(rs.getString(9));
                cargo.setAtribuicoes(rs.getString(10));
                cargo.setStatus(rs.getBoolean(11));
                cargo.setIdPermissao(rs.getInt(12));
                System.out.println(cargo.toString());
            }
            return cargo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean update(int idCargo, CargoModel obj) {
        String updateDB = "UPDATE grupo2.cargo SET nome_cargo = ?, data_cadastro = ?,"
                + "data_ultima_revisao = ?, cbo2002 = ?, cbo94 = ?, hora_mes = ?," +
                "grau_instrucao = ?, experiencia_minima = ?, atribuicoes = ?, status = ?, id_permissao = ? WHERE id_posto = " + idCargo;
        PreparedStatement prepStmt;
        try {
            prepStmt = con.conectar().prepareStatement(updateDB);
            prepStmt.setString(1, obj.getNomeCargo());
            prepStmt.setDate(2, obj.getDataCadastro());
            prepStmt.setDate(3, obj.getDataUltimaRevisao());
            prepStmt.setInt(4, obj.getCbo2002());
            prepStmt.setInt(5, obj.getCbo94());
            prepStmt.setInt(6, obj.getHoraMes());
            prepStmt.setInt(7, obj.getGrauInstrucao());
            prepStmt.setString(8, obj.getExperienciaMinima());
            prepStmt.setString(9, obj.getAtribuicoes());
            prepStmt.setBoolean(10, obj.getStatus());
            prepStmt.setInt(11, obj.getIdPermissao());
            prepStmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /***
     * Deletar um registro da tabela.
     * Busca no banco o registro cujo ID seja igual ao informado
     * no parâmetro e exclui a tupla.
     * @param idCargo Int
     * @return boolean True se o registro for apagado e False em
     * caso de falha.
     */
    public boolean delete(int idCargo) {
        String deleteDB = "DELETE FROM grupo2.cargo WHERE id_cargo = " + idCargo;
        try {
            Statement stmt = con.conectar().createStatement();
            stmt.execute(deleteDB);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<CargoModel> getAll() {
        return null;
    }
}
