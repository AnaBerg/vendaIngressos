package model;

import java.util.Date;

public class Evento {

    private int id;
    private String nome;
    private String local;
    private String atracao;
    private int lotacao;
    private Date data;
    public int ingressosDisponiveis;

    public Evento(int id, String nome, String local, String atracao, int lotacao, Date data) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.atracao = atracao;
        this.lotacao = lotacao;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
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

    public int getId() {
        return id;
    }
}
