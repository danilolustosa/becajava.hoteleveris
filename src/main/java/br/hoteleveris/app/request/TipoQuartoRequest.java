package br.hoteleveris.app.request;

public class TipoQuartoRequest {
	
	private Long id;
	private String descricao;
	private double valor;
	
	public TipoQuartoRequest() {
		
	}
	
	public TipoQuartoRequest(Long id) {
		super();
		this.id = id;
	}	
	
	public TipoQuartoRequest(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
