

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.to.Matricula"%>
<%@page import="edu.manager.MatriculaManager"%>
<%
    int id = Integer.parseInt(request.getParameter("id_mat"));
    Matricula mat = null;
    String opt = "";
    if (id != 0) {
        opt = "Atualizar";
        out.print("<h3>Editar Matricula</h3>");
        MatriculaManager matrma = new MatriculaManager();
        mat = matrma.buscarPorId(id);
    } else {
        opt = "Registrar";
        out.print("<h3>Incluir Matricula</h3>");

    }
%>

<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">
        <form method="POST" action="MatriculaServlet" id="formulario" class="form-inline" role="form"> 
            <input type="hidden" name="opt" value="<%=opt%>"/>
            <input type="hidden" name="id" value="<%=id%>"/>
            
            <div class="control-group">
                <label class="control-label">Matricula: </label>
                <div class="controls">
                    <input type="text" name="txtidMatricula" value="<%=(mat != null) ? mat.getIdMatricula() : ""%>" placeholder="Matricula"/>
                </div>
            </div>

            
            <div class="control-group">
                <label class="control-label">Data Matricula: </label>
                <div class="controls">
                    <input type="text" name="txtdataMatricula" value="<%=(mat != null) ? mat.getDataMatricula(): ""%>" placeholder="Data Matricula"/>
                </div>
            </div>
            
            <div class="input-group input-group-lgp">
                <label class="sr-only" for="inputnome">Classe :</label>
                <div class="controls">
                    <input class="form-control input-lg" type="text" name="txtidClasse" value="<%=(mat != null) ? mat.getIdClasse(): ""%>" placeholder="Classe"/>
                </div>
            </div>   
            <div class="control-group">
                <label class="control-label">Periodo Letivo:</label>
                <div class="controls">
                    <input type="text" name="txtidPletivo" value="<%=(mat != null) ? mat.getIdPletivo(): ""%>" placeholder="Periodo Letivo" />
                </div>
        
           
    <div class="control-group">
                <label class="control-label">Situação:</label>
                <div class="controls">
                    <input type="text" name="txtidSituacao" value="<%=(mat != null) ? mat.getIdSituacao(): ""%>" placeholder="Situação" />
                </div>
            </div>
                    </div>
               <div class="control-group">
                <label class="control-label">Unidade:</label>
                <div class="controls">
                    <input type="text" name="txtidUnidade" value="<%=(mat != null) ? mat.getIdUnidade(): ""%>" placeholder="Unidade" />
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
                txtidMatricula: {
                    minlength: 3,
                    required: true
                },
                txtdataMatricula: {
                    minlength: 3,
                    required: true  
                txtdataTransferencia: {
                    minlength: 2,
                    required: true,
                    digits: true
                },
                txtidClasse: {
                    minlength: 2,
                    required: true,
                    digits: true
                },
                txtidPletivo {
                    minlength: 2,
                    required: true
                },
                txtidSituacao: {
                    minlength: 2,
                    required: true,
                    digits: true
                },
                txtidUnidade: {
                    minlength: 2,
                    required: true,
                    digits: true

            },
            messages: {
                txtnome: {
                    required: "É necessário registrar a matricula",
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
                msg = confirm('\Deseja realmente registrar  matricula?');
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