/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CarrinhoDAO;
import DAO.ProdutosDAO;
import VO.Carrinho;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pichau
 */
@WebServlet(name = "CarrinhoController", urlPatterns = {"/CarrinhoController"})
public class CarrinhoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CarrinhoDAO car = new CarrinhoDAO();
        
        int operacao = Integer.parseInt(request.getParameter("operacao"));
        int id;
        switch(operacao){
            case 1: // listagem
                request.setAttribute("listaItensCarrinho", car.buscaItensCarrinho());
                RequestDispatcher rd = request.getRequestDispatcher("/checkout.jsp");
                rd.forward(request, response);
                break;
            case 2: // exclusão
                if(car.excluir()){
                     response.sendRedirect("index.jsp");
                }else{
                    response.sendRedirect("index.jsp");                
                }
                break;
            case 3:
                request.setAttribute("listaItensCarrinho", car.buscaItensCarrinho());
                int id_produto = Integer.parseInt(request.getParameter("id_produto"));
                int id_cliente = 1;
                int itens_qtds = Integer.parseInt(request.getParameter("qtd_itens"));
                
                String nome_produto = request.getParameter("nome_produto");
                Double valor_produto = Double.parseDouble(request.getParameter("valor_produto"));
                
                Carrinho carrinho = new Carrinho();
                carrinho.setId_produto(id_produto);
                carrinho.setId_cliente(id_cliente);
                carrinho.setItens_qtd(itens_qtds);
                carrinho.setProdutoNome(nome_produto);
                carrinho.setProdutoValor(valor_produto);
 
                if(car.inserirItensCarrinho(carrinho)){
                     response.sendRedirect("index.jsp");
                }else{
                    response.sendRedirect("index.jsp");                
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
