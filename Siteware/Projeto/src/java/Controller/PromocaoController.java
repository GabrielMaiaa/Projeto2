/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.PromocaoDAO;
import VO.Promocao;
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
@WebServlet(name = "PromocaoController", urlPatterns = {"/PromocaoController"})
public class PromocaoController extends HttpServlet {

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
        
       PromocaoDAO p = new PromocaoDAO();
        
        int operacao = Integer.parseInt(request.getParameter("operacao"));
        int id;
        switch(operacao){
            case 1: // listagem
                request.setAttribute("listaPromocao", p.buscaPromocao());
                RequestDispatcher rd = request.getRequestDispatcher("/listagemPromocao.jsp");
                rd.forward(request, response);
                break;
            case 2: // exclusão
                id = Integer.parseInt(request.getParameter("id"));
                if(p.excluir(id)){
                     response.sendRedirect("resultadoPromocao.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultadoPromocao.jsp?operacao=2");                
                }
                break;
            case 3: // solicitação de alteraração de registro
                id = Integer.parseInt(request.getParameter("id"));                
                request.setAttribute("promocao", p.localizarRegistro(id));
                RequestDispatcher r = request.getRequestDispatcher("/alteracaoPromocoes.jsp");
                r.forward(request, response);
            case 4: // efetuar a modificação em BD (recebe os dados atualizados e modifica em banco)
                String nomePromoNovo = request.getParameter("nome_promocao");
                int codigo = Integer.parseInt(request.getParameter("id"));
                
                Promocao promocao = new Promocao();
                promocao.setIdPromocao(codigo);
                promocao.setNomePromocao(nomePromoNovo);
                
                PromocaoDAO promoDAO = new PromocaoDAO();
                boolean sucesso = promoDAO.alterar(promocao);
                
                if(sucesso){
                     response.sendRedirect("resultadoPromocao.jsp?operacao=1");
                }else{
                     response.sendRedirect("resultadoPromocao.jsp?operacao=2");                
                }     
                break;
            case 5:  
                RequestDispatcher r2 = request.getRequestDispatcher("/inserirPromocao.jsp");
                r2.forward(request, response);
                String titulo = request.getParameter("nome_promocao");
                Promocao pNovo = new Promocao();
                pNovo.setNomePromocao(titulo);
                if(p.inserirLivro(pNovo)){
                     response.sendRedirect("resultadoPromocao.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultadoPromocao.jsp?operacao=2");                
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
