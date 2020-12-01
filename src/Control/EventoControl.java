package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Model.Evento;

public class EventoControl {
	
	private final Evento evento;
	
	public EventoControl() {
		this.evento = new Evento();
	}
	
	public boolean Cadastrar(String nome, String local, String atracao, int lotacao, Date data, int contaOrganizadorId) throws SQLException {
		int id = evento.maiorId() + 1;
		Evento eventoObjeto = new Evento(id, nome, local, atracao, lotacao, data, contaOrganizadorId);
		if(evento.criaEvento(eventoObjeto)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Editar(Integer id, String nome, String local, String atracao, int lotacao, Date data, int contaOrganizadorId) {
		Evento eventoObjeto = new Evento(id, nome, local, atracao, lotacao, data, contaOrganizadorId);
		if(evento.editaEvento(eventoObjeto)) { 
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Apagar(int id) {
		if(evento.deletaEvento(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Evento> ListaEventos() {
		return evento.ListaEventos();
	}
	
	public ArrayList<Evento> ListaEventosDoColaborador(int id) {
		return evento.ListaEventosOrganizador(id);
	}

}
