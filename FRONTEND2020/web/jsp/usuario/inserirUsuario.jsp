<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - USUÁRIO</title>
    <body>
       <div class="container"/>
            <h1>INSERIR USUÁRIO</h1>
            <form name="inserirUsuario" action="validaInserirUsuario.jsp" method="post">
                Nome: <input type="text" name="NOME" value=""> <br>
                Email <input type="text" name="LOGIN" value=""> <br>
                Senha: <input type="password" name="SENHA" value=""> <br>
                Tipo: <input type="text" name="TIPO" value=""> <br>
                <input type="submit" name="Enviar" value="OK">
            </form>
        </div>
    </body>
</html>
