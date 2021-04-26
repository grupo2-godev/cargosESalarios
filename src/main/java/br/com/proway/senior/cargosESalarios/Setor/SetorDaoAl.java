package br.com.proway.senior.cargosESalarios.Setor;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

public class SetorDaoAl implements CRUDInterface<Setor> {

	public void Create(Setor obj) {
		Dados.getInstance().getListaSetores().add(obj);
	}

	public Setor Retrieve(String key) {
		return Dados.getInstance().getListaSetores().get(Integer.parseInt(key));
	}

	public void Update(Setor obj) {

	}

	public void Delete(String key) {

	}

	public ArrayList<Setor> getAll() {
		return null;
	}

}
