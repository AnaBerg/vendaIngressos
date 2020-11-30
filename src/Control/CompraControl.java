package Control;

import Model.Compra;

public class CompraControl {
	
	private final Compra compra;
	
	public CompraControl() {
		this.compra = new Compra();
	}
	
	public boolean Comprar() {
		if(compra.realizarCompra()) {
			return true;
		} else {
			return false;
		}
	}

}
