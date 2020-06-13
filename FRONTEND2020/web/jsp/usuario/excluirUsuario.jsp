<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id);
    ControleUsuario usuCont = new ControleUsuario();
    usu = usuCont.excluirUsuario(usu);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarUsuario.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>