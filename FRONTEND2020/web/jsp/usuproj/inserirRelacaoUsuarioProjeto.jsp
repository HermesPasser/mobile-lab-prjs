<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.sourcecodeplataform.bean.Projeto"%>
<%@page import="br.com.sourcecodeplataform.bean.Usuario"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleProjeto"%>
<%@page import="br.com.sourcecodeplataform.controler.ControleUsuario"%>

<%
    ControleProjeto conProj = new ControleProjeto();
    List<Projeto> projects = conProj.listAllProjetos();

    ControleUsuario usuCont = new ControleUsuario();
    List<Usuario> usus = usuCont.listAllUsers();

%>

<html>
    <!-- %@include file="../../inc/materalizeWeb.inc" % -->
    <title>INSERIR USUARIO PROJETO</title>
    <body>
        <div class="container"/>
            <h1>Inseri Usuario Projeto</h1>
            <form name="inseriUsuarioProjeto" action="validaRelacaoUsuarioProjeto.jsp" method="POST">
                <table>
                    <tr>
                        <td>Projeto:</td>
                        <td>
                            <select NAME ="ID_PROJETO" class="browser-default">
                                <% for (Projeto pr : projects) { %>
                                    <option value="<%=pr.getId()%>"><%=pr.getName()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <option value="<%=usu.getId()%>"><%=usu.getName()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                </table>  
                È o dono do projeto: 
                    <input type="checkbox" name="PROPRIETARIO" id="check" checked>
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
