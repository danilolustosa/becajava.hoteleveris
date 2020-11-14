package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.request.TransferenciaRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class FaturaService {
	
	private String hashContaHotel = "123456";

	public BaseResponse inserir() {

		RestTemplate restTemplate = new RestTemplate();

		final String uri = "http://localhost:8081/operacao/transferencia";

		TransferenciaRequest transferencia = new TransferenciaRequest();
		transferencia.setHashDestino(hashContaHotel);
		transferencia.setHashOrigem("987654");
		transferencia.setValor(123);

		BaseResponse response = restTemplate.postForObject(uri, transferencia, BaseResponse.class);
		
		return response;
	}

}
