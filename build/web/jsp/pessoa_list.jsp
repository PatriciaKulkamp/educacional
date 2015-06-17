
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.to.Pessoa"%>
<%@page import="edu.manager.PessoaManager"%>

<p><a href="javascript:fn_mostrar(0)" class="btn btn-primary">Incluir Pessoa</a></p>
<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">      
        <div align="center" class="table table-bordered table-striped">              
            <table border="1" class="table">               
                <thead>
                    <tr>
                       
                        <th>Pessoa</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Nome</th>
                        <th>Data Nascimento</th>
                        <th>Tipo</th>
                    </tr>
                </thead>    
                <tbody>
                    <%
                        PessoaManager pesma = new PessoaManager();
                        List<Pessoa> lista = pesma.listar();
                        for (Pessoa u : lista) {
                    %>
                    <tr>
                        <td><%=u.getPessoa()%></td>
                        <td><%=u.getCpf()%></td>
                        <td><%=u.getRg()%></td>
                        <td><%=u.getNome()%></td>
                        <td><%=u.getDataNascimento()%></td>
                        <td><%=u.getTipo()%></td>

                        <td><a href="javascript:fn_mostrar(<%=u.getPessoa()%>)" class="menuitem"><img src="resources/img/figuras/editar.png"></a></td>
                        <td><a href="javascript:fn_eliminar(<%=u.getPessoa()%>)" class="menuitem"><img src="resources/img/figuras/eliminar.png"></a></td>
                    </tr>                    
                    <%}%>
                </tbody>
                
            </table>
        </div>
    </div></div>                   
<script type="text/javascript">
    function fn_mostrar(Pessoa) {
        $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
        $.post('jsp/pessoa_add.jsp', {id_pes: Pessoa}, function (data) {
            $('#contenido').html(data);
        });
    }
    function fn_eliminar(pessoa) {
        if (confirm("Deseja eliminar esse registro?")) {
            $("#contenido").html('<img src="resources/img/spin.gif"/>Carregando...');
            $.post('PessoaServlet', {id_pes: pessoa, opt: "Eliminar"}, function (data) {
                $("#contenido").load("jsp/pessoa_list.jsp");
            });
        } else {
            false;
        }
    }
</script>