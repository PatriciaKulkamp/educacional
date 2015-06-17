<%-- 
    Document   : curso_add
    Created on : 16/06/2015, 16:05:39
    Author     : Pati
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.to.Curso"%>
<%@page import="edu.manager.CursoManager"%>
<%
    int id = Integer.parseInt(request.getParameter("id_cur"));
    Curso cur = null;
    String opt = "";
    if (id != 0) {
        opt = "Atualizar";
        out.print("<h3>Editar Curso</h3>");
        CursoManager curma = new CursoManager();
        cur = curma.buscarPorId(id);
    } else {
        opt = "Registrar";
        out.print("<h3>Incluir Curso</h3>");

    }
%>

<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">
        <form method="POST" action="PessoaServlet" id="formulario" class="form-inline" role="form"> 
            <input type="hidden" name="opt" value="<%=opt%>"/>
            <input type="hidden" name="id" value="<%=id%>"/>
            
            <div class="control-group">
                <label class="control-label">Curso: </label>
                <div class="controls">
                    <input type="text" name="txtidCurso" value="<%=(cur != null) ? cur.getIdCurso() : ""%>" placeholder="ID"/>
                </div>
            </div>

            
            <div class="control-group">
                <label class="control-label">Nome: </label>
                <div class="controls">
                    <input type="text" name="txtnome" value="<%=(cur != null) ? cur.getNome() : ""%>" placeholder="Nome"/>
                </div>
            </div>
            
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-primary"><%=opt%></button>
                </div>
            </div>
        </form>            
    </div>
    <div id="msg"></div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#formulario').validate({
            errorElement: "span",
            rules: {
                txtidCurso: {
                    minlength: 3,
                    required: true
                },
                txtnome: {
                    minlength: 3,
                    required: true  
                },
            messages: {
                txtnome: {
                    required: "É necessário registrar o o nome do curso",
                    minlength: jQuery.format("São necessários {0} caracteres!")
                }
            },
            highlight: function (element) {
                $(element).closest('.control-group')
                        .removeClass('success').addClass('error');
            },
            success: function (element) {
                element
                        .text('OK!').addClass('help-inline')
                        .closest('.control-group')
                        .removeClass('error').addClass('success');
            },
            submitHandler: function () {
                msg = confirm('\Deseja realmente registrar  curso?');
                if (msg) {
                    $.ajax({
                        type: 'POST',
                        url: $("#formulario").attr('action'),
                        data: $("#formulario").serialize(),
                        //beforeSend: loading,					
                        success: function (data) {
                            $("#msg").html(data);
                        }
                    });
                    return false;
                }
            }
        });
    });
</script>