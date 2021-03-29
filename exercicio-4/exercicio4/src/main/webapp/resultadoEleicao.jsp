<%-- 
    Document   : resultadoEleicao
    Created on : 28 de mar. de 2021, 21:32:31
    Author     : Matheus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.exercicio4.Models.Urna"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exercício 3</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.6/css/bootstrap-select.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <header class="mb-5">
            <div class="container">
                <nav class="navbar navbar-expand-lg justify-content-between navbar-dark bg-dark">
                    <a class="navbar-brand" href="#">Eleição para representante de turma</a>
                </nav>
            </div>
        </header>
        <main class="container">
            <div class="text-center">
                <h1>Resultado</h1>
                <%
                    Urna urna = (Urna) request.getAttribute("urna");
                    ArrayList<String> resultado = urna.contaVotos();
                    for(String str : resultado){
                        out.println("<p>"+str+"</p>");
                    }
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
