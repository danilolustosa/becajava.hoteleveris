package br.hoteleveris.app.request;

import java.util.List;

public class QuartoRequest {

	private int noQuarto;
	private int andar;
	private String situacao;
	private Long tipoQuartoId;
	
	private List<ComodidadeRequest> comodidades;
	
	
	public List<ComodidadeRequest> getComodidades() {
		return comodidades;
	}
	public void setComodidades(List<ComodidadeRequest> comodidades) {
		this.comodidades = comodidades;
	}
	public Long getTipoQuartoId() {
		return tipoQuartoId;
	}
	public void setTipoQuartoId(Long tipoQuartoId) {
		this.tipoQuartoId = tipoQuartoId;
	}
	public int getNoQuarto() {
		return noQuarto;
	}
	public void setNoQuarto(int noQuarto) {
		this.noQuarto = noQuarto;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
}
