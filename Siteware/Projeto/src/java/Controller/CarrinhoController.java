/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CarrinhoDAO;
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
                id = Integer.parseInt(request.getParameter("id"));
                if(car.excluir(id)){
                     response.sendRedirect("resultadoAluguel.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultadoAluguel.jsp?operacao=2");                
                }
            case 3:
                RequestDispatcher rd2 = request.getRequestDispatcher("/checkout.jsp");
                rd2.forward(request, response);
                
                String nome = request.getParameter("nome");
                Double valor = Double.parseDouble(request.getParameter("valor"));
                int idPromocao = Integer.parseInt(request.getParameter("id_promocao"));
                
                Carrinho car = new Carrinho();
                
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
