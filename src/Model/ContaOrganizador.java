package model;

import java.util.Date;

public class ContaOrganizador extends Conta {
	
	private String cnpj;

	public ContaOrganizador(int id, String nome, String senha, String email, String cpf, String telefone, String cnpj) {
		super(id, nome, senha, email, cpf, telefone);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Evento criaEvento(int id, String nome, String local, String atracao, int lotacao, Date data) {
                int ingressosDisponiveis = lotacao;
		Evento evento = new Evento(id, nome, local, atracao, lotacao, data, ingressosDisponiveis);
		return evento;
	}

}
