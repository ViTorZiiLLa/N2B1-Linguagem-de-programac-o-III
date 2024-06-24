/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author vitor
 */
@WebServlet(urlPatterns = {"/VendaProdutoServlet"})
public class VendaProdutoServlet extends HttpServlet {
     private static final long serialVersionUID = 1L;
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
        PrintWriter out = response.getWriter();

        // Obtendo os parâmetros do formulário
        String nomeProduto = request.getParameter("produto");
        int quantidadeVendida = Integer.parseInt(request.getParameter("quantidade"));

        // Obtendo a lista de produtos do contexto da aplicação
        List<Produto> listaProdutos = (List<Produto>) getServletContext().getAttribute("listaProdutos");

        if (listaProdutos != null && !listaProdutos.isEmpty()) {
            // Buscando o produto na lista pelo nome
            Produto produtoVendido = null;
            for (Produto produto : listaProdutos) {
                if (produto.getNome().equals(nomeProduto)) {
                    produtoVendido = produto;
                    break;
                }
            }

            if (produtoVendido != null) {
                // Verifica se a quantidade em estoque é suficiente para a venda
                if (produtoVendido.getQuantidade() >= quantidadeVendida) {
                    // Realiza a venda subtraindo a quantidade vendida do estoque
                    int novaQuantidade = produtoVendido.getQuantidade() - quantidadeVendida;
                    produtoVendido.setQuantidade(novaQuantidade);
                    // Define a nova quantidade como atributo do request
                    request.setAttribute("novaQuantidade", novaQuantidade);
                    // Redireciona para o JSP de resultado
                    RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
                    dispatcher.forward(request, response);
                } else {
                    out.println("<h1>Erro ao realizar a venda!</h1>");
                    out.println("<p>Quantidade em estoque insuficiente para a venda.</p>");
                }
            } else {
                out.println("<h1>Erro ao realizar a venda!</h1>");
                out.println("<p>Produto não encontrado.</p>");
            }
        } else {
            out.println("<h1>Erro ao realizar a venda!</h1>");
            out.println("<p>Lista de produtos vazia.</p>");
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

