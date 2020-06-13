<%@page import="javafx.util.Pair"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>

<%
    String email = request.getParameter("EMAIL");
    String pass = request.getParameter("SENHA");
    Usuario usu = new Usuario(0, "", email, pass, "");
    ControleUsuario usucont = new ControleUsuario();
    boolean successfullyLogged;

    Pair<Usuario, Boolean> result = usucont.validateUser(usu);
    
    usu = (Usuario) result.getKey();
    successfullyLogged = (boolean) result.getValue();
    if (successfullyLogged)
        session.setAttribute("UsuarioLogado", usu);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    <body>
        <% if (successfullyLogged) { /*tava usu.getStatus().equals(""), provavelmeente devo colocar algo para ver se a senha e login conferem*/ %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Controle de Usuario</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Controle de Usuario & Projeto</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Controle de Projeto</a>

            <% if (usu.getType().equals("ADM")) { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuario </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuario </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuario </a></li>
                </ul>
            <% } %>

            <% if (usu.getType().equals("ADM")) { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../usuproj/inserirRelacaoUsuarioProjeto.jsp"> Inserir UsuarioProjeto </a></li>
                    <li><a href="../usuproj/consultarRelacaoUsuarioProjeto.jsp"> Consultar UsuarioProjeto </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../usuproj/consultarRelacaoUsuarioProjeto.jsp"> Consultar UsuarioProjeto </a></li>
                </ul>
            <% } %>

            <% if (usu.getType().equals("ADM")) { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../projeto/inserirProjeto.jsp"> Inserir Projeto </a></li>
                    <li><a href="../projeto/consultarProjeto.jsp"> Consultar Projeto </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../projeto/consultarProjeto.jsp"> Consultar Projeto </a></li>
                </ul>
            <% } %>
            
        <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
                <p>Verifique se você digitou a senha corretamente<p>
        <% } %>
    </body>
</html>
