package br.com.proway.senior.cargosESalarios.model;

public class DaoFactory<T> implements IFactory<T>{
	
	Object Dao;
	CRUDInteface dao = 
	
	public void definirTipo(T obj) {
		
		if(obj.equals(Dao)) {
			Dao dao = new Dao();
			construir(dao);
		}
	}
	
	private Dao construir(Dao dao) {
		return dao;
	}
	
}
