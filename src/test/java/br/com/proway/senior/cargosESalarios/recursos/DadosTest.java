package br.com.proway.senior.cargosESalarios.recursos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.Cargo.Cargo;
import br.com.proway.senior.cargosESalarios.Setor.Setor;

/**
 * Classe de testes do Dados.
 * @author Ricardo Oliveira, Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grij?, Samuel Levi
 * @version Sprint3:
 *  - Implementa??o dos testes.
 */
public class DadosTest {

	@Test
	public void testeGetListaSetores() {
		Setor setor = new Setor(45, "RH", 85, 23124);
		int tamanhoInicial = Dados.getInstance().getListaSetores().size();
		Dados.getInstance().getListaSetores().add(setor);
		ArrayList<Setor> lista = Dados.getInstance().getListaSetores();
		assertEquals(tamanhoInicial + 1, lista.size());
	}
	
	@Test
	public void testeGetListaCargos() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		int tamanhoInicial = Dados.getInstance().getListaCargos().size();
		Dados.getInstance().getListaCargos().add(cargo);
		ArrayList<Cargo> listaCargo = Dados.getInstance().getListaCargos();
		assertEquals(tamanhoInicial + 1,listaCargo.size());
	}

}

