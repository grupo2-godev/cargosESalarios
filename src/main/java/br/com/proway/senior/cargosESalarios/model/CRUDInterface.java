package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * Interface para implementação de CRUD nas classes DAO do sistema.
 * Contém os métodos Create, Retrive, Update, Delete e getAll.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi 
 * @param <T> Generics, utilize uma classe de entidade.
 * @version Sprint3
 * - Criação e implementação da classe.
 */
public interface CRUDInterface<T> {

	public boolean create(T obj);

	public T retrieve(int  id);

	public boolean update(T obj);

	public boolean delete(int id);
	
	public ArrayList<T> getAll();

}
