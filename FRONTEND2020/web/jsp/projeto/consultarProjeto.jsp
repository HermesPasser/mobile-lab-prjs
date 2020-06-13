<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - PROJETO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR PROJETO</h1>
       <form name="consultarProjeto" action="validaConsultarProjeto.jsp" method="post">
           Name: <input type="text" name ="NOME" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
