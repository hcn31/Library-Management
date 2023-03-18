<jsp:include page="Session.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifier l'Adhearant</title>
    <!-- Ajout du lien vers le CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">Bibliotheque</a>
    <a class="btn btn-primary my-2 my-sm-0 btn-lg"  href="ServletDec">deconnecter</a>
</nav>
<div class="container">
    <h1>Modifier le Livre</h1>
    <form action="ServletUpdateAdh" method="post">
        <div class="form-group">
            <label for="cin">Cin:</label>
            <input type="hidden" class="form-control" id="cin1" name="cin" value=<%= request.getParameter("cin") %> >

            <input type="text" disabled class="form-control" id="cin" name="cin" value=<%= request.getParameter("cin") %> required>
        </div>
        <div class="form-group">
            <label for="nom" maxlength="10">Nom:</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom" maxlength="10">Prénom:</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>

<!-- Ajout des scripts de Bootstrap -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/XvoCkPb4WtWA0f4" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
