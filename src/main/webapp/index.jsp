<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.tarea"%>
<%@page import="com.emergentes.modelo.gestortareas"%>
<% 
if (session.getAttribute("agenda") == null){
    gestortareas objeto1 = new gestortareas();
    objeto1.insertartarea(new tarea(1,"reunion con estudiantes de la carrera","alta"));
    objeto1.insertartarea(new tarea(2,"estudiar para el examen de programacion","alta"));
    objeto1.insertartarea(new tarea(3,"partido de futsal","baja"));
    
    session.setAttribute("agenda",objeto1);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSTL ===  TAREAS</h1>
        <a href="controller?op=nuevo">Nuevo</a>

        <table border="3">
            <tr>
                <th>id</th>
                <th>tarea</th>
                <th>prioridad</th>
                <th></th>
                <th></th>

            </tr>
            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">
            <tr>
                <td>${item.id}</td>
                <td>${item.tarea}</td>
                <td>${item.prioridad}</td>
                <td><a href="controller?op=modificar&id=${item.id}">modificar</a></td>
                <td><a href="controller?op=eliminar&id=${item.id}">eliminar</a></td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
