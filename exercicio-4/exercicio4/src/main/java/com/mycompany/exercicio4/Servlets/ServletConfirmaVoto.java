/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio4.Servlets;

import com.mycompany.exercicio4.Models.Urna;
import com.mycompany.exercicio4.Models.Voto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
@WebServlet(name = "ConfirmaVoto", urlPatterns = {"/ConfirmaVoto"})
public class ServletConfirmaVoto extends HttpServlet {

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
           
            String btn = request.getParameter("btn-submit");
            
            if(btn.equals("enviaVoto")){
                String eleitor = request.getParameter("nome-eleitor");
                String candidato = request.getParameter("nome-candidato");
                
                Voto vt = new Voto(eleitor, candidato);
                
                if(request.getSession(false) == null){
                    ArrayList<Voto> votos = new ArrayList<>();
                    Urna urna = new Urna(votos);
                    urna.addVoto(vt);
                    request.getSession().setAttribute("urna", urna);
                    out.println("<div style='text-align: center;'>");
                    out.println("<h1 class='text-center'>Voto salvo com sucesso!</h1>");
                    out.println("<a href='index.html' class='btn btn-primary'>Voltar para votação</a>");
                    out.println("</div>");
                } else{
                    Urna urna = (Urna) request.getSession().getAttribute("urna");
                    if(urna.confereVoto(eleitor) == 1){
                        urna.addVoto(vt);
                        request.getSession().removeAttribute("urna");
                        request.getSession().setAttribute("urna", urna);
                        out.println("<div style='text-align: center;'>");
                        out.println("<h1>Voto salvo com sucesso!</h1>");
                        out.println("<a href='index.html' class='btn btn-primary'>Voltar para votação</a>");
                        out.println("</div>");
                    }else{
                        out.println("<div style='text-align: center;'>");
                        out.println("<h1 class='text-center'>Voto inválido! "+eleitor+" já possui voto salvo</h1>");
                        out.println("<a href='index.html' class='btn btn-primary'>Voltar para votação</a>");
                        out.println("</div>");
                    }
                }
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
