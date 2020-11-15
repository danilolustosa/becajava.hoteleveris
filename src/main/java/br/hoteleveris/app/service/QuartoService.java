package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.QuartoComodidade;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoComodidadeRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class QuartoService {
	
	@Autowired
	private QuartoRepository repository;	
	
	@Autowired
	private QuartoComodidadeRepository quartoComodidadeRepository; 
	
	public BaseResponse inserir(QuartoRequest request) {		
		if (request.getAndar() <= 0)
			return new BaseResponse(400, "Preencha o andar");
		
		if (request.getNoQuarto() <= 0)
			return new BaseResponse(400, "Preencha o número do quarto");
		
		var checkNoQuarto = repository.findByNoQuarto(request.getNoQuarto());
		
		if (!checkNoQuarto.isEmpty()) 
			return new BaseResponse(400, "O número do quarto já existe");
		
		if (request.getSituacao() == "" || request.getSituacao() == null)
			return new BaseResponse(400, "Preencha a situação");		
		
		TipoQuarto tipoQuarto = new TipoQuarto(request.getTipoQuartoId());	

		Quarto quarto = new Quarto(
					request.getNoQuarto(),
					request.getAndar(),
					request.getSituacao(),
					tipoQuarto
				);	
		
		repository.save(quarto);
		
		Long idQuarto = repository.findByNoQuarto(request.getNoQuarto()).get().getId();;
		
		if (request.getComodidades() != null && request.getComodidades().size() > 0) {
			for(ComodidadeRequest item : request.getComodidades()) {			
				QuartoComodidade quartoComodidade = new QuartoComodidade(
						new Quarto(idQuarto),
						new Comodidade(item.getId())
						);			
				
				quartoComodidadeRepository.save(quartoComodidade);
			}			
		}
		
		return new BaseResponse(201,"Quarto inserido com sucesso");		
	}

}
