package br.hoteleveris.app.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public BaseResponse inserir(ClienteRequest request) { 
		Cliente cliente = new Cliente();
		
		if (request.getCpf() == "" || request.getCpf() == null)
			return new BaseResponse(400,"O CPF precisa ser preenchido");
		
		if (request.getHash() == "" || request.getHash() == null) 
			return new BaseResponse(400,"O hash precisa ser preenchido");
		
		if (request.getNome() == "" || request.getNome() == null) 
			return new BaseResponse(400,"O nome do cliente precisa ser preenchido");
		
		cliente.setCpf(request.getCpf());
		cliente.setHash(request.getHash());
		cliente.setNome(request.getNome());
		
		repository.save(cliente);		
		return new BaseResponse(201,"Cliente inserido com sucesso");
	}
}
