package br.com.proway.senior.cargosESalarios.Cargo;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

public class CargoDaoAl implements CRUDInterface<Cargo> {
	
	public void Create(Cargo obj) {
		Dados.getInstance().getListaCargos().add(obj);
	}

	public Cargo Retrieve(String key) {
		return Dados.getInstance().getListaCargos().get(Integer.parseInt(key));
	}

	public void Update(Cargo obj) {
		
	}

	public void Delete(String key) {
		
	}
	
	public ArrayList<Cargo> getAll(){
		return null;
	}
	
	
}
