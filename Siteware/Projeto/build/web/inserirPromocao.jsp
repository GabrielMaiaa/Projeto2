<%@page import= "VO.Promocao" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserção de Promoção nova</title>
        <meta charset="UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
             rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <%
           Promocao pNovo = (Promocao) request.getAttribute("Promocao");
        %>
        
        <h1 class="text-center"> Inserir Promoção nova </h1>
        <br><br>
        <form class="container center" name="frm" method="post" action="PromocaoController?operacao=5" style="margin-right: 60px;">
            <div class="row mb-3">
              <label for="inputEmail3" class="col-sm-2 col-form-label">Nome promoção </label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="titulo"  >
              </div>
            </div>

            <button type="submit" class="btn btn-primary">
                <a style="text-decoration:none; color: black "href="listagemPromocao.jsp">
                    Inserir
                </a>
            </button>
            <button type="button" class="btn btn-outline-primary">
                        <a style="text-decoration:none; color: black "href="telausuario.jsp">
                            Voltar
                        </a>
            </button>
                
        </form>
    </body>
</html>

