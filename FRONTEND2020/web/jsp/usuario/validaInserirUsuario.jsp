<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>

<%
    String name = request.getParameter("NOME");
    String email = request.getParameter("LOGIN");
    String pass = request.getParameter("SENHA");
    String type = request.getParameter("TIPO");
    Usuario usu = new Usuario(0, name, email, pass, type);
    ControleUsuario usucont = new ControleUsuario();
    usu = usucont.insertUser(usu);

    response.sendRedirect("inserirUsuario.jsp");
%>
