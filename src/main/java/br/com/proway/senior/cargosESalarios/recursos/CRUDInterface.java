package br.com.proway.senior.cargosESalarios.recursos;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.Cargo.Cargo;

public interface CRUDInterface<T> {

	public void Create(T obj);

	public T Retrieve(int id);

	public void Update(T obj);

	public void Delete(int id);
	
	public ArrayList<T> getAll();

}
