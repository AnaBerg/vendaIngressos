package Control;

import java.sql.SQLException;

import Model.Compra;

public class CompraControl {
	
	private final Compra compra;
	
	public CompraControl() {
		this.compra = new Compra();
	}
	
	public boolean Comprar(int quantidadeIngressos, int contaClienteId, int eventoId) throws SQLException {
		int id = compra.maiorId() + 1;
		Compra objCompra = new Compra(id, quantidadeIngressos, contaClienteId, eventoId);
		if(compra.realizarCompra(objCompra)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Apagar(int id) {
		if(compra.deleteCompra(id)) {
			return true;
		} else {
			return false;
		}
	}

}
