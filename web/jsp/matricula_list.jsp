
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.to.Matricula"%>
<%@page import="edu.manager.MatriculaManager"%>

<p><a href="javascript:fn_mostrar(0)" class="btn btn-primary">Incluir Matricula</a></p>
<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">      
        <div align="center" class="table table-bordered table-striped">              
            <table border="1" class="table">               
                <thead>
                    <tr>
                       
                        <th> Matricula</th>
                        <th>Data MAtricula</th>
                        <th>Classe</th>
                        <th>Periodo Letivo</th>
                        <th>Situação</th>
                        <th>Unidade</th>
                    </tr>
                </thead>    
                <tbody>
                    <%
                        MatriculaManager matrma = new MatriculaManager();
                        List<Matricula> lista = matrma.listar();
                        for (Matricula u : lista) {
                    %>
                    <tr>
                        <td><%=u.getIdMatricula()%></td>
                        <td><%=u.getDataMatricula()%></td>
                        <td><%=u.getIdClasse()%></td>
                        <td><%=u.getIdPletivo()%></td>
                        <td><%=u.getIdSituacao()%></td>
                        <td><%=u.getIdUnidade()%></td>

                        <td><a href="javascript:fn_mostrar(<%=u.getIdMatricula()%>)" class="menuitem"><img src="resources/img/figuras/editar.png"></a></td>
                        <td><a href="javascript:fn_eliminar(<%=u.getIdMatricula()%>)" class="menuitem"><img src="resources/img/figuras/eliminar.png"></a></td>
                    </tr>                    
                    <%}%>
                </tbody>
                
            </table>
        </div>
    </div></div>                   
<script type="text/javascript">
    function fn_mostrar(matricula) {
        $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
        $.post('jsp/matricula_add.jsp', {id_mat: matricula}, function (data) {
            $('#contenido').html(data);
        });
    }
    function fn_eliminar(matricula) {
        if (confirm("Deseja eliminar esse registro?")) {
            $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
            $.post('MatriculaServlet', {id_mat: matricula, opt: "Eliminar"}, function (data) {
                $("#contenido").load("jsp/matricula_list.jsp");
            });
        } else {
            false;
        }
    }
</script>