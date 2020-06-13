<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>

<%
    String name = request.getParameter("NOME");
    Projeto  pr = new Projeto (0,name, "", "", "");
    ControleProjeto controler = new ControleProjeto();
    List<Projeto> prs = controler.listProjeto(pr); 
    Usuario loggedUser = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + pr.getName() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Desc">Descrição</th>
                  <th data-field="ArchivePath">Caminho do arquivo</th>
                  <th data-field="ScmType">Tipo de Controle de Versão</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(prs.isEmpty())) { %>    
                <tbody>
                    <% for (Projeto p : prs) { %>
                        <tr>
                            <td><%=p.getId()%></td>
                            <td><%=p.getName()%></td>
                            <td><%=p.getDescription()%></td>
                            <td><%=p.getArchiveFilename()%></td>
                            <td><%=p.getScmType()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="excluirProjeto.jsp?<%=url + p.getId()%>">Excluir</a></td>
                                <td><a href="alterarProjeto.jsp?<%=url + p.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>