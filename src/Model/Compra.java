package Model;

import DAO.EventoDAO;

public class Compra {
	
	private int id;
	private int quantidadeIngressos;
	private int contaClienteId;
	private int evento_id;
	private final EventoDAO dao;
	
	public Compra() {
		this.dao = new EventoDAO();
	}
	
	public Compra(int id, int quantidadeIngressos, int contaClienteId, int eventoId) {
		this.id = id;
		this.quantidadeIngressos = quantidadeIngressos;
		this.contaClienteId = contaClienteId;
		this.evento_id = eventoId;
		this.dao = new EventoDAO();
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public int getContaClienteId() {
		return conta_cliente_id;
	}

	public void setContaClienteId(int contaClienteId) {
		this.conta_cliente_id = contaClienteId;
	}

	public int getEventoId() {
		return evento_id;
	}

	public void setEventoId(int eventoId) {
		this.evento_id = eventoId;
	}

	public int getId() {
		return id;
	}
	
	public boolean realizarCompra(){
		if(this.quantidadeIngressos <= evento.getIngressosDisponiveis()) {
			Evento evento = dao.buscarEvento(this.evento_id);
			int ingressosDisponiveis = evento.getIngressosDisponiveis() - this.quantidadeIngressos;
			evento.setIngressosDisponiveis(ingressosDisponiveis);
			dao.UpdateEventoBD(evento);
			return true;
		} else {
			return false;
		}
    }
}
