package br.com.proway.senior.cargosESalarios.recursos;

import java.util.ArrayList;

public interface CRUDInterface<T> {

	public void Create(T obj);

	public T Retrieve(String key);

	public void Update(T obj);

	public void Delete(String key);
	
	public ArrayList<T> getAll();

}
