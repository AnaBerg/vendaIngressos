package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CompraDAO;

public class Compra {
	
	private int id;
	private int quantidadeIngressos;
	private int contaClienteId;
	private int eventoId;
	private CompraDAO dao;
	private Evento objEvento;
	
	public Compra() {
		this.dao = new CompraDAO();
		this.objEvento = new Evento();
	}
	
	public Compra(int id, int quantidadeIngressos, int contaClienteId, int eventoId) {
		this.id = id;
		this.quantidadeIngressos = quantidadeIngressos;
		this.contaClienteId = contaClienteId;
		this.eventoId = eventoId;
		this.dao = new CompraDAO();
		this.objEvento = new Evento();
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
	
	public boolean realizarCompra(Compra compra){
		Evento evento = objEvento.getEventoById(compra.getEventoId());
		int ingressosComprados = compra.getQuantidadeIngressos();
		if(ingressosComprados <= evento.getIngressosDisponiveis()) {
			int ingressosDisponiveis = evento.getIngressosDisponiveis() - ingressosComprados;
			evento.setIngressosDisponiveis(ingressosDisponiveis);
			evento.editaEvento(evento);
			dao.InsertCompraBD(compra);
			return true;
		} else {
			return false;
		}
    }
	
	public boolean deleteCompra(int id) {
		dao.DeleteCompraBD(id);
		return true;
	}
	
	public ArrayList<Compra> getComprasCliente(int id) {
		return dao.getComprasCliente(id);
	}
	
	public int maiorId() throws SQLException {
		return dao.maiorID();
	}
	
	@Override
	public String toString() {
		String nomeEvetoString = objEvento.getNome();
		return "Evento: " + nomeEvetoString + "\nQuantidade Ingressos: " + this.quantidadeIngressos;
	}
}
