<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- %@include file="../../inc/materalizeWeb.inc" % -->
    <title>CONSULTAR - USUÁRIO-PROJETO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR USUÁRIO-PROJETO</h1>
       <form name="consultarUsuario" action="validaConsultarRelacaoUsuarioProjeto.jsp" method="post">
            È o dono do projeto: 
            <label>
                <input type="checkbox" name ="PROPRIETARIO" checked>
            </label>

            <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
        <button  onclick="history.back()" >Voltar</button> 
       </div>
    </body>
</html>
