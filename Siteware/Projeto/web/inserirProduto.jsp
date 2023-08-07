<%@page import= "VO.Produtos" %>
<%@page import= "VO.Promocao" %>
<%@page import="java.util.List"%>

<%@ page import="java.sql.*" %>
<%@page import= "Conexao.Conexao" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserção de Produtos novo</title>
        <meta charset="UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
             rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <%
           Produtos pNovo = (Produtos) request.getAttribute("Produtos");
 
        %>
        <br>
        <h1 class="text-center"> Inserir Produtos novo </h1>
        <br><br>
            <form class="container center" name="frm" method="post" action="ProdutosController?operacao=5" enctype="multipart/form-data" style="margin-right: 60px;">
                <div class="row mb-3">
                  <label for="inputEmail3" class="col-sm-2 col-form-label">Nome </label>
                  <div class="col-sm-5">
                    <input type="text" class="form-control" name="nome"  >
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputPassword3" class="col-sm-2 col-form-label">Valor</label>
                  <div class="col-sm-5">
                    <input type="number" class="form-control" name="valor" >
                  </div>
                </div>
                
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Promoção</label>
                    <select class="form-select" id="inputGroupSelect01">
                    <option selected>Escolha a promoção...</option>  
                  <%
                       PreparedStatement ps; // estrutura o sql
                        ResultSet rs; //armazenará o resultado do bd
                        Connection con; //conexão com o bd
                
                        con = new Conexao().conectar();
                        String sql = "SELECT id_promocao, nome_promocao FROM promocao;";
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();

                        while(rs.next()){
                            out.print("<option name='id_promocao' value='" + rs.getInt(1) + "'> " + rs.getString(2) + "</option>");
                        }
                   %>
                    </select>
                </div>

            <button type="submit" class="btn btn-primary">
                Inserir
            </button>
            <button type="button" class="btn btn-outline-primary">
                        <a style="text-decoration:none; color: black "href="produtos.html">
                            Voltar
                        </a>
            </button>   
        </form>
    </body>
</html>

