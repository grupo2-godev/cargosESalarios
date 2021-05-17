package br.com.proway.senior.cargosESalarios.model.Interface;

import java.util.ArrayList;

/**
 * Interface para implementacao de CRUD nas classes DAO do sistema,
 * vinculando ao Banco de Dados. Contem os metodos Criar, Buscar, Atualizar, 
 * Deletar, BuscarTodos e DeletarTodos.
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i>
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 *
 */

public interface InterfaceDAOCRUD<T> {
	
		public int criar(T obj);

		public T buscar(int id);

		public boolean atualizar(int id, T obj);

		public boolean deletar(int id);
		
		public ArrayList<T> buscarTodos();
		
		public boolean deletarTodos();

	}


