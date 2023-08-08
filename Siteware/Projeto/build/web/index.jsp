
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import= "VO.Produtos" %>
<%@page import= "DAO.ProdutosDAO" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Loja do Mainha</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            h1, h2 {
                text-align: center;
                font-family: Gill Sans;
            }
            
            a:hover {
                color: white;
            }

        </style>
    </head>

    <body>
        <br>
        <nav class="navbar bg-body-tertiary">
        <div class="container-fluid" style="margin-left: 100px; margin-right: 100px;">
            <a class="navbar-brand" href="ProdutosController?operacao=1">Produtos</a>
            <form class="d-flex" role="search">
                 <button class="btn btn-outline-success" type="submit"><a href="login.jsp" style="text-decoration: none; color:green;" onMouseOver="this.style.color='white'" onMouseOver="this.style.color='white'">Login</a></button>
                 <button style="margin-left: 10px" class="btn btn-info" type="submit">
                     <a href="checkout.jsp" style="text-decoration: none; color: white;">Carrinho</a></button>
            </form>
        </div>
        </nav>
        <hr style=" width: 100%; ">
        
        <a type="hidden" href="#"></a>
            <br>
            <br>
            <h2>Listagem de Produtos </h2>
            <br>
            <br>

            <%
                ProdutosDAO pDAO = new ProdutosDAO();
                request.setAttribute("listaProduto", pDAO.buscaProdutos());
                List produtos = (List) request.getAttribute("listaProduto");
                if (produtos != null) {
            %>
        <div class='row' style='margin-left: 60px'>
            <%
                    for (int cont = 0; cont < produtos.size(); cont++) {
                        Produtos p = (Produtos) produtos.get(cont);
            %>
            <div class='col-3'>
                <form name='frm' action='CarrinhoController?operacao=3' method='post'>
                    <input type='hidden' name='id_produto' value='<%= p.getIdProduto() %>'>
                    <input type='hidden' name='nome_produto' value='<%= p.getNome() %>'>
                    <input type='hidden' name='valor_produto' value='<%= p.getValor()%>'>
                    <input type='hidden' name='promo_produto' value='<%= p.getIdPromocao()%>'>
                    <div class='card text-center' style='width: 18rem;'>
                        <div class='card-body'>
                            <h5 class='card-title' ><%= p.getNome() %></h5>
                            <p class='card-text' > R$ <%= p.getValor() %></p>
                            <select class='form-select' aria-label='Default select example' name='qtd_itens'>
                                <option selected' name="qtd_itens"> Escolha a qtd </option>
                                <option value='1'> 1 </option>
                                <option value='2'> 2 </option>
                                <option value='3'> 3 </option>
                                <option value='4'> 4 </option>
                                <option value='5'> 5 </option>
                            </select>
                            <br>
                            <button class='btn btn-success' type='submit'> Adicionar ao carrinho</button>
                        </div>
                    </div>
                </form>
            </div>
        <%
                }
        %>
        </div>
        <%
            }
        %>

            <br>
            <br>

            
            <br>
            <br><br>
            <br><br>
            <br><br>
            <br><br>
            <br>
            <div class="bg-dark text-center text-white" style=" width:  100%;">
               
                <div class="container p-4 pb-0" style="width:  100%; ">
                    <p>Gabriel Maia</p>
                    <div class="text-center p-3" >
                        © 2023 Copyright:
                    </div>
                </div>
               
            </div>
            </body>
</html>

