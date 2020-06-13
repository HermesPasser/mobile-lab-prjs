<%@page import="java.util.List"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String name = request.getParameter("NOME");
    Usuario usu = new Usuario(0, name, "");
    ControleUsuario usucont = new ControleUsuario();
    List<Usuario> usus = usucont.listUser(usu);
    Usuario loggedUser = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usu.getName() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Login">Login</th>
                  <th data-field="Login">Nome</th>
                  <th data-field="Senha">Senha</th>
                  <th data-field="Tipo">Tipo</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(usus.isEmpty())) { %>    
                <tbody>
                    <% for (Usuario user : usus) { %>
                        <tr>
                            <td><%=user.getId()%></td>
                            <td><%=user.getName()%></td>
                            <td><%=user.getEmail()%></td>
                            <td><%=user.getPassword()%></td>
                            <td><%=user.getType()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="excluirUsuario.jsp?<%=url + user.getId()%>">Excluir</a></td>
                                <td><a href="alterarUsuario.jsp?<%=url + user.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>