package Model;

import DAO.EventoDAO;

public class Compra {
	
	private int id;
	private int quantidadeIngressos;
	private int contaClienteId;
	private int eventoId;
	private CompraDAO dao;
	
	public Compra() {
		this.dao = new CompraDAO();
	}
	
	public Compra(int id, int quantidadeIngressos, int contaClienteId, int eventoId) {
		this.id = id;
		this.quantidadeIngressos = quantidadeIngressos;
		this.contaClienteId = contaClienteId;
		this.eventoId = eventoId;
		this.dao = new CompraDAO();
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
	
	public boolean realizarCompra(){
		if(this.quantidadeIngressos <= evento.getIngressosDisponiveis()) {
			Evento evento = dao.buscarEvento(this.eventoId);
			int ingressosDisponiveis = evento.getIngressosDisponiveis() - this.quantidadeIngressos;
			evento.setIngressosDisponiveis(ingressosDisponiveis);
			dao.UpdateEventoBD(evento);
			return true;
		} else {
			return false;
		}
    }
}
