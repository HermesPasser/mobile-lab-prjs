<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>

<%
    String name = request.getParameter("NOME");
    String desc = request.getParameter("DESC");
    String path = request.getParameter("ARCHIVEPATH");
    String scm = request.getParameter("SCM");
    Projeto p = new Projeto(0, name, desc, path, scm);
    ControleProjeto pecont = new ControleProjeto();
    p = pecont.inseriProjeto(p);

    response.sendRedirect("inserirProjeto.jsp");
%>
