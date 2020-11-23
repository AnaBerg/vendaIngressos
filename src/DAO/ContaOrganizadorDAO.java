/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ContaClienteDAO.ListaContaCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ContaCliente;
import model.ContaOrganizador;

/**
 *
 * @author Nicolas
 */
public class ContaOrganizadorDAO {
    public static ArrayList<ContaOrganizador> ListaContaOrganizador = new ArrayList<ContaOrganizador>();

    public ContaOrganizadorDAO() {
    }
    
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_conta_organizador");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
    
    // Busca as contas
    public ArrayList getListaContaOrganizador() {
        
        ListaContaOrganizador.clear(); // Limpa o Array

        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_conta_organizador");
            while (res.next()) {

                String nome = res.getString("nome");
                int senha = res.getInt("senha");
                int id = res.getInt("id");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                String cpf = res.getString("cpf");
                String cnpj = res.getString("cnpj");

                ContaOrganizador objeto = new ContaOrganizador(id, nome, cnpj, email, cpf, telefone, cnpj);

                ListaContaOrganizador.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return ListaContaOrganizador;
    }
    
    // Cadastra nova conta
    public boolean InsertContaClienteBD(ContaOrganizador objeto) {
        String sql = "INSERT INTO tb_conta_cliente(id,nomeUsuario,senha,cpf,cnpj,telefone,email) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNomeUsuario());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getCpf());
            stmt.setString(5, objeto.getCnpj());
            stmt.setString(6, objeto.getTelefone());
            stmt.setString(7, objeto.getEmail());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    // Edita uma conta pelo seu campo ID
    public boolean UpdateContaOrganizadorBD(ContaOrganizador objeto) {

        String sql = "UPDATE tb_conta_organizador set nomeUsuario = ? ,senha = ? ,cpf = ?,cnpj = ? ,telefone = ?,email = ? WHERE id = ?";

        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNomeUsuario());
            stmt.setString(2, objeto.getSenha());
            stmt.setString(3, objeto.getCpf());
            stmt.setString(4, objeto.getCpf());
            stmt.setString(5, objeto.getTelefone());
            stmt.setString(6, objeto.getEmail());
            stmt.setInt(7, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    
}
