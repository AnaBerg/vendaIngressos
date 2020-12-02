package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ContaClienteDAO;

public class ContaCliente extends Conta {
	
	private final ContaClienteDAO dao;
	
	public ContaCliente() {
		this.dao = new ContaClienteDAO();
	}

	public ContaCliente(int id, String nomeUsuario, String senha, String email, String cpf, String telefone) {
		super(id, nomeUsuario, senha, email, cpf, telefone);
		this.dao = new ContaClienteDAO();
	}
	
	public boolean cadastraCliente(ContaCliente conta) {
		dao.InsertContaClienteBD(conta);
		return true;
	}
	
	public ArrayList<ContaCliente> ListaClientes() {
		return dao.getListaContaCliente();
	}
	
	public boolean EditaCliente(ContaCliente conta) {
		dao.UpdateContaClienteBD(conta);
		return true;
	}
	
	public boolean DeletaCliente(int id) {
		dao.DeleteContaClienteBD(id);
		return true;
	}
	
	public int maiorId() throws SQLException {
		return dao.maiorID();
	}
	
	public ArrayList<Compra> historicoCompras(int id) {
		Compra compra = new Compra();
		return compra.getComprasCliente(id);
	}
}
