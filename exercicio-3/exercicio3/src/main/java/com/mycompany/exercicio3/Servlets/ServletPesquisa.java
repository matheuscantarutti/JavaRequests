/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio3.Servlets;

import com.mycompany.exercicio3.Models.Pesquisa;
import com.mycompany.exercicio3.Models.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
@WebServlet(name = "ServletPesquisa", urlPatterns = {"/ServletPesquisa"})
public class ServletPesquisa extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            
            
           
            Pessoa p = new Pessoa(
                    (String) request.getParameter("user-cpf"),
                    request.getParameter("user-gender"),
                    request.getParameter("user-hair"),
                    request.getParameter("user-eyes"),
                    Integer.parseInt(request.getParameter("user-age")),
                    Integer.parseInt(request.getParameter("user-height"))
            );
            
            
            if(request.getSession(false) == null){
                ArrayList<Pessoa> entrevistados = new ArrayList<>();
                Pesquisa pesquisa = new Pesquisa(entrevistados);
                pesquisa.addEntrevistado(p);
                request.getSession().setAttribute("pesquisa", pesquisa);
                response.sendRedirect("ResultadoPesquisa.jsp?total="+pesquisa.getEntrevistados().size());
            } else{
                Pesquisa pesquisa = (Pesquisa) request.getSession().getAttribute("pesquisa");
                pesquisa.addEntrevistado(p);
                request.getSession().removeAttribute("pesquisa");
                request.getSession().setAttribute("pesquisa", pesquisa);
                response.sendRedirect("ResultadoPesquisa.jsp?total="+pesquisa.getEntrevistados().size());
            }
            
            
            
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
