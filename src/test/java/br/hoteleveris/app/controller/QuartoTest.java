package br.hoteleveris.app.controller;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.QuartoService;

@SpringBootTest
public class QuartoTest {


    @Autowired
    private QuartoService service;
    
    @Test
    void inserir() throws Exception {
        QuartoRequest request = new QuartoRequest();
        request.setAndar(1);
        int noQuarto = this.getRandomNumberUsingInts(1,1000);
        request.setNoQuarto(noQuarto);
        request.setSituacao("A");
        request.setTipoQuartoId(new Long(1));

        BaseResponse response = service.inserir(request);
        
        Assertions.assertEquals(response.getStatusCode(), 201);
        Assertions.assertEquals(response.getMessage(), "Quarto inserido com sucesso");
    }

    @Test
    void inserirSemNumeroQuarto() throws Exception {
        QuartoRequest request = new QuartoRequest();
        request.setAndar(13);
        //request.setNoQuarto(1301);
        request.setSituacao("A");
        request.setTipoQuartoId(new Long(1));

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(response.getStatusCode(), 400);
        Assertions.assertEquals(response.getMessage(), "Preencha o número do quarto");
    }
    
    
    public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
          .findFirst()
          .getAsInt();
    }

}
