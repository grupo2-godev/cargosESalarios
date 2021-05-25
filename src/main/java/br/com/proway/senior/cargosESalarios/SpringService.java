package br.com.proway.senior.cargosESalarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringService {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringService.class, args);
	}


	
//	@GetMapping("/posto")
//	public PostoDeTrabalhoModelDTO getPosto(@RequestParam(value = "id") int id) {
//		PostoDeTrabalhoControllerAPI api = new PostoDeTrabalhoControllerAPI();
//		return api.buscarPorID(id);
//	}

}