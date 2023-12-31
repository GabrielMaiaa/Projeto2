<%@page import= "VO.Produtos" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de dados</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
             rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <%
            Produtos p = (Produtos) request.getAttribute("produto");
        %>
        <h1 class="text-center"> Alteração de Produtos </h1>
        <br><br>
            
        <form class="container center" name="frm" method="post" action="ProdutosController?operacao=4" style="margin-right: 60px;">
            <input type="hidden" name="id" value="<%=p.getIdProduto()%>"><br><br>
            <div class="row mb-3">
              <label for="inputEmail3" class="col-sm-2 col-form-label">Nome</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="nome" value="<%=p.getNome()%>">
              </div>
            </div>
            <div class="row mb-3">
              <label for="inputPassword3" class="col-sm-2 col-form-label">Valor</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="valor" value="<%=p.getValor()%>">
              </div>
            </div>
            <div class="row mb-3">
              <label for="inputPassword3" class="col-sm-2 col-form-label">Promoção</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="id_promocao" value="<%=p.getIdPromocao()%>">
              </div>
            </div>

            <button type="submit" class="btn btn-primary">Alterar</button>
        </form>
    </body>
</html>
