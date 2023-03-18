<jsp:include page="Session.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifier le Livre</title>
    <!-- Ajout du lien vers Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">Bibliotheque</a>
    <a class="btn btn-primary my-2 my-sm-0 btn-lg"  href="ServletDec">deconnecter</a>
</nav>
<div class="container">
    <h2>Modifier le Livre</h2>
    <form action="ServletUpdateLivre" method="post">
        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="hidden" class="form-control"  id="idISBN" name="isbn" value=<%= request.getParameter("isbn") %> required>
            <input type="text" class="form-control" id="isbn" disabled name="isbn" value=<%= request.getParameter("isbn") %> required>
        </div>
        <div class="form-group">
            <label for="titre" Maxlength=10>Titre:</label>
            <input type="text" value="<%= request.getParameter("titre") %>" class="form-control" id="titre" name="titre" required>
        </div>
        <div class="form-group">
            <label for="titre" Maxlength=10>Nombre d'exemplaire:</label>
            <input type="text" value="<%= request.getParameter("nbr") %>" class="form-control" id="nbr" name="nbr" required>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<!-- Ajout du lien vers les fichiers JavaScript de Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>
