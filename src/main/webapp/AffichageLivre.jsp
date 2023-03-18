<jsp:include page="Session.jsp"/>
<%@ page import="ilisi.hibernate.biblio.model.bo.Livre" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Vector" %>
<%@ page import="ilisi.hibernate.biblio.model.dao.exemplaire.DAOExemplaire" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Livres</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">Bibliotheque</a>
    <a class="btn btn-primary my-2 my-sm-0 btn-lg"  href="ServletDec">deconnecter</a>
</nav>
<div class="container">
    <h1 class="text-primary">La liste des livres de la bibliotheque</h1>
    <form method="POST" action="ServletChercherLivre">
        <div class="form-group">
            <input type="text" class="form-control" name="isbn" placeholder="Chercher livre par titre">
        </div>
        <button type="submit" class="btn btn-primary">Chercher</button>
    </form>
    <table class="table table-striped mt-4">
        <thead>
        <tr>
            <th>ISBN</th>
            <th>Titre</th>
            <th>Nombre d'exemplaire</th>
            <th>Modifier</th>
            <th>Supprimer</th>
        </tr>
        </thead>
        <tbody>

        <%
            Collection<Livre> livres = new Vector<>();
            livres=(Vector<Livre>)request.getAttribute("livre");
            for (Livre book : livres) { %>
        <tr>
            <td><%= book.getIsbn() %></td>
            <td><%= book.getTitre() %></td>
            <td><%= new DAOExemplaire().countIsbn(book.getIsbn()) %></td>
            <td>
                <a href="UpdateLivre.jsp?isbn=<%= book.getIsbn() %>&&titre=<%= book.getTitre() %>&&nbr=<%= new DAOExemplaire().countIsbn(book.getIsbn()) %>" class="btn btn-sm btn-warning">Modifier</a>
            </td>
            <td>
                <form method="POST" action="ServletDeleteLivre">
                    <input type="hidden" name="isbn" value="<%= book.getIsbn() %>"/>
                    <input type="hidden" name="titre" value="<%= book.getTitre() %>"/>
                    <button type="submit" class="btn btn-sm btn-danger">Supprimer</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form method="POST" action="addlivre.jsp">
        <input type="hidden" name="ajouter"/>
        <button type="submit" class="btn btn-primary">Ajouter un livre</button>
    </form>
    <a href="GestionAdherant.jsp" class="mt-4 d-block">Gestion des adherents</a>
    <a href="GestionEmprunts.jsp" class="mt-4 d-block">Gestion des emprunts</a>

</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>