<%@page import="java.util.List"%>

<%@page import= "VO.Promocao" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promocao</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <h3 style="text-align: center"> Listagem de Promocao da loja </h3>
        <table class="table table-striped container center" border="1" align="center" cellspacing="0" width="30%">
            <thead>
                <tr>
                  <th scope="col">Id Promo</th>
                  <th scope="col">Titulo Promoção</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
            </thead>
            <%
                List Promocao = (List) request.getAttribute("listaPromocao");
                if (Promocao != null) {
                    out.print("<center>Achados: " + Promocao.size() + "</center><br><br><br>");
                    for (int cont = 0; cont < Promocao.size(); cont++) {
                        out.print("<tr>");
                        Promocao p = new Promocao();
                        p = (Promocao) Promocao.get(cont);
                        out.print("<td>" + p.getIdPromocao() + "</td>");
                        out.print("<td>" + p.getNomePromocao()+ "</td>");
                        out.print("<td><a href=\"PromocaoController?operacao=2&id="+p.getIdPromocao()+"\">Excluir</a></td>");
                        out.print("<td><a href=\"PromocaoController?operacao=3&id="+p.getIdPromocao()+"\">Alterar</a></td>");
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

