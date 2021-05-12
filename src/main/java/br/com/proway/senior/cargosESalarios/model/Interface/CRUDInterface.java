package br.com.proway.senior.cargosESalarios.model.Interface;

import java.util.ArrayList;

/**
 * Interface para implementa��o de CRUD nas classes DAO do sistema.
 * Cont�m os m�todos Create, Retrive, Update, Delete e getAll.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grij�, Samuel Levi 
 * @param <T> Generics, utilize uma classe de entidade.
 * @version Sprint3
 * - Cria��o e implementa��o da classe.
 */
public interface CRUDInterface<T> {

	public Integer create(T obj);

	public T retrieve(int  id);

	public boolean update(T obj);

	public boolean delete(int id);
	
	public ArrayList<T> getAll();

}
