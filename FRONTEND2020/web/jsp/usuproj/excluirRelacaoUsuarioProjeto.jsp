<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioProjeto usuProj = new UsuarioProjeto(id);
    ControleUsuarioProjeto usuProjCont = new ControleUsuarioProjeto();
    usuProj = usuProjCont.excluirUsuarioProjeto(usuProj);
    
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarRelacaoUsuarioProjeto.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

