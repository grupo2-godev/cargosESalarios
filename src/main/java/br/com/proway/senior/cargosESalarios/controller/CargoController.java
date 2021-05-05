/**
 * 
 */
package br.com.proway.senior.cargosESalarios.controller;

import java.sql.Connection;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoDao;
import br.com.proway.senior.cargosESalarios.model.NivelDao;

/**
 * @author davihildebran@gmail.com, sabrina.schimidt@senior.com.br
 * @version Sprint 4 
 */
public class CargoController {	
	
	// TODO criar três controllers, um pra cargo, um pra setor e um pra Posto de trabalho
	// e usar o exemplo abaixo nos controllers.
	/*
	criarCargo(String nome, String nivel){

		NivelDao daoNivel = new NivelDao(conexao);
		int idNivel = daoNivel.create(nivel);
		CargoDao daoCargo = new CargoDao(conexao);
		daoCargo.create(nome, idNilvel)
	}
	*/
	public void conectarPostgres() {
		ConnectionPostgres ps = new ConnectionPostgres();
		Connection conexao = ps.conectar();
		NivelDao daoNivel = new NivelDao(conexao);
		GrauInstrucaoDao daoGrauInstrucao = new GrauInstrucaoDao(conexao);
	}

	
}
