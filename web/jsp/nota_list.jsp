
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.to.Nota"%>
<%@page import="edu.manager.NotaManager"%>

<p><a href="javascript:fn_mostrar(0)" class="btn btn-primary">Incluir Nota</a></p>
<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">      
        <div align="center" class="table table-bordered table-striped">              
            <table border="1" class="table">               
                <thead>
                    <tr>
                       
                        <th>ID</th>
                        <th>Matricula</th>
                        <th>Disciplina</th>
                        <th>Nota</th>
                        
                     </tr>
                </thead>    
                <tbody>
                    <%
                       NotaManager notma = new NotaManager();
                        List<Nota> lista = notma.listar();
                        for (Nota u : lista) {
                    %>
                    <tr>
                        <td><%=u.getIdNota()%></td>
                        <td><%=u.getIdMatricula()%></td>
                        <td><%=u.getIdDisciplina()%></td>
                        <td><%=u.getNota()%></td>
                        
                        <td><a href="javascript:fn_mostrar(<%=u.getIdNota()%>)" class="menuitem"><img src="resources/img/figuras/editar.png"></a></td>
                        <td><a href="javascript:fn_eliminar(<%=u.getIdNota()%>)" class="menuitem"><img src="resources/img/figuras/eliminar.png"></a></td>
                    </tr>                    
                    <%}%>
                </tbody>
                
            </table>
        </div>
    </div></div>                   
<script type="text/javascript">
    function fn_mostrar(Nota) {
        $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
        $.post('jsp/nota_add.jsp', {id_nota: Nota}, function (data) {
            $('#contenido').html(data);
        });
    }
    function fn_eliminar(nota) {
        if (confirm("Deseja eliminar esse registro?")) {
            $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
            $.post('NotaServlet', {id_nota: nota, opt: "Eliminar"}, function (data) {
                $("#contenido").load("jsp/nota_list.jsp");
            });
        } else {
            false;
        }
    }
</script>