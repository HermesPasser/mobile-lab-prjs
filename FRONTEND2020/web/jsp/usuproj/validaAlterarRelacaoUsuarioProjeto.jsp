<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    int id = Integer.parseInt(request.getParameter("ID"));
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idProjeto = Integer.parseInt(request.getParameter("ID_PROJETO"));
    boolean isOwner = request.getParameter("PROPRIETARIO") == null ? false : true;

    String pbusca = request.getParameter("PBUSCA");
    UsuarioProjeto usuProj = new UsuarioProjeto(id, idUsuario, idProjeto, isOwner);
    ControleUsuarioProjeto controler = new ControleUsuarioProjeto();
    usuProj = controler.alterarUsuarioProjeto(usuProj);

    String url = "validaConsultarRelacaoUsuarioProjeto.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    