

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        
      <br>
        
      <nav class="navbar bg-body-tertiary">
      <div class="container-fluid" style="margin-left: 100px; margin-right: 100px;">
        <a class="navbar-brand">Olá, <% 
        // Recupera o nome do usuário armazenado na sessão
        String nomeUsuario = (String) session.getAttribute("nomeUsuario");
        
        if (nomeUsuario != null) {
        %>
        <%= nomeUsuario %>! 
        <% } else { %>
        Ocorreu um erro ao recuperar o nome do usuário.
        <% } %></a>
        <form class="d-flex" role="search">
            <button class="btn btn-outline-danger" type="submit"><a href="index.jsp" style="text-decoration: none; color: red; ">Sair</a></button>
        </form>
      </div>
      </nav>
      
      <hr><!-- comment -->
      <div class="container text-center">
           <div class="row">
                <div class="col">
                    <button type="button" class="btn btn-outline-primary"><a style="text-decoration:none; color: black "href="produtos.html">Produtos</a></button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-outline-success"><a style="text-decoration:none; color: black "href="promocoes.html">Promoções</a></button>
                </div>
           </div>
      </div>
       
    </body>
</html>
