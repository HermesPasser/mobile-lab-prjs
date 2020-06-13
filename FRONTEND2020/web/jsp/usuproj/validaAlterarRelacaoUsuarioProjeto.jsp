<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idProjeto = Integer.parseInt(request.getParameter("ID_PROJETO"));
    String pbusca = request.getParameter("PBUSCA");
    UsuarioProjeto usuProj = new UsuarioProjeto(id, idUsuario, idProjeto);
    ControleUsuarioProjeto controler = new ControleUsuarioProjeto();
    usuProj = controler.alterarUsuarioProjeto(usuProj);

    String url = "validaConsultarRelacaoUsuarioProjeto.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    