<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Projeto pr = new Projeto(id);
    ControleProjeto con = new ControleProjeto();
    
    String url = "../erroEntidadeEmRelacao.jsp";
    
    if (new ControleUsuarioProjeto().projetoIsOwnedByNoUsuarios(pr)) {
           pr = con.excluiProjeto(pr);
           String pbusca = request.getParameter("PBUSCA");
           url = "validaConsultarProjeto.jsp?NOME=" + pbusca;
    } 
    
    response.sendRedirect(url);
%>