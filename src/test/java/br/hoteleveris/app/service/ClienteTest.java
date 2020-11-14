package br.hoteleveris.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.hoteleveris.app.request.ClienteRequest;

@WebAppConfiguration
public abstract class ClienteTest {

	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void createProduct() throws Exception {
		String uri = "/cliente";
		ClienteRequest request = new ClienteRequest();
		request.setCpf("123456");
		request.setHash("1234567890");
		request.setNome("Nome do cliente");

		String inputJson = this.mapToJson(request);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertThat(status).isEqualTo(201);
		// assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertThat(content).isEqualTo("Product is created successfully");
		// assertEquals(content, "Product is created successfully");
	}

//	@InjectMocks
//	ClienteService service;
//	
//	@Mock
//    ClienteRepository clienteRepository;

//	@Test
//	void inserirNovoCliente()   {
//		ClienteRequest request = new ClienteRequest();				
//		request.setCpf("123456");
//		request.setHash("1234567890");
//		request.setNome("Nome do cliente");
//		
//		Cliente cliente = new Cliente();
//		cliente.setCpf("123456");
//		cliente.setHash("1234567890");
//		cliente.setNome("Nome do cliente");
//		
////		Mockito.when(clienteRepository.save(Mockito.any(Cliente.class)))
////			.then(i -> i.getArguments()[0]);
//
//		BaseResponse base = service.inserir(request);
//		
//		verify(clienteRepository, times(1)).save(cliente);
//
//        assertThat(base.getStatusCode()).isEqualTo(201);
//	}

//	@Test
//	void inserirNovoClienteSemNome()   {
//		ClienteRequest request = new ClienteRequest();				
//		request.setCpf("123456");
//		request.setHash("1234567890");
//		request.setNome("");
//		
//		Mockito.when(clienteRepository.save(Mockito.any(Cliente.class)))
//			.then(i -> i.getArguments()[0]);
//
//		BaseResponse base = service.inserir(request);
//
//        assertThat(base.getStatusCode()).isEqualTo(400);
//	}
}
