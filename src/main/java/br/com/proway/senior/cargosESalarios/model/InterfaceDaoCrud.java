package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * Interface para implementação de CRUD nas classes DAO do sistema,
 * vinculando ao Banco de Dados. Contém os métodos Create, Retrive, 
 * Update, Delete e getAll.
 * @author Sprint 4
 */

public interface InterfaceDaoCrud<T> {
	
		public int create(T obj);

		public T retrieve(int id);

		public boolean update(int id, T obj);

		public boolean delete(int id);
		
		public ArrayList<T> getAll();

	}


