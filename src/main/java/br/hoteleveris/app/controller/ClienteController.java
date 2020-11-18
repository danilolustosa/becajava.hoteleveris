package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.ClienteService;

public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	public ResponseEntity inserir(ClienteRequest request) {
		BaseResponse response = service.inserir(request);
		return ResponseEntity.status(200).body("Faturas inseridas com sucesso");
	}

}
