/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ProdutosDAO;
import DAO.PromocaoDAO;
import VO.Produtos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author Pichau
 */
@WebServlet(name = "ProdutosController", urlPatterns = {"/ProdutosController"})
public class ProdutosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        response.setContentType("text/html;charset=UTF-8");
        ProdutosDAO p = new ProdutosDAO();
        PromocaoDAO promo = new PromocaoDAO();
        
        int operacao = Integer.parseInt(request.getParameter("operacao"));
        int id;
        switch(operacao){
            case 1: // listagem
                request.setAttribute("listaProduto", p.buscaProdutos());
                
                RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
                rd.forward(request, response);
                break;
            case 2: // exclusão
                id = Integer.parseInt(request.getParameter("id"));
                if(p.excluir(id)){
                     response.sendRedirect("resultado.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultado.jsp?operacao=2");                
                }
                break;
            case 3: // solicitação de alteraração de registro
                id = Integer.parseInt(request.getParameter("id"));                
                request.setAttribute("produto", p.localizarRegistro(id));
                RequestDispatcher r = request.getRequestDispatcher("/alteracao.jsp");
                r.forward(request, response);
            case 4: // efetuar a modificação em BD (recebe os dados atualizados e modifica em banco)
                String nomeNovo = request.getParameter("nome");
                Double valorNovo = Double.parseDouble(request.getParameter("valor"));
                int idPromocaoNovo = Integer.parseInt(request.getParameter("id_promocao")); 

                int codigo = Integer.parseInt(request.getParameter("id"));
                Produtos produto = new Produtos();
                produto.setIdProduto(codigo);
                produto.setNome(nomeNovo);
                produto.setValor(valorNovo);
                produto.setIdPromocao(idPromocaoNovo);
                
                ProdutosDAO produtoDAO = new ProdutosDAO();
                boolean sucesso = produtoDAO.alterar(produto);
                
                if(sucesso){
                     response.sendRedirect("resultado.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultado.jsp?operacao=2");                
                }     
                break;
            case 5: //INSERIR NOVO FILME     
                request.setAttribute("listaPromocao", promo.buscaPromocao());
                    String nome =  request.getParameter("nome");
                    Double valor = Double.parseDouble(request.getParameter("valor"));
                    int idPromocao = Integer.parseInt(request.getParameter("id_promocao"));
                
                System.out.println(idPromocao);
                
                Produtos pNovo = new Produtos();
                pNovo.setNome(nome);
                pNovo.setValor(valor);
                pNovo.setIdPromocao(idPromocao);
                ProdutosDAO produtoDAO2 = new ProdutosDAO();
                boolean sucesso2 = produtoDAO2.inserirProduto(pNovo);
 
                if(sucesso2){
                     response.sendRedirect("resultado.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultado.jsp?operacao=2");                
                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
