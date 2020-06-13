<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - USUÁRIO - PROJETO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR USUÁRIO - materalizeWeb</h1>
       <form name="consultarUsuario" action="validaConsultarRelacaoUsuarioProjeto.jsp" method="post">
           ID USUARIO:  <input type="text" name ="ID_USUARIO" value=""> <br>
           ID PROJETO:  <input type="text" name ="ID_PROJETO" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
