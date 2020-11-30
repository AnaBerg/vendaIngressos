package Control;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.ContaOrganizador;

public class ContaOrganizadorControl {
	
	private final ContaOrganizador organizador;
	
	public ContaOrganizadorControl() {
		this.organizador = new ContaOrganizador();
	}
	
	public boolean Cadastrar(String nome, String senha, String email, String cpf, String telefone, String cnpj) throws SQLException {
		int id = organizador.maiorId() + 1;
		ContaOrganizador objetoOrganizador = new ContaOrganizador(id, nome, senha, email, cpf, telefone, cnpj);
		if(organizador.cadastraOrganizador(objetoOrganizador)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Editar(int id, String nome, String senha, String email, String cpf, String telefone, String cnpj) {
		ContaOrganizador objetoOrganizador = new ContaOrganizador(id, nome, senha, email, cpf, telefone, cnpj);
		if(organizador.editaOrganizador(objetoOrganizador)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Apagar(int id) {
		if(organizador.deletaOrganizador(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<ContaOrganizador> getListaOrganizador() {
		return organizador.ListaOrganizador();
	}

}
