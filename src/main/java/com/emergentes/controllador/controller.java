package com.emergentes.controllador;

import com.emergentes.modelo.gestortareas;
import com.emergentes.modelo.tarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        tarea objtarea = new tarea();
        int id;
        int pos;
        String opcion = request.getParameter("op");
        String op = (opcion != null) ? request.getParameter("op") : "view";

        if (op.equals("nuevo")) {
            HttpSession ses = request.getSession();
            gestortareas agenda = (gestortareas) ses.getAttribute("agenda");
            objtarea.setId(agenda.obtieneid());
            request.setAttribute("op", op);
            request.setAttribute("mitarea", objtarea);
            request.getRequestDispatcher("editar.jsp").forward(request, response);

        }
        if (op.equals("modificar")) {
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            gestortareas agenda = (gestortareas) ses.getAttribute("agenda");
            pos = agenda.ubicartarea(id);
            objtarea = agenda.getLista().get(pos);
            request.setAttribute("op", op);
            request.setAttribute("mitarea", objtarea);
            request.getRequestDispatcher("editar.jsp").forward(request, response);

        }
        if(op.equals("eliminar")){
         id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            gestortareas agenda = (gestortareas) ses.getAttribute("agenda");
            pos = agenda.ubicartarea(id);
            agenda.eliminartarea(pos);
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
            

        }
        if(op.equals("view")){
        response.sendRedirect("index.jsp");}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    tarea objtarea = new tarea();
    int pos;
    String op= request.getParameter("op");
    if(op.equals("grabar")){
    objtarea.setId(Integer.parseInt(request.getParameter("id")));
    objtarea.setTarea(request.getParameter("tarea"));
    objtarea.setPrioridad(request.getParameter("prioridad"));
    
    HttpSession ses=request.getSession();
    gestortareas agenda=(gestortareas) ses.getAttribute("agenda");
    
    String opg=request.getParameter("opg");
    if(opg.equals("nuevo")){
    agenda.insertartarea(objtarea);}
    else{
    pos = agenda.ubicartarea(objtarea.getId());
    agenda.modificartarea(pos, objtarea);}
    ses.setAttribute("agenda",agenda);
    response.sendRedirect("index.jsp");
    }
    }

   
    
}
