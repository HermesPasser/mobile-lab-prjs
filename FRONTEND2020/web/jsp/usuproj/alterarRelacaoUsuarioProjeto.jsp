<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sourcecodeplataform.bean.UsuarioProjeto"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuarioProjeto"%>
<%@page import="java.util.List"%>

<%
    ControleUsuario usuCont = new ControleUsuario();
    List<Usuario> usus = usuCont.listAllUsers();

    ControleProjeto pesCont = new ControleProjeto();
    List<Projeto> projects = pesCont.listAllProjetos();

    int id = Integer.parseInt(request.getParameter("ID"));
    
    UsuarioProjeto usuProj = new UsuarioProjeto(id);
    usuProj = new ControleUsuarioProjeto().buscarUsuarioProjeto(usuProj);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <!-- %@include file="../../inc/materalizeWeb.inc" % -->
    <title>ALTERAR - USUÁRIO PROJETO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - USUÁRIO materalizeWeb</h1>
        <form name="alterarUsuarioProjeto" action="validaAlterarRelacaoUsuarioProjeto.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <% if( usu.getId() == usuProj.getUsuarioId() ) { %>
                                        <option selected value="<%=usu.getId()%>"><%=usu.getName()%></option>
                                    <% } else { %>
                                        <option value="<%=usu.getId()%>"><%=usu.getName()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Projeto: </td>
                        <td>
                            <select NAME ="ID_PROJETO" class="browser-default">
                                <% for (Projeto p : projects) { %>
                                    <% if( p.getId()== usuProj.getProjetoId() ) { %>
                                        <option selected value="<%=p.getId()%>"><%=p.getName()%></option>
                                    <% } else { %>
                                        <option value="<%=p.getId()%>"><%=p.getName()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                </table>    
                 <input type="checkbox" name ="PROPRIETARIO" 
                         <% if(usuProj.itIsOwner() ) { %>
                            checked
                        <% } %>
                 />
            <input type="HIDDEN" name="ID" value="<%=usuProj.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>