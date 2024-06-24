/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vitor
 */
@WebServlet(urlPatterns = {"/EstoqueServlet"})
public class EstoqueServlet extends HttpServlet {
    private List<Produto> listaProdutos;
    @Override
    public void init() throws ServletException {
        super.init();
        listaProdutos = new ArrayList<>(); // Inicialize a lista aqui
    }
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
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        String categoria = request.getParameter("categoria");
        String id = UUID.randomUUID().toString();
        Produto produto = new Produto(id, nome, descricao, quantidade, preco, categoria);
        List<Produto> listaProdutos = (List<Produto>) getServletContext().getAttribute("listaProdutos");
        
        // Verifica se a lista de produtos já foi inicializada
        if (listaProdutos == null) {
            listaProdutos = new ArrayList<>();
        }
        
        // Adicionando o produto à lista de produtos
        listaProdutos.add(produto);
        
        // Atualizando a lista de produtos no contexto da aplicação
        getServletContext().setAttribute("listaProdutos", listaProdutos);
        request.setAttribute("listaProdutos", listaProdutos);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
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
