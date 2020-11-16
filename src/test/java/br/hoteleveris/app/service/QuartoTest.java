package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

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
        
        Assertions.assertEquals(201, response.getStatusCode());
        Assertions.assertEquals("Quarto inserido com sucesso", response.getMessage());
    }
    
    @Test
    void inserirComComodidades() throws Exception {
        QuartoRequest request = new QuartoRequest();
        request.setAndar(1);
        int noQuarto = this.getRandomNumberUsingInts(1,1000);
        request.setNoQuarto(noQuarto);
        request.setSituacao("A");
        request.setTipoQuartoId(new Long(1));
        
        List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>(); 
        
        ComodidadeRequest comodidade = new ComodidadeRequest();
        comodidade.setId(new Long(1));
        comodidades.add(comodidade);
        
        comodidade = new ComodidadeRequest();
        comodidade.setId(new Long(3));
        comodidades.add(comodidade);    
        
        request.setComodidades(comodidades);
        

        BaseResponse response = service.inserir(request);
        
        Assertions.assertEquals(201, response.getStatusCode());
        Assertions.assertEquals("Quarto inserido com sucesso", response.getMessage());
    }

    @Test
    void inserirSemNumeroQuarto() throws Exception {
        QuartoRequest request = new QuartoRequest();
        request.setAndar(13);
        //request.setNoQuarto(1301);
        request.setSituacao("A");
        request.setTipoQuartoId(new Long(1));

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(400, response.getStatusCode());
        Assertions.assertEquals("Preencha o número do quarto", response.getMessage());
    }
    
    @Test
    void inserirSemAndar() throws Exception {
        QuartoRequest request = new QuartoRequest();
        //request.setAndar(13);
        request.setNoQuarto(1301);
        request.setSituacao("A");
        request.setTipoQuartoId(new Long(1));

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(400, response.getStatusCode());
        Assertions.assertEquals("Preencha o andar", response.getMessage());
    }
    
    @Test
    void inserirSemSituacao() throws Exception {
        QuartoRequest request = new QuartoRequest();
        request.setAndar(13);
        int noQuarto = this.getRandomNumberUsingInts(1,1000);
        request.setNoQuarto(noQuarto);
        //request.setSituacao("A");
        request.setTipoQuartoId(new Long(1));

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(400, response.getStatusCode());
        Assertions.assertEquals("Preencha a situação", response.getMessage());
    }
    
    
    public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
          .findFirst()
          .getAsInt();
    }

}
