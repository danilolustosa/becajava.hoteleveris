package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class TipoQuartoService {
	
	@Autowired
	private TipoQuartoRepository repository;
	
	public BaseResponse inserir(TipoQuartoRequest request) {		
		if (request.getDescricao() == null || request.getDescricao().isEmpty())
			return new BaseResponse(400,"Preencha a descrição");
		
		if (request.getValor() == 0)
			return new BaseResponse(400,"Preencha o valor");
		
		TipoQuarto tipoQuarto = new TipoQuarto(
				request.getDescricao(),
				request.getValor()
				);
		
		repository.save(tipoQuarto);
		
		
		return new BaseResponse(201,"Tipo de quarto criado com sucesso");
	}

}
