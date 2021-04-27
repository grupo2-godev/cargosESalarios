package br.com.proway.senior.cargosESalarios.recursos;

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

	public void create(T obj);

	public T retrieve(int  id);

	public void update(T obj);

	public void delete(int id);
	
	public ArrayList<T> getAll();

}
