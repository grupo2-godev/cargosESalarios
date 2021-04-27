package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.com.proway.senior.cargosESalarios.Cargo.Cargo;
import br.com.proway.senior.cargosESalarios.Setor.Setor;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

class DadosTest {

	@Test
	void testeGetListaSetores() {
		Setor setor = new Setor(45, "RH", 85, 23124);
		Dados.getInstance().getListaSetores().add(setor);
		ArrayList<Setor> lista = Dados.getInstance().getListaSetores();
		assertEquals(1, lista.size());
	}
	
	@Test
	void testeGetListaCargos() {
		Cargo cargo = new Cargo(1, "Gerente", 4, "Supervisor", 500.40, LocalDateTime.now(), LocalDateTime.now(),
				"842320-32", "21314", 55, "Superior Completo", "12 meses", "Desenvolvedor", "nenhuma", 1, 1);
		Dados.getInstance().getListaCargos().add(cargo);
		ArrayList<Cargo> listaCargo = Dados.getInstance().getListaCargos();
		assertEquals(1,listaCargo.size());
		assertNotNull(listaCargo);
	}

}
