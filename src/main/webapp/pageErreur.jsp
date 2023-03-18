<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur de connexion</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%
        String msg= (String) request.getAttribute("msg");
    %>
    <div class="alert alert-danger mt-3" role="alert">
        <h4 class="alert-heading">Erreur!</h4>
        <p>vouillez respecter les regeles d'utilisation de notre application(<%=msg%>).</p>
    </div>
</div>
</body>
</html>
