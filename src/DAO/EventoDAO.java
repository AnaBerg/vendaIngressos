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
import java.util.Date;
import model.Evento;

/**
 *
 * @author Nicolas
 */
public class EventoDAO {
    
    public static ArrayList<Evento> ListaEvento = new ArrayList<Evento>();

    public EventoDAO() {
    }
    
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_evento");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
    
    // Busca as contas
    public ArrayList getListaEvento() {
        
        ListaEvento.clear(); // Limpa o Array

        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_evento");
            while (res.next()) {

                String nome = res.getString("nome");
                String local = res.getString("local");
                int id = res.getInt("id");
                String atracao = res.getString("atracao");
                int lotacao = res.getInt("lotacao");
                Date data = res.getDate("data");
                int ingressosDisponiveis = res.getInt("ingressosDisponiveis");

                Evento objeto = new Evento(id, nome, local, atracao, lotacao, data, ingressosDisponiveis);

                ListaEvento.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return ListaEvento;
    }
    
    // Cadastra novo Evento
    public boolean InsertEventoBD(Evento objeto) {
        String sql = "INSERT INTO tb_evento(id,nome,local,atracao,lotacao,data,ingressosDisponiveis) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getLocal());
            stmt.setString(4, objeto.getAtracao());
            stmt.setInt(5, objeto.getLotacao());
            stmt.setDate(6, (java.sql.Date) objeto.getData());
            stmt.setInt(7, objeto.getIngressosDisponiveis());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    // Edita um Evento pelo seu campo ID
    public boolean UpdateEventoBD(Evento objeto) {

        String sql = "UPDATE tb_evento set nome = ? ,local = ? ,atracao = ?,lotacao = ? ,data = ?,ingressosDisponiveis = ? WHERE id = ?";

        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getLocal());
            stmt.setString(3, objeto.getAtracao());
            stmt.setInt(4, objeto.getLotacao());
            stmt.setDate(5, (java.sql.Date) objeto.getData());
            stmt.setInt(6, objeto.getIngressosDisponiveis());
            stmt.setInt(7, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    // Deleta um Evento pelo seu campo ID
    public boolean DeleteEventoBD(int id) {
        try {
            Statement stmt = ConexaoDB.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_evento WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }
}
