/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.ContaCliente;

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
        
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_conta_cliente");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        

        return maiorID;
    }

    // Busca as contas
    public ArrayList<ContaCliente> getListaContaCliente() {
        
        ListaContaCliente.clear(); // Limpa o Array

        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_conta_cliente");
            while (res.next()) {

                String nome = res.getString("nome");
                String senha = res.getString("senha");
                int id = res.getInt("id");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                String cpf = res.getString("cpf");

                ContaCliente objeto = new ContaCliente(id, nome, senha, email, cpf, telefone);

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
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

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
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNomeUsuario());
            stmt.setString(2, objeto.getSenha());
            stmt.setString(3, objeto.getCpf());
            stmt.setString(4, objeto.getTelefone());
            stmt.setString(5, objeto.getEmail());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    // Deleta um Conta Cliente pelo seu campo ID
    public boolean DeleteContaClienteBD(int id) {
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_conta_cliente WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }
}
