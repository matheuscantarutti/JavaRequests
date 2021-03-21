/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio1;

import com.mycompany.exercicio1.models.Carro;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.text.NumberFormat;
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
@WebServlet(name = "Servlet", urlPatterns = {"/orcamento"})
public class Servlet extends HttpServlet {

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
            
            if(request.getParameter("btn-submit") != null){
                
                String[] modelPrice = request.getParameter("carro_modelo_preco").split("-");
                
                Carro modelCliente = new Carro(
                    modelPrice[0],
                    Double.parseDouble(modelPrice[1]),
                    Double.parseDouble(request.getParameter("carro_motor")),
                    request.getParameter("carro_fabricacao")
                );
                
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                
                String adicionais[] = request.getParameterValues("adicionais");
                
                ArrayList<String> printaAdicionais = new ArrayList<>();
                ArrayList<Double> valoresAdicionais = new ArrayList<>();
                
                if(request.getParameterValues("adicionais") != null){
                    for(String str : adicionais){
                        String[] arrOfStr = str.split("-");
                    
                        double valor = Double.parseDouble(arrOfStr[1]);
                        
                        printaAdicionais.add("<p>" + arrOfStr[0] + ": " + formatter.format(valor) + "</p>"); 
                    
                        valoresAdicionais.add(valor);                
                    }
                }
                
                
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Orçamento</title>");            
                out.println("<meta http-equiv='Content-Type' content='text/html; charset='UTF-8'>");            
                out.println("</head>");
                out.println("<body style='text-align: center;'>");
                out.println("<h1>Concessionária São José</h1>");
                out.println("<h2>");
                out.println("Orçamento para o modelo " + modelCliente.getModelo());
                out.println("</h2><br>");
                out.println("<p>Preço inicial: R$ " + formatter.format(modelCliente.getPreco()) + "</p>");
                if(!printaAdicionais.isEmpty()){
                    for(String str : printaAdicionais){
                    
                        out.println(str);
                    }
                }
                out.println("<p>I.P.I de " + modelCliente.calculaIpi() + "% já incluso no preço total.</strong></p>");
                out.println("<h3><strong>Preço total: " + formatter.format(modelCliente.calculaPrecoFinal(valoresAdicionais)) + "</strong></h3>");
                out.println("<a href='index.html'>Retorne à página inicial</a>");
                out.println("</body>");
                out.println("</html>");
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

