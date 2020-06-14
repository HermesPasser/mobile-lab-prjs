<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>

<%
    String idString = request.getParameter("ID");
    int id = Integer.parseInt(idString);
    Projeto proj = new Projeto(id);
    ControleProjeto pesCont = new ControleProjeto();
    proj = pesCont.buscarProjeto(proj);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - PROJETO</title>
    <body>
       <div class="container"/>
        <h1>ALTERAR PROJETO</h1>
            <form name="alterarUsuario" action="validaAlterarProjeto.jsp" method="post">
                Nome: <input type="text" name="NOME" value="<%=proj.getName()%>"> <br>
                Descrição <input type="text" name="DESC" value="<%=proj.getDescription()%>"> <br>
                Caminho do arquivo <input type="text" name="ARCHIVEPATH" value="<%=proj.getArchiveFilename()%>"> <br>
                Tipo de Controle de versão <input type="text" name="SCM" value="<%=proj.getScmType()%>"> <br>
                <input type="HIDDEN" name="ID" value="<%=proj.getId()%>"> <br>
                <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
                <input type="submit" name="Enviar" value="OK">
            </form>
        <div>
    </body>
</html>