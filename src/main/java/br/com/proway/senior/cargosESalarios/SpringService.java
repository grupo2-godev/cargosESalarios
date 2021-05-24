package br.com.proway.senior.cargosESalarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.API.CargoControllerAPI;
import br.com.proway.senior.cargosESalarios.controller.API.PostoDeTrabalhoControllerAPI;
import br.com.proway.senior.cargosESalarios.model.DTO.CargoModelDTO;
import br.com.proway.senior.cargosESalarios.model.DTO.PostoDeTrabalhoModelDTO;
@RestController
@SpringBootApplication
public class SpringService {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringService.class, args);
	}

	@GetMapping("/cargo")
	public CargoModelDTO getCargo(@RequestParam(value = "id") int id) {
		CargoControllerAPI api = new CargoControllerAPI();
		return api.buscarPorID(id);
	}
	
	@GetMapping("/posto")
	public PostoDeTrabalhoModelDTO getPosto(@RequestParam(value = "id") int id) {
		PostoDeTrabalhoControllerAPI api = new PostoDeTrabalhoControllerAPI();
		return api.buscarPorId(id);
	}
}