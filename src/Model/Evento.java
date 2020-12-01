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
    private int conta_organizador_id;
    private final EventoDAO dao;

    public Evento(){
    	this.dao = new EventoDAO();
    }
    
    public Evento(int id, String nome, String local, String atracao, int lotacao, Date data, int ingressosDisponiveis, int conta_organizador_id) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.atracao = atracao;
        this.lotacao = lotacao;
        this.data = data;
        this.ingressosDisponiveis = ingressosDisponiveis;
        this.conta_organizador_id = conta_organizador_id;
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

    public int getConta_organizador_id() {
        return conta_organizador_id;
    }

    public void setConta_organizador_id(int conta_organizador_id) {
        this.conta_organizador_id = conta_organizador_id;
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
		dao.InsertEventoBD(evento);
		return true;
	}
	
	public boolean editaEvento(Evento evento) {
		dao.UpdateEventoBD(evento);
		return true;
	}
	
	public boolean deletaEvento(int id) {
		dao.DeleteEventoBD(id);
		return true;
	}
	
        // Lista de Eventos do Organizador
	public ArrayList<Evento> ListaEventosOrganizador() {
		return dao.getListaEvento(this.conta_organizador_id);
	}
        
        // Lista de Eventos para o Comprador
        public ArrayList<Evento> ListaEventos() {
		return dao.getListaEvento();
	}
	
	public int maiorId() throws SQLException {
		return dao.maiorID();
	}
}
