<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idProjeto = Integer.parseInt(request.getParameter("ID_PROJETO"));
    
    UsuarioProjeto up = new UsuarioProjeto(0, idUsuario, idProjeto);
    ControleUsuarioProjeto usupescont = new ControleUsuarioProjeto();
    up = usupescont.inserirUsuarioProjeto(up);
    
    response.sendRedirect("inserirRelacaoUsuarioProjeto.jsp");
%>