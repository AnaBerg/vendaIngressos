package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DAO.EventoDAO;

public class Evento {

    private int id;
    private String nome;
    private String local;
    private String atracao;
    private int lotacao;
    private Date data;
    private int ingressosDisponiveis;
    private int contaOrganizadorId;
    private final EventoDAO dao;

    public Evento(){
    	this.dao = new EventoDAO();
    }
    
    public Evento(int id, String nome, String local, String atracao, int lotacao, Date data, int contaOrganizadorId) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.atracao = atracao;
        this.lotacao = lotacao;
        this.data = data;
        this.ingressosDisponiveis = lotacao;
        this.contaOrganizadorId = contaOrganizadorId;
        this.dao = new EventoDAO();
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAtracao() {
        return atracao;
    }

    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public int getContaOrganizadorId() {
        return contaOrganizadorId;
    }

    public void setContaOrganizadorId(int conta_organizador_id) {
        this.contaOrganizadorId = conta_organizador_id;
    }
    
    

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

	public void setIngressosDisponiveis(int ingressosDisponiveis) {
		this.ingressosDisponiveis = ingressosDisponiveis;
	}
	
	public boolean criaEvento(Evento evento) {
		if(validaOrganizador(evento.contaOrganizadorId)) {
			dao.InsertEventoBD(evento);
			return true;
		}
		return false;
	}
	
	public boolean editaEvento(Evento evento) {
		if(validaOrganizador(evento.contaOrganizadorId)) {
			dao.UpdateEventoBD(evento);
			return true;
		}
		return false;
	}
	
	public boolean deletaEvento(int id) {
		dao.DeleteEventoBD(id);
		return true;
	}
	
        // Lista de Eventos do Organizador
	public ArrayList<Evento> ListaEventosOrganizador(int id) {
		return dao.getListaEventoColaborador(id);
	}
        
        // Lista de Eventos para o Comprador
    public ArrayList<Evento> ListaEventos() {
		return dao.getListaEvento();
	}
	
	public int maiorId() throws SQLException {
		return dao.maiorID();
	}
	
	private boolean validaOrganizador(int id) {
		ContaOrganizador obj = new ContaOrganizador();
		if(obj.buscaOrganizador()) {
			return true;
		}
		return false;
	}
}
