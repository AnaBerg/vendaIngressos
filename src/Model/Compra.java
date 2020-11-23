package model;

public class Compra {
	
	private int id;
	private int quantidadeIngressos;
	private int contaClienteId;
	private int eventoId;
	
	public Compra(int id, int quantidadeIngressos, int contaClienteId, int eventoId) {
		this.id = id;
		this.quantidadeIngressos = quantidadeIngressos;
		this.contaClienteId = contaClienteId;
		this.eventoId = eventoId;
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public int getContaClienteId() {
		return contaClienteId;
	}

	public void setContaClienteId(int contaClienteId) {
		this.contaClienteId = contaClienteId;
	}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}

	public int getId() {
		return id;
	}
}
