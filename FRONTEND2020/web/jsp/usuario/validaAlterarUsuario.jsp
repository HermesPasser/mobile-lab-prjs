<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String name = request.getParameter("NOME");
    String email = request.getParameter("LOGIN");
    String pass = request.getParameter("SENHA");
    String type = request.getParameter("TIPO");
    String pbusca = request.getParameter("PBUSCA");

    Usuario usu = new Usuario(id, name, email, pass, type);
    ControleUsuario usuCont = new ControleUsuario();
    usu = usuCont.alterarUsuario(usu);

    String url = "validaConsultarUsuario.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>