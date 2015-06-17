<%-- 
    Document   : curso_list
    Created on : 16/06/2015, 16:05:58
    Author     : Pati
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.to.Curso"%>
<%@page import="edu.manager.CursoManager"%>

<p><a href="javascript:fn_mostrar(0)" class="btn btn-primary">Incluir Curso</a></p>
<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">      
        <div align="center" class="table table-bordered table-striped">              
            <table border="1" class="table">               
                <thead>
                    <tr>
                       
                        <th>Id Curso</th>
                        <th>Nome</th>
                        
                    </tr>
                </thead>    
                <tbody>
                    <%
                        CursoManager curma = new CursoManager();
                        List<Curso> lista = curma.listar();
                        for (Curso u : lista) {
                    %>
                    <tr>
                        <td><%=u.getIdCurso()%></td>
                        <td><%=u.getNome()%></td>
                        

                        <td><a href="javascript:fn_mostrar(<%=u.getIdCurso()%>)" class="menuitem"><img src="resources/img/figuras/editar.png"></a></td>
                        <td><a href="javascript:fn_eliminar(<%=u.getIdCurso()%>)" class="menuitem"><img src="resources/img/figuras/eliminar.png"></a></td>
                    </tr>                    
                    <%}%>
                </tbody>
                
            </table>
        </div>
    </div></div>                   
<script type="text/javascript">
    function fn_mostrar(Curso) {
        $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
        $.post('jsp/curso_add.jsp', {id_cur: Curso}, function (data) {
            $('#contenido').html(data);
        });
    }
    function fn_eliminar(curso) {
        if (confirm("Deseja eliminar esse registro?")) {
            $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
            $.post('CursoServlet', {id_cur: curso, opt: "Eliminar"}, function (data) {
                $("#contenido").load("jsp/curso_list.jsp");
            });
        } else {
            false;
        }
    }
</script>