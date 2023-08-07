package DAO;


import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import VO.Produtos;

public class ProdutosDAO {
    
     public ArrayList<Produtos> buscaProdutos() {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "SELECT id_produto, nome, valor, id_promocao FROM produto";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<Produtos> listaProduto = new ArrayList<>();
                while (rs.next()) {
                    //setar os valores dentro de um objeto (Produto)
                    //adicionar este objeto a uma list
                    Produtos p = new Produtos();
                    p.setIdProduto(rs.getInt("id_produto"));
                    p.setNome(rs.getString("nome"));
                    p.setValor(rs.getDouble("valor"));
                    p.setIdPromocao(rs.getInt("id_promocao"));
                    
                    listaProduto.add(p); // adiciona o objeto no arraylist
                }
                con.close();
                return listaProduto;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados: " + erro.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "DELETE FROM produto WHERE id_produto = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                if (ps.executeUpdate() != 0) {
                    con.close();
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }

    public Produtos localizarRegistro(int id) {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "SELECT id_produto, nome, valor, id_promocao FROM produto WHERE id_produto = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                //setar os valores dentro de um objeto (Produto)
                 Produtos p = new Produtos();
                    p.setIdProduto(rs.getInt("id_produto"));
                    p.setNome(rs.getString("nome"));
                    p.setValor(rs.getDouble("valor"));
                    p.setIdPromocao(rs.getInt("id_promocao"));
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

    public boolean alterar(Produtos p) {
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "UPDATE produto SET nome=?, valor=? , id_promocao=? WHERE id_produto=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNome());
                ps.setDouble(2, p.getValor());
                ps.setInt(3, p.getIdPromocao());
                ps.setInt(4, p.getIdProduto());
                if (ps.executeUpdate() != 0) {
                    con.close();
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException erro) {
                erro.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean inserirProduto(Produtos p){
        Connection con = new Conexao().conectar();
        String sql = "INSERT INTO produto (nome, valor, id_promocao) VALUES (?,?,?)";
        
        if (con != null) {
            try {
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                
                ps.setString(1, p.getNome());
                ps.setDouble(2, p.getValor());
                ps.setInt(3, p.getIdPromocao());
                
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


