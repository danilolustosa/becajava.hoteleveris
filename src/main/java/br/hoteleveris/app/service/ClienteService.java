package br.hoteleveris.app.service;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

public interface ClienteService {
	 BaseResponse inserir(ClienteRequest request);
}
