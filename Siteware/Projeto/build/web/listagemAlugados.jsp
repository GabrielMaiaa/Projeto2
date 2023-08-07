<%@page import="java.util.List"%>

<%@page import= "VO.Alugados" %>
<%@ page import="java.sql.*" %>
<%@page import= "Conexao.Conexao" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <h3 style="text-align: center"> Listagem de Livros da biblioteca </h3>
        <table class="table table-striped container center" border="1" align="center" cellspacing="0" width="30%">
            <thead>
                <tr>
                  <th scope="col">Id Cliente</th>
                  <th scope="col">Nome Cliente</th>
                  <th scope="col">Livro Alugado</th>
                </tr>
            </thead>
            <br><br>
            <%
                PreparedStatement ps; // estrutura o sql
                ResultSet rs; //armazenará o resultado do bd
                Connection con; //conexão com o bd
                
                con = new Conexao().conectar();
                
                String sql = 
                        "SELECT idAluguel, clientes.idCliente, clientes.nome, livros.titulo FROM aluguel INNER JOIN clientes ON clientes.idCliente = aluguel.idCliente INNER JOIN livros ON livros.idLivro = aluguel.idLivro";
                
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                Alugados al = new Alugados();
                    while(rs.next()){
                        al.setIdAluguel(rs.getInt(1));
                        out.print("<tr>");
                        out.print("<td>" + rs.getInt(2) + "</td>");
                        out.print("<td>" + rs.getString(3) + "</td>");
                        out.print("<td>" + rs.getString(4) + "</td>");
                        out.print("<td><a href=\"AluguelController?operacao=2&id="+al.getIdAluguel()+"\">Excluir</a></td>");
                        out.print("</tr>");
                    }
            %>
        </table>
        <br><br><!-- comment -->
        <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="button" class="btn btn-outline-primary">
                        <a style="text-decoration:none; color: black "href="index.html">
                            Voltar
                        </a>
                    </button>
        </div>
    </body>
</html>


