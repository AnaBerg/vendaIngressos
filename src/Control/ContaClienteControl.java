
package Control;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.ContaCliente;

public class ContaClienteControl {
	
	private final ContaCliente cliente;
	
	public ContaClienteControl() {
		this.cliente = new ContaCliente();
	}
	
	public boolean Cadastrar(String nome, String senha, String email, String cpf, String telefone) throws SQLException {
		int id = cliente.maiorId() + 1;
		ContaCliente objetoCliente = new ContaCliente(id, nome, senha, email, cpf, telefone);
		if(cliente.cadastraCliente(objetoCliente)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Editar(int id, String nome, String senha, String email, String cpf, String telefone) {
		ContaCliente objetoCliente = new ContaCliente(id, nome, senha, email, cpf, telefone);
		if(cliente.EditaCliente(objetoCliente)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Apagar(int id) {
		if(cliente.DeletaCliente(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<ContaCliente> getListaCliente() {
		return cliente.ListaClientes();
	}
    
}
