<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String name = request.getParameter("NOME");
    String desc = request.getParameter("DESC");
    String path = request.getParameter("ARCHIVEPATH");
    String scm = request.getParameter("SCM");

    String pbusca = request.getParameter("PBUSCA");

    Projeto pr = new Projeto(id, name, desc, path, scm);
    ControleProjeto c = new ControleProjeto();
    pr = c.alteraProjeto(pr);

    String url = "validaConsultarProjeto.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>