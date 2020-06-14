<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id);
    ControleUsuario usuCont = new ControleUsuario();
    String url = "../erroEntidadeEmRelacao.jsp";
    
    if (new ControleUsuarioProjeto().usuarioHasNoProjetos(usu)) {
           usu = usuCont.excluirUsuario(usu);
           String pbusca = request.getParameter("PBUSCA");
           usu = usuCont.excluirUsuario(usu);
           url = "validaConsultarUsuario.jsp?NOME=" + pbusca;
    } 
    
    response.sendRedirect(url);
%>