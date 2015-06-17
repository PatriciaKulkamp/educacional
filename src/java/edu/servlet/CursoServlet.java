/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servlet;

import edu.manager.CursoManager;
import edu.to.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Pati
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
          String opt=request.getParameter("opt");

          if(opt.equals("Registrar")){
            int id=Integer.parseInt(request.getParameter("txtidCurso"));
            String nome=request.getParameter("txtnome");
            
            
           
            Curso curso = new Curso(id,nome);
            
            try {        
                CursoManager curma = new CursoManager();
                boolean result = curma.registrar(curso);            
                if(result){
                    out.println("<h2 align='center'>Registrado com Sucesso</h2>");
                }else{
                    out.println("<h2 align='center'>Registro Insatisfatorio</h2>");
                }
            } finally {            
                out.close();
            }
                        
          }
          
          
          
          if(opt.equals("Atualizar")){

            int id=Integer.parseInt(request.getParameter("id"));
            String nome=request.getParameter("txtnome");
            
            Curso curso = new Curso(id,nome);
            curso.setIdCurso(id);
            
            try {        
               CursoManager curma = new CursoManager();
                boolean result = curma.registrar(curso);            
                if(result){
                    out.println("<h2 align='center'>Registrado com Sucesso</h2>");
                }else{
                    out.println("<h2 align='center'>Registro Insatisfatorio</h2>");
                }
            }catch(Exception e){
                out.println(e.getMessage());
            }finally {            
                out.close();
            }
          }
          
          if(opt.equals("Eliminar")){
              int id=Integer.parseInt(request.getParameter("id_pes"));
              
             try {        
               CursoManager curma = new CursoManager();
                boolean result = curma.eliminar(id);            
                if(result){
                    out.println("<h1 align='center'>Registro Eliminado</h1>");
                }else{
                    out.println("<h1 align='center'>Erro: Não processado</h1>");
                }
            } finally {            
                out.close();
            }
          }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
