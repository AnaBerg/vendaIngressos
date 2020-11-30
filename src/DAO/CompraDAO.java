/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nicolas
 */
public class CompraDAO {

    public CompraDAO() {

    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tc_compra");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    // Adiciona uma Compra no DB
    public boolean InsertCompraBD(Compra objeto) {
        String sql = "INSERT INTO tb_compra(id,quantidadeIngressos,conta_cliente_id,evento_id) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getQuantidadeIngressos());
            stmt.setInt(3, objeto.getContaClienteId());
            stmt.setInt(4, objeto.getEventoId());

            Statement stmtConta = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmtConta.executeQuery("SELECT * FROM tb_evento WHERE id = " + objeto.getEventoId());

            int ingressosDisponiveis = res.getInt("ingressosDisponiveis");
            
            res.close();

            if (ingressosDisponiveis <= objeto.getQuantidadeIngressos()) {
                stmt.execute();
                stmt.close();

                return true;
            } else {
                stmt.close();
                stmtConta.close();
                return false;
            }

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    // Deleta um Compra pelo seu campo ID
    public boolean DeleteCompraBD(int id) {
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_compra WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

}
