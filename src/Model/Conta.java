package Model;

public abstract class Conta {
	
	protected int id;
	private String nomeUsuario;
	private String senha;
	private String email;
	private String cpf;
	private String telefone;
	
	public Conta() {		
	}
	
	public Conta(int id, String nomeUsuario, String senha, String email, String cpf, String telefone) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + "\nNome: " + this.nomeUsuario;
	}
}
