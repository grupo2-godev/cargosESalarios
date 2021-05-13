package br.com.proway.senior.cargosESalarios.model.Interface;

import java.util.ArrayList;

/**
 * Interface para implementa��o de CRUD nas classes DAO do sistema,
 * vinculando ao Banco de Dados. Cont�m os m�todos Create, Retrive, 
 * Update, Delete e getAll.
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i>
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 *
 */

public interface InterfaceDAOCRUD<T> {
	
		public int create(T obj);

		public T retrieve(int id);

		public boolean update(int id, T obj);

		public boolean delete(int id);
		
		public ArrayList<T> getAll();
		
		public boolean deleteAll();

	}


