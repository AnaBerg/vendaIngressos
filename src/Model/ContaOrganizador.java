package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ContaOrganizadorDAO;

public class ContaOrganizador extends Conta {
	
	private String cnpj;
	private final ContaOrganizadorDAO dao;
	
	public ContaOrganizador() {
		this.dao = new ContaOrganizadorDAO();
	}

	public ContaOrganizador(int id, String nome, String senha, String email, String cpf, String telefone, String cnpj) {
		super(id, nome, senha, email, cpf, telefone);
		this.cnpj = cnpj;
		this.dao = new ContaOrganizadorDAO();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public boolean cadastraOrganizador(ContaOrganizador organizador) {
		dao.InsertContaOrganizadorBD(organizador);
		return true;
	}
	
	public ArrayList<ContaOrganizador> ListaOrganizador() {
		return dao.getListaContaOrganizador();
	}
	
	public boolean editaOrganizador(ContaOrganizador organizador) {
		dao.UpdateContaOrganizadorBD(organizador);
		return true;
	}
	
	public boolean deletaOrganizador(int id) {
		dao.DeleteContaOrganizadorBD(id);
		return true;
	}
	
	public int maiorId() throws SQLException {
		return dao.maiorID();
	}
	
	public boolean buscaOrganizador() {
		dao.buscarOrganizador(id);
		return true;
	}
}
