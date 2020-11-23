/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ContaCliente;

/**
 *
 * @author Nicolas
 */
public class ContaClienteDAO {
    public static ArrayList<ContaCliente> ListaContaCliente = new ArrayList<ContaCliente>();
    
    public ContaClienteDAO(){
        
    }
    
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_conta_cliente");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;  //inst�ncia da conex�o

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "db_venda_ingressos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "admin";
            String password = "admin";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
            System.out.println("O driver não foi encontrado.");
            return null;

        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar...");
            return null;
        }
    }

    // Busca as contas
    public ArrayList getListaContaCliente() {
        
        ListaContaCliente.clear(); // Limpa o Array

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_conta_cliente");
            while (res.next()) {

                String nome = res.getString("nome");
                int senha = res.getInt("senha");
                int id = res.getInt("id");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                String cpf = res.getString("cpf");

                ContaCliente objeto = new ContaCliente(id, nome, cpf, email, cpf, telefone);

                ListaContaCliente.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return ListaContaCliente;
    }

    // Cadastra nova conta
    public boolean InsertContaClienteBD(ContaCliente objeto) {
        String sql = "INSERT INTO tb_conta_cliente(id,nomeUsuario,senha,cpf,telefone,email) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNomeUsuario());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getCpf());
            stmt.setString(5, objeto.getTelefone());
            stmt.setString(6, objeto.getEmail());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Edita uma conta pelo seu campo ID
    public boolean UpdateContaClienteBD(ContaCliente objeto) {

        String sql = "UPDATE tb_conta_cliente set nomeUsuario = ? ,senha = ? ,cpf = ? ,telefone = ?, email = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNomeUsuario());
            stmt.setString(2, objeto.getSenha());
            stmt.setString(3, objeto.getCpf());
            stmt.setString(4, objeto.getTelefone());
            stmt.setString(5, objeto.getEmail());
            stmt.setInt(5, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
}
