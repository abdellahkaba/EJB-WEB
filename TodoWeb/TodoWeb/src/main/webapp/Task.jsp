<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
    
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
	 <h2>Créer une nouvelle Tâche</h2>
	 
	 
	      <div id="forTache">
    	 <form action="TaskServlet" method="post">
    	 		<label for="post_task">Nom de la post :</label>
                <input type="text" id="post_task" name="post_task" required /> <br> <br>
		        <label for="todolist_id">Type de TodoList :</label>
		        <select name="todolist_id">
		        	<option value="">----Choisir un type de todolist----</option>
            		<c:forEach var="td" items="${todolists}">
                		<option value="${td.todolist_id}">${td.name}</option>
            		</c:forEach>
       			</select> <br> <br>
       			<input type="submit" value="Enregistrer"required>
        </form>
    	</div>
	 
	 <br> <br>
	  <div>
   		<table>
   			<thead>
   				<tr>
   					<th>Type todolist</th>
   					<th>Post</th>
   					
   				</tr>
   			</thead>
   			<tbody>
		 		<c:forEach items = "${tasks}" var="td">
		   			<tr>
		   				<td>${td.id_task}</td>
		   				<td>${td.post_task}</td>
		   				
		   			</tr>
		   		</c:forEach>
   			</tbody>
   		</table>
   		</div> 
 
</body>
</html>