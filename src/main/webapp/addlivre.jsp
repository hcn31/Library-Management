<jsp:include page="Session.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Ajouter un nouveau livre à la bibliotheque</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand">Bibliotheque</a>
  <a class="btn btn-primary my-2 my-sm-0 btn-lg"  href="ServletDec">deconnecter</a>
</nav>
<div class="container">
  <h1 class="text-primary">Ajouter un livre </h1>
  <form action="ServletAddLivre" method="post">
    <div class="form-group">
      <label for="isbn">ISBN: </label>
      <input type="text" class="form-control" id="isbn" name="isbn" required>
    </div>
    <div class="form-group">
      <label for="titre">Titre: </label>
      <input type="text" class="form-control" id="titre" name="titre" required>
    </div>
    <div class="form-group">
      <label for="isbn">Nombre des exemplaire: </label>
      <input type="text" class="form-control" id="nbr" name="nbr" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>