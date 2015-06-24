
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.to.Nota"%>
<%@page import="edu.manager.NotaManager"%>
<%
    int id = Integer.parseInt(request.getParameter("id_not"));
    Nota not = null;
    String opt = "";
    if (id != 0) {
        opt = "Atualizar";
        out.print("<h3>Editar Nota</h3>");
        NotaManager notma = new NotaManager();
        not = notma.buscarPorId(id);
    } else {
        opt = "Registrar";
        out.print("<h3>Incluir Nota</h3>");

    }
%>

<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">
        <form method="POST" action="NotaServlet" id="formulario" class="form-inline" role="form"> 
            <input type="hidden" name="opt" value="<%=opt%>"/>
            <input type="hidden" name="id" value="<%=id%>"/>
            
            <div class="control-group">
                <label class="control-label">Id: </label>
                <div class="controls">
                    <input type="text" name="txtidnota" value="<%=(not != null) ? not.getIdNota(): ""%>" placeholder="ID"/>
                </div>
            </div>
                
            <div class="control-group">
                <label class="control-label">Id Matricula: </label>
                <div class="controls">
                    <input type="text" name="txtidmatricula" value="<%=(not != null) ? not.getIdMatricula(): ""%>" placeholder="Matricula"/>
                </div>
           </div>
                
                <div class="control-group">
                <label class="control-label">Id Disciplina </label>
                <div class="controls">
                    <input type="text" name="txtiddisciplina" value="<%=(not != null) ? not.getIdDisciplina(): ""%>" placeholder="Disciplina"/>
                </div>
           </div>

            
            <div class="control-group">
                <label class="control-label">Nota: </label>
                <div class="controls">
                    <input type="text" name="txtnota" value="<%=(not != null) ? not.getNota(): ""%>" placeholder="Nota"/>
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
                txtidnota: {
                    minlength: 3,
                    required: true
                },
                 txtidmatricula: {
                    minlength: 3,
                    required: true
                },
                 txtiddisciplina: {
                    minlength: 3,
                    required: true
                },
                txtnome: {
                    minlength: 3,
                    required: true  
                
            },
            messages: {
                txtnota: {
                    required: "É necessário registrar uma nota",
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
                msg = confirm('\Deseja realmente registrar  nota?');
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