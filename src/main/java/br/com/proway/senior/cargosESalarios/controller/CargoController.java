/**
 * 
 */
package br.com.proway.senior.cargosESalarios.controller;

import java.sql.Connection;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoDaoSQL;
import br.com.proway.senior.cargosESalarios.model.NivelDaoSQL;

/**
 * @author davihildebran@gmail.com, sabrina.schimidt@senior.com.br
 * @version Sprint 4 
 */
public class CargoController {	
	
	// TODO criar tr�s controllers, um pra cargo, um pra setor e um pra Posto de trabalho
	// e usar o exemplo abaixo nos controllers.
	/*
	criarCargo(String nome, String nivel){

		NivelDaoSQL daoNivel = new NivelDaoSQL(conexao);
		int idNivel = daoNivel.create(nivel);
		CargoDao daoCargo = new CargoDao(conexao);
		daoCargo.create(nome, idNilvel)
	}
	*/
	public void conectarPostgres() {
		ConnectionPostgres ps = new ConnectionPostgres();
		Connection conexao = ps.conectar();
		NivelDaoSQL daoNivel = new NivelDaoSQL(conexao);
		GrauInstrucaoDaoSQL daoGrauInstrucao = new GrauInstrucaoDaoSQL(conexao);
	}

	
}
