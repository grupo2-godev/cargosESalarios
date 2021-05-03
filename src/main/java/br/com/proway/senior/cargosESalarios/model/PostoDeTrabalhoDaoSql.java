package br.com.proway.senior.cargosESalarios.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Classe PostoDeTrabalhoDaoSql
 * 
 * Classe DAO que implementa a interface CRUDInterface para
 * interação com o banco de dados.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class PostoDeTrabalhoDaoSql {
	
	ConnectionPostgres conexao = new ConnectionPostgres();
	
	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return novoPostoId
	 */
	public int create(PostoDeTrabalhoModel postoModel) {
		String sql1 = "INSERT INTO grupo2.posto_de_trabalho (nome_posto, id_cargo, id_setor, id_nivel, salario) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql1);
			pstmt.setString(1, postoModel.getNomePosto());
			pstmt.setInt(2, postoModel.getIdCargo());
			pstmt.setInt(3, postoModel.getIdSetor());
			pstmt.setInt(4, postoModel.getIdNivel());
			pstmt.setDouble(5, postoModel.getSalario());
			pstmt.execute();
			System.out.println("Posto de Trabalho cadastrado com sucesso.");
			
		} catch (SQLException e) {
			System.out.println("Falha ao cadastrar Posto de Trabalho");
			e.printStackTrace();
		}
		return 0;
	}
	
	public void limparTabela() throws SQLException {
		String limpar = "TRUNCATE TABLE grupo2.posto_de_trabalho";
		conexao.executeQuery(limpar);	
	}

}
