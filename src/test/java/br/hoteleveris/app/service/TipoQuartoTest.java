package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.implement.TipoQuartoService;

@SpringBootTest
public class TipoQuartoTest {
	
	@Autowired
	private TipoQuartoService service;
	
	@Test
	void inserir() throws Exception {		
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Simples");
		request.setValor(50);		
		
		BaseResponse response = service.inserir(request);
		
		Assertions.assertEquals(201, response.getStatusCode());		
	}

	@Test
	void inserirSemDescricao() throws Exception {		
		TipoQuartoRequest request = new TipoQuartoRequest();
		//request.setDescricao("Simples");
		request.setValor(50);		
		
		BaseResponse response = service.inserir(request);
		
		Assertions.assertEquals(400, response.getStatusCode());		
	}	
	
	@Test
	void inserirSemValor() throws Exception {		
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Simples");
		//request.setValor(50);		
		
		BaseResponse response = service.inserir(request);
		
		Assertions.assertEquals(400, response.getStatusCode());		
	}

}
