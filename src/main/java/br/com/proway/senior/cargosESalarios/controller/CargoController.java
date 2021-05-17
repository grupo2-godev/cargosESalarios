/**
 * 
 */
package br.com.proway.senior.cargosESalarios.controller;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;

/**
 * Controller que interage com o CargoDAO.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class CargoController {	
	
	CargoDAO cargoDAO = CargoDAO.getInstance(ConnectionHibernate.getSession());

	
}
