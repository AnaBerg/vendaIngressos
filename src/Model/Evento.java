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
    private final EventoDAO dao;

    public Evento(){
    	this.dao = new EventoDAO();
    }
    
    public Evento(int id, String nome, String local, String atracao, int lotacao, Date data) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.atracao = atracao;
        this.lotacao = lotacao;
        this.data = data;
        this.ingressosDisponiveis = lotacao;
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
	
	public ArrayList<Evento> ListaEventos() {
		return dao.getListaEvento();
	}
	
	public int maiorId() throws SQLException {
		return dao.maiorID();
	}
}
