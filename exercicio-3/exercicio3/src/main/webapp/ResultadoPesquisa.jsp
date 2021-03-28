<%-- 
    Document   : resultadoPesquisa
    Created on : 27 de mar. de 2021, 17:50:18
    Author     : Matheus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.exercicio3.Models.Pessoa"%>
<%@page import="com.mycompany.exercicio3.Models.Pesquisa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Resultados da Pesquisa</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.6/css/bootstrap-select.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <header class="mb-5">
            <div class="container">
                <nav class="navbar navbar-expand-lg justify-content-between navbar-dark bg-dark">
                    <a class="navbar-brand" href="#">Resultados</a>
                    <div class="" id="navbarNavAltMarkup">
                        <a href="index.html">Home</a>
                    </div>
                </nav>
            </div>
        </header>
        <main class="container">
            <div class="d-flex flex-column text-center">
                 <%
                     Pesquisa pesquisa = (Pesquisa) session.getAttribute("pesquisa");
                     int total = Integer.parseInt(request.getParameter("total"));
                     
                    out.println("<h1>Resultados</h1><br>");
                    out.println("<p>Quantidade de habitantes pesquisados - <strong>" + total + " </strong></p><br>");
                    out.println("<p>Maior altura - <strong>" + pesquisa.maiorAltura() + " centímetros</strong></p><br>");
                    out.println("<p>Menor altura - <strong>" + pesquisa.menorAltura() + " centímetros</strong></p><br>");
                    out.println("<p>Média de altura das mulheres - <strong>" + pesquisa.mediaAlturaFeminina()+ " centímetros</strong></p><br>");
                    out.println("<p>Número de homens - <strong>" + pesquisa.qtdMasculino()+ "</strong></p><br>");
                    out.println("<p>Percentual de Homens - <strong>" + pesquisa.percentualMasculino()+ "</strong></p><br>");
                    out.println("<p>Percentual de Mulheres- <strong>" + pesquisa.percentualFeminino()+ "</strong></p><br>");
                    out.println("<p>Percentual de Mulheres com idade entre 18 e 35, com olhos verdes e cabelos loiros- <strong>" 
                                    + pesquisa.adultasEscandinavas()+ "</strong></p><br>");
                 %>
            </div>
          
        </main>


        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.6/js/bootstrap-select.min.js"></script>
        <script>
           
        </script>
    </body>
</html>

