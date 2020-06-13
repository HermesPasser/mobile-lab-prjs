<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>

<%
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idProjeto = Integer.parseInt(request.getParameter("ID_PROJETO"));
    
    UsuarioProjeto usupes = new UsuarioProjeto(0, idUsuario, idProjeto);
    ControleUsuarioProjeto usupescont = new ControleUsuarioProjeto();
    List<UsuarioProjeto> usuarioProjetos = usupescont.listarUsuarioProjeto(usupes);
    Usuario loggedUser = (Usuario) session.getAttribute("UsuarioLogado");
    
    // isso ta muito usando o obs, se não funfar adicionar isso obs na tabela
    String url = "PBUSCA=&ID=" ; // String url = "PBUSCA=" + usupes.getObs() +"&ID=" ;
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