
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.to.Pessoa"%>
<%@page import="edu.manager.PessoaManager"%>
<%
    int id = Integer.parseInt(request.getParameter("id_pes"));
    Pessoa pes = null;
    String opt = "";
    if (id != 0) {
        opt = "Atualizar";
        out.print("<h3>Editar Pessoa</h3>");
        PessoaManager pesma = new PessoaManager();
        pes = pesma.buscarPorId(id);
    } else {
        opt = "Registrar";
        out.print("<h3>Incluir Pessoa</h3>");

    }
%>

<div class="navbar navbar-fixed-center">
    <div class="navbar-inner">
        <form method="POST" action="PessoaServlet" id="formulario" class="form-inline" role="form"> 
            <input type="hidden" name="opt" value="<%=opt%>"/>
            <input type="hidden" name="id" value="<%=id%>"/>
            
            <div class="control-group">
                <label class="control-label">Pessoa: </label>
                <div class="controls">
                    <input type="text" name="txtpessoa" value="<%=(pes != null) ? pes.getPessoa() : ""%>" placeholder="ID"/>
                </div>
            </div>

            
            <div class="control-group">
                <label class="control-label">CPF: </label>
                <div class="controls">
                    <input type="text" name="txtcpf" value="<%=(pes != null) ? pes.getCpf() : ""%>" placeholder="CPF"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Rg : </label>
                <div class="controls">
                    <input type="text" name="txtrg" value="<%=(pes != null) ? pes.getRg() : ""%>" placeholder="Seu registro geral"/>
                </div>
            </div>
            <div class="input-group input-group-lgp">
                <label class="sr-only" for="inputnome">Nome :</label>
                <div class="controls">
                    <input class="form-control input-lg" type="text" name="txtnome" value="<%=(pes != null) ? pes.getNome() : ""%>" placeholder="Nome"/>
                </div>
            </div>   
            <div class="control-group">
                <label class="control-label">Data de Nascimento:</label>
                <div class="controls">
                    <input type="text" name="txtdatanascimento" value="<%=(pes != null) ? pes.getDataNascimento() : ""%>" placeholder="01/03/1889" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Tipo </label>
                <div class="controls">
                    <input type="radio" name="txttipo" value="2" <%=(pes != null && pes.getTipo() == 2) ? "checked" : ""%> /> Professor 
                    <input type="radio" name="txttipo" value="1" <%=(pes != null && pes.getTipo() == 1) ? "checked" : ""%> /> Aluno        
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
                txtpessoa: {
                    minlength: 3,
                    required: true
                },
                txtcpf: {
                    minlength: 3,
                    required: true  
                txtrg: {
                    minlength: 2,
                    required: true,
                    digits: true
                },
                txtnome: {
                    minlength: 2,
                    required: true,
                    digits: true
                },
                txtdatanascimento: {
                    minlength: 2,
                    required: true
                },
                txttipo: {
                    minlength: 2,
                    required: true,
                    digits: true
                }
            },
            messages: {
                txtnome: {
                    required: "É necessário registrar o o nome da pessoa",
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
                msg = confirm('\Deseja realmente registrar  pessoa?');
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