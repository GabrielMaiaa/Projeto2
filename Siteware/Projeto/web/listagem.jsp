<%@page import="java.util.List"%>

<%@page import= "VO.Produtos" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <h3 style="text-align: center"> Listagem de Produtos da loja </h3>
        <table class="table table-striped container center" border="1" align="center" cellspacing="0" width="30%">
            <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Nome</th>
                  <th scope="col">Valor</th>
                  <th scope="col">Promoção</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
            </thead>
            <%
                List produtos = (List) request.getAttribute("listaProduto");
                if (produtos != null) {
                    out.print("<center>Achados: " + produtos.size() + "</center><br><br><br>");
                    for (int cont = 0; cont < produtos.size(); cont++) {
                        out.print("<tr>");
                        Produtos p = new Produtos();
                        p = (Produtos) produtos.get(cont);
                        out.print("<td>" + p.getIdProduto() + "</td>");
                        out.print("<td>" + p.getNome() + "</td>");
                        out.print("<td>" + p.getValor() + "</td>");
                        out.print("<td>" + p.getIdPromocao()+ "</td>");
                        out.print("<td><a href=\"ProdutosController?operacao=2&id="+p.getIdProduto()+"\">Excluir</a></td>");
                        out.print("<td><a href=\"ProdutosController?operacao=3&id="+p.getIdProduto()+"\">Alterar</a></td>");
                        out.print("</tr>");
                    }
                }
            %>
        </table>
        <br><br><!-- comment -->
        <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="button" class="btn btn-outline-primary">
                        <a style="text-decoration:none; color: black "href="telausuario.jsp">
                            Voltar
                        </a>
                    </button>
            </div>
    </body>
</html>

