<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    boolean isOwner = request.getParameter("PROPRIETARIO") == null ? false : true;
    UsuarioProjeto up = new UsuarioProjeto(0, 0, 0, isOwner);
    List<UsuarioProjeto> usuarioProjetos = new ControleUsuarioProjeto().listarUsuarioProjeto(up);
    Usuario loggedUser = (Usuario) session.getAttribute("UsuarioLogado");
    
    String url = "PBUSCA=" + up.itIsOwner() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuProjeto">Id</th>
                  <th data-field="IdProjeto">IdProjeto</th>
                  <th data-field="NomeProjeto">NomeProjeto</th>
                  <th data-field="IdUsuario">IdUsuario</th>
                  <th data-field="NomeUsuario">NomeUsuario</th>
                  <th data-field="Proprietario">É o proprietario do projeto</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(usuarioProjetos.isEmpty())) { %>    
                <tbody>
                    <% for (UsuarioProjeto usuarioProjeto : usuarioProjetos) { %>
                        <tr>
                            <td><%=usuarioProjeto.getId()%></td>
                            <td><%=usuarioProjeto.getProjetoId()%></td>
                            <td><%=usuarioProjeto.getProjeto().getName()%></td>
                            <td><%=usuarioProjeto.getUsuarioId()%></td>
                            <td><%=usuarioProjeto.getUsuario().getName()%></td>
                            <td><%=usuarioProjeto.itIsOwner()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="excluirRelacaoUsuarioProjeto.jsp?<%=url + usuarioProjeto.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoUsuarioProjeto.jsp?<%=url + usuarioProjeto.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>   
    </body>
</html>