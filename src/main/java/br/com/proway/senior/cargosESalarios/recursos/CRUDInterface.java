package br.com.proway.senior.cargosESalarios.recursos;

import java.util.ArrayList;

/**
 * Interface para implementação de CRUD nas classes DAO do sistema.
 * Contém os métodos Create, Retrive, Update, Delete e getAll.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi 
 * @param <T> Generics, utilize uma classe de entidade.
 */
public interface CRUDInterface<T> {

	public void Create(T obj);

	public T Retrieve(int  id);

	public void Update(T obj);

	public void Delete(int id);
	
	public ArrayList<T> getAll();

}
