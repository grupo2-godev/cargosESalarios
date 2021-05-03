package br.com.proway.senior.cargosESalarios.recursos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Dados;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Classe de testes do Dados.
 * @author Ricardo Oliveira, Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi
 * @version Sprint3:
 *  - Implementação dos testes.
 */
public class DadosTest {

	@Test
	public void testeGetListaSetores() {
		SetorModel setor = new SetorModel("RH", 23124);
		int tamanhoInicial = Dados.getInstance().getListaSetores().size();
		Dados.getInstance().getListaSetores().add(setor);
		ArrayList<SetorModel> lista = Dados.getInstance().getListaSetores();
		assertEquals(tamanhoInicial + 1, lista.size());
	}
	
	@Test
	public void testeGetListaCargos() {
		CargoModel cargo = new CargoModel();
		int tamanhoInicial = Dados.getInstance().getListaCargos().size();
		Dados.getInstance().getListaCargos().add(cargo);
		ArrayList<CargoModel> listaCargo = Dados.getInstance().getListaCargos();
		assertEquals(tamanhoInicial + 1,listaCargo.size());
	}

}

