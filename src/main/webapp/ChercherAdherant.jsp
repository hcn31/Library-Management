<jsp:include page="Session.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="ilisi.hibernate.biblio.model.bo.Adherant" %>
<%@ page import="java.util.Collection" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>La Liste des adherants</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">Bibliotheque</a>
    <a class="btn btn-primary my-2 my-sm-0 btn-lg"  href="ServletDec">deconnecter</a>
</nav>
<div class="container">
    <h1 class="mt-3">La Liste des adherants</h1>
    <form method="POST" action="ServletChercherAdh">
        <input type="hidden" name="rechercher"/>
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Chercher Adherant par cin" name="cin">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit">Chercher</button>
            </div>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">CIN</th>
            <th scope="col">Nom</th>
            <th scope="col">Prenom</th>
            <th scope="col">Modifier</th>
            <th scope="col">Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <%

             Collection<Adherant> Adherants = (Collection<Adherant>) request.getAttribute("Adherant");

            for(Adherant Adh:Adherants) { %>
        <tr>
            <td><%= Adh.getCin() %></td>
            <td><%= Adh.getNom() %></td>
            <td><%= Adh.getPrenom() %></td>
            <td>
                <a href="UpdateAdherant.jsp?cin=<%= Adh.getCin() %>&nom=<%= Adh.getNom() %>&prenom=<%=Adh.getPrenom()%>"
                   class="btn btn-warning">Modifier</a>
            </td>
            <td>
                <a href="ServletDeleteAdh?cin=<%= Adh.getCin() %>&nom=<%= Adh.getNom() %>&prenom=<%=Adh.getPrenom()%>"
                   class="btn btn-danger">Supprimer</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form method="POST" action="AddAdherant.jsp">
        <input type="hidden" name="ajouter"/>
        <button type="submit" class="btn btn-success mb-3">Ajouter un Adherant</button>
    </form>
</div>
</body>
</html>
