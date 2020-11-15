package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ComodidadeTest {
	
	@Autowired
	private ComodidadeService service;
	
	@Test
	void inserir() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("Piscina");
		
		BaseResponse response = service.inserir(request);
		
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Comodidade inserida com sucesso", response.getMessage());
	}
	
	@Test
	void inserirSemNome() {
		ComodidadeRequest request = new ComodidadeRequest();
		//request.setNome("Piscina");
		
		BaseResponse response = service.inserir(request);
		
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Preencha o nome da comodidade", response.getMessage());
	}

}
