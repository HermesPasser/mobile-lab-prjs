<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id);
    ControleUsuario usuCont = new ControleUsuario();
    usu = usuCont.buscaUsuarioPorId(usu); // no code tava buscaUsuario mas o meu buscaUsuarioPorId parece fazer o mesmo
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR USUÁRIO</h1>
        <form name="alterarUsuario" action="validaAlterarUsuario.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=usu.getName()%>"> <br>
            Email <input type="text" name="LOGIN" value="<%=usu.getEmail()%>"> <br>
            Senha: <input type="password" name="SENHA" value="<%=usu.getPassword()%>"> <br>
            Tipo: <input type="text" name="TIPO" value="<%=usu.getType()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=usu.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>