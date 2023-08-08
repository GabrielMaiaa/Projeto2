 <%@page import="java.util.List"%>
 <%@page import= "VO.Produtos" %>
 <%@page import= "DAO.ProdutosDAO" %>
 <%@page import= "VO.Carrinho" %>
 <%@page import= "DAO.CarrinhoDAO" %>
 <%@ page import="java.sql.*" %>
<%@page import= "Conexao.Conexao" %>

<html lang="en" data-bs-theme="auto">
  <head><script src="../assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title>Checkout </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
      .container {
        max-width: 960px;
        }

    </style>

    
    <!-- Custom styles for this template -->
    <link href="checkout.css" rel="stylesheet">
  </head>
  <body class="bg-body-tertiary">

    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h2>Checkout form</h2></div>

    <div class="row g-5">
      <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">Carrinho</span>
          <%
              CarrinhoDAO carDAO = new CarrinhoDAO();
              PreparedStatement ps; // estrutura o sql
                ResultSet rs; //armazenará o resultado do bd
                Connection con; //conexão com o bd

                con = new Conexao().conectar();
                
                String sql = "SELECT id_carrinho, produto.id_produto, id_cliente, itens_qtd, valor_total FROM carrinho INNER JOIN produto ON produto.id_produto = carrinho.id_produto";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
              request.setAttribute("listaItensCarrinho", carDAO.buscaItensCarrinho());
              List carrinho = (List) request.getAttribute("listaItensCarrinho");
              
              out.print("<span class='badge bg-primary rounded-pill'>"+ carrinho.size() +"</span>");
              out.print("<h4>");
              Carrinho carr = new Carrinho();
                    for (int cont = 0; cont < carrinho.size(); cont++) {
                        
                        carr = (Carrinho) carrinho.get(cont);
                        Produtos p = new Produtos();
                        p.setIdProduto(carr.getId_produto());
                        out.print("<ul class='list-group mb-3'>");
                            out.print("<li class='list-group-item d-flex justify-content-between lh-sm'>");
                                out.print("<div>");
                                    out.print("<h6 class='my-0'>Nome Produto</h6>");
                                    out.print("<small class='text-body-secondary'>"+ carr.getProdutoNome() +"</small>");
                                out.print("</div>");
                                out.print("<span class='text-body-secondary'>R$  QTD.</span>");
                                out.print("<span class='text-body-secondary'> " + carr.getProdutoValor() + " "+carr.getItens_qtd() +"</span>");
                            out.print("</li>");
                }
              out.print("</h4>");
              out.print("<li class='list-group-item d-flex justify-content-between'>");
              Double somaTotal = 0.0;
                  while(rs.next()){
                    somaTotal += carr.getValorTotalCarrinho();
                  }
              out.print("<span> Total R$ " + somaTotal + "</span>");
          %>
<!--        </h4>
          <li class="list-group-item d-flex justify-content-between">-->
              
          </li>
        </ul>
      </div>
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Endereço</h4>
        <form class="needs-validation" name="frm" method="post" action="CarrinhoController?operacao=2" enctype="multipart/form-data" novalidate>
            <div class="row g-3">
            <div class="col-sm-6">
              <label for="firstName" class="form-label">Primeiro nome</label>
              <input type="text" class="form-control" id="firstName" placeholder="" value="" >
              <div class="invalid-feedback">
                Primeiro nome é requerido.
              </div>
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">Ultimo nome</label>
              <input type="text" class="form-control" id="lastName" placeholder="" value="" >
              <div class="invalid-feedback">
                Ultimo nome é requerido.
              </div>
            </div>

            <div class="col-12">
              <label for="username" class="form-label">Login</label>
              <div class="input-group has-validation">
                <span class="input-group-text">@</span>
                <input type="text" class="form-control" id="username" placeholder="Username" >
              <div class="invalid-feedback">
                  Seu usuario érequerido.
                </div>
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Email <span class="text-body-secondary">(Opcional)</span></label>
              <input type="email" class="form-control" id="email" placeholder="email@example.com">
              <div class="invalid-feedback">
                Coloque o email para que você receba feedback.
              </div>
            </div>

            <div class="col-12">
              <label for="address" class="form-label">Endereço</label>
              <input type="text" class="form-control" id="address" placeholder="Rua teste, 255" >
              <div class="invalid-feedback">
                Coloque o endereço, por favor.
              </div>
            </div>

            <div class="col-12">
              <label for="address2" class="form-label">Complemento <span class="text-body-secondary">(Opcional)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="Complemento">
            </div>

            <div class="col-md-5">
              <label for="country" class="form-label">Pais</label>
              <select class="form-select" id="country" >
                <option value="">Escolha...</option>
                <option>Brasil</option>
              </select>
              <div class="invalid-feedback">
                Escolha um pais.
              </div>
            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">Estado</label>
              <select class="form-select" id="state" >
                <option value="">Escolha...</option>
                <option>São Paulo</option>
                <option>Belo Horizonte</option>
                <option>Mato Grosso </option>
                <option>Rio de Janeiro</option>
                <option>Mato Grosso do Sul</option>
              </select>
              <div class="invalid-feedback">
                Escolha um estado valido.
              </div>
            </div>

            <div class="col-md-3">
              <label for="zip" class="form-label">CEP</label>
              <input type="text" class="form-control" id="zip" placeholder="" >
              <div class="invalid-feedback">
                CEP é requerido.
              </div>
            </div>
          </div>

          <hr class="my-4">

          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="save-info">
            <label class="form-check-label" for="save-info">Salvar as informações para proxima compra</label>
          </div>

          <hr class="my-4">

          <h4 class="mb-3">Pagamento</h4>

          <div class="my-3">
            <div class="form-check">
              <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked >
              <label class="form-check-label" for="credit">Cartão de Credito</label>
            </div>
            <div class="form-check">
              <input id="debit" name="paymentMethod" type="radio" class="form-check-input" >
              <label class="form-check-label" for="debit">Cartão de Debito</label>
            </div>
            <div class="form-check">
              <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" >
              <label class="form-check-label" for="paypal">Pix</label>
            </div>
          </div>

          <div class="row gy-3">
            <div class="col-md-6">
              <label for="cc-name" class="form-label">Nome no cartão</label>
              <input type="text" class="form-control" id="cc-name" placeholder="" >
              <small class="text-body-secondary">Nome completo impresso no cartão</small>
              <div class="invalid-feedback">
                Nome no cartão é requerido.
              </div>
            </div>

            <div class="col-md-6">
              <label for="cc-number" class="form-label">Numero do cartão</label>
              <input type="text" class="form-control" id="cc-number" placeholder="" >
              <div class="invalid-feedback">
                Numero do cartão é requerido
              </div>
            </div>

            <div class="col-md-3">
              <label for="cc-expiration" class="form-label">Validade</label>
              <input type="text" class="form-control" id="cc-expiration" placeholder="" >
              <div class="invalid-feedback">
                  Data de validade é requerida
              </div>
            </div>

            <div class="col-md-3">
              <label for="cc-cvv" class="form-label">CVV</label>
              <input type="text" class="form-control" id="cc-cvv" placeholder="" >
              <div class="invalid-feedback">
                CVV é requerido
              </div>
            </div>
          </div>

          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue para finalizar compra</button>
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-body-secondary text-center text-small">
    <p class="mb-1">Â© 2023 Copyright</p>
  </footer>
</div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

    <script src="src/checkout.js"></script></body>
</html>
