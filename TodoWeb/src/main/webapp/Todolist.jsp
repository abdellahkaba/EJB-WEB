<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  --%>
    
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        /* Ajoutez du style selon vos préférences */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
<body>
	  <h2>Créer une nouvelle TodoList</h2>
    <div id="formTodo">
    	 <form action="TodolistServlet" method="post">
        <table>
            <tr>
                <td><label for="name">Nom de la TodoList :</label></td>
                <td><input type="text" id="name" name="name" required></td>
            </tr>
             <tr>
               
                <td><input type="submit" value="Enregistrer"required></td>
            </tr>
        </table>
        </form>
    </div>
   
    
   	<div>
   		<table>	
   			<thead>
   			<tr>
   				<th>Identifiant</th>
   				<th>Nom de todolist</th>
   			</tr>
   		</thead>
   		<tbody>
 		<c:forEach items = "${todolists}" var="td">
   			<tr>
   				<td>${td.id_todoList}</td>
   				<td>${td.name}</td>
   			</tr>
   		</c:forEach>
   		</tbody>
   		</table>
   	</div>
</body>
</html>