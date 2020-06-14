<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - PROJETO</title>
    <body>
       <div class="container"/>
            <h1>INSERIR PROJETO</h1>
            <form name="inserirUsuario" action="validaInserirProjeto.jsp" method="post">
                Nome: <input type="text" name="NOME" value=""> <br>
                Descrição <input type="text" name="DESC" value=""> <br>
                Caminho do arquivo <input type="text" name="ARCHIVEPATH" value=""> <br>
                Tipo de Controle de versão <input type="text" name="SCM" value=""> <br>
                <input type="submit" name="Enviar" value="OK">
            </form>
        </div>
    </body>
</html>
