package Main;

import DAO.ContaClienteDAO;
import Model.ContaCliente;

public class Main {
    public static void main(String[] args) {
        ContaClienteDAO dao = new ContaClienteDAO();
        ContaCliente conta = new ContaCliente(1, "Damiani", "123", "eu", "sks", "111");
        dao.InsertContaClienteBD(conta);
    }
}
