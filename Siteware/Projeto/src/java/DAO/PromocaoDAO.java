/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import VO.Promocao;

/**
 *
 * @author Pichau
 */
public class PromocaoDAO {
    public ArrayList<Promocao> buscaPromocao() {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "SELECT id_promocao, nome_promocao FROM promocao";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<Promocao> listaPromocao = new ArrayList<>();
                while (rs.next()) {
                    //setar os valores dentro de um objeto (Cliente)
                    //adicionar este objeto a uma list
                    Promocao p = new Promocao();
                    p.setIdPromocao(rs.getInt("id_promocao"));
                    p.setNomePromocao(rs.getString("nome_promocao"));
                    listaPromocao.add(p); // adiciona o objeto no arraylist
                }
                con.close();
                return listaPromocao;
            }else{
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados: " + erro.getMessage());
            return null;
        }
    }
        public boolean excluir(int id){
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "DELETE FROM promocao WHERE id_promocao=?; ";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);   
                System.out.println(ps);
                if(ps.executeUpdate()!=0){
                    con.close();
                    return true;
                }else{
                    return false;
                }               
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }
        
        public Promocao localizarRegistro(int id) {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id_promocao, nome_promocao from promocao where id_promocao = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                //setar os valores dentro de um objeto (Produto)
                Promocao p = new Promocao();
                p.setIdPromocao(rs.getInt("id_promocao"));
                p.setNomePromocao(rs.getString("nome_promocao"));
                con.close();
                return p;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados para alteração: " + erro.getMessage());
            return null;
        }
    }

    public boolean alterar(Promocao p) {
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "UPDATE promocao SET nome_promocao=? WHERE id_promocao=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNomePromocao());
                ps.setInt(2, p.getIdPromocao());
                if (ps.executeUpdate() != 0) {
                    con.close();
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean inserirPromocao(Promocao l){
        Connection con = new Conexao().conectar();
        String sql = "INSERT INTO promocao (nome_promocao) VALUES (?)";
        
        if (con != null) {
            try {
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                
                ps.setString(1, l.getNomePromocao());
                ps.executeUpdate();
                con.close();
                return true;
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
