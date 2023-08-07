/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import VO.Carrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class CarrinhoDAO {
    public ArrayList<Carrinho> buscaItensCarrinho() {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "SELECT id_carrinho, produto.id_produto, produto.nome_produto, id_cliente, itens_qtds FROM carrinho"
                        + "INNER JOIN produto ON produto.id_produto = carrinho.id_produto";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<Carrinho> lista = new ArrayList<>();
                while (rs.next()) {
                    //setar os valores dentro de um objeto (Cliente)
                    //adicionar este objeto a uma list
                    Carrinho car = new Carrinho();
                    car.setId_carrinho(rs.getInt("id_carrinho"));
                    car.setId_produto(rs.getInt("id_produto"));
                    car.setId_cliente(rs.getInt("id_cliente"));
                    car.setItens_qtds(rs.getInt("itens_qtds"));
                    lista.add(car); // adiciona o objeto no arraylist
                }
                con.close();
                return lista;
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
                String sql = "DELETE FROM carrinho WHERE id_carrinho = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);             
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
    
    public boolean inserirItensCarrinho(Carrinho c){
        Connection con = new Conexao().conectar();
        String sql = "INSERT INTO carrinho (id_produto, id_cliente, itens_qtds) VALUES (?,?,?)";
        
        if (con != null) {
            try {
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, c.getId_produto());
                ps.setInt(2, 1);
                ps.setInt(3, c.getItens_qtds());
                
                ps.executeUpdate();
                con.close();
                return true;
            } catch (Exception e ) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
