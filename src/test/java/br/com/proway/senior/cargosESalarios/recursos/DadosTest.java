package br.com.proway.senior.cargosESalarios.recursos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.Cargo;
import br.com.proway.senior.cargosESalarios.model.Dados;
import br.com.proway.senior.cargosESalarios.model.Setor;

/**
 * Classe de testes do Dados.
 * @author Ricardo Oliveira, Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi
 * @version Sprint3:
 *  - Implementação dos testes.
 */
public class DadosTest {

	@Test
	public void testeGetListaSetores() {
		Setor setor = new Setor(45, "RH", 23124);
		int tamanhoInicial = Dados.getInstance().getListaSetores().size();
		Dados.getInstance().getListaSetores().add(setor);
		ArrayList<Setor> lista = Dados.getInstance().getListaSetores();
		assertEquals(tamanhoInicial + 1, lista.size());
	}
	
	@Test
	public void testeGetListaCargos() {
		Cargo cargo = new Cargo(0, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
		"5842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", true, 1, 40.0);
		int tamanhoInicial = Dados.getInstance().getListaCargos().size();
		Dados.getInstance().getListaCargos().add(cargo);
		ArrayList<Cargo> listaCargo = Dados.getInstance().getListaCargos();
		assertEquals(tamanhoInicial + 1,listaCargo.size());
	}

}

