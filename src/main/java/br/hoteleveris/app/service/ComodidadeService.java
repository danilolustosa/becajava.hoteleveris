package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class ComodidadeService {
	
	@Autowired
	private ComodidadeRepository repository;
	
	public BaseResponse inserir(ComodidadeRequest request) {
		
		if (request.getNome() == "" || request.getNome() == null)
			return new BaseResponse(400, "Preencha o nome da comodidade");
		
		return new BaseResponse(201, "Comodidade inserida com sucesso");
	}

}
