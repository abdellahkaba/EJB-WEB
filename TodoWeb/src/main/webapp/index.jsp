<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	
/* styles.css */

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f2f2f2;
}

.menu-container {
    display: flex;
    justify-content: space-between;
    background-color: #333;
    padding: 10px;
}

.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

.menu li {
    display: inline;
    margin-right: 15px;
}

.menu a {
    color: white;
    text-decoration: none;
}

.logout-button {
    display: flex;
    align-items: center;
}

form {
    margin: 0;
}

button {
    background-color: #e74c3c;
    color: white;
    border: none;
    padding: 10px;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #c0392b;
}

/* Nouveau style pour le bouton de déconnexion à l'angle droit */
.logout-button {
    margin-left: auto;
}


</style>
<body>
	<div class="menu-container">
    <div class="menu">
        <ul>
        	
            <li><a href="<%= request.getContextPath()%>/TodolistServlet">TodoLists</a></li>
            <li><a href="<%= request.getContextPath()%>/TaskServlet">Tasks</a></li>
        </ul>
    </div>
    <div class="logout-button">
        <form action="logout.jsp" method="post">
            <button type="submit">Déconnexion</button>
        </form>
    </div>
</div>
</body>
</html>