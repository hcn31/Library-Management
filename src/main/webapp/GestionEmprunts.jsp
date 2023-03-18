<jsp:include page="Session.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="ilisi.hibernate.biblio.model.bo.Adherant" %>
<%@ page import="ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ilisi.hibernate.biblio.model.dao.livre.DAOLivre" %>
<%@ page import="ilisi.hibernate.biblio.model.bo.Livre" %>
<%@ page import="ilisi.hibernate.biblio.model.bo.Emprunt" %>
<%@ page import="ilisi.hibernate.biblio.model.dao.emprunt.DAOEmprunt" %>
<%@ page import="ilisi.hibernate.biblio.model.dao.exemplaire.DAOExemplaire" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>La Liste des adherants</title>
    <!-- Ajout de Bootstrap -->
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
    <h1 class="mt-3">La Liste des Emprunts</h1>
    <form method="POST" action="ServletChercherEmpr">
        <input type="hidden" name="rechercher"/>
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Chercher Emprunt par id exemplaire" name="idemp">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit">Chercher</button>
            </div>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">CIN</th>
            <th scope="col">ISBN</th>
            <th scope="col">IDExemplaire</th>
            <th scope="col">DateEmprunt</th>
            <th scope="col">Rendre Exemplaire</th>
        </tr>
        </thead>
        <tbody>
        <%

            // Collection<Adherant> Adherants = (Collection<Adherant>) request.getAttribute("Adherant");
            //Adherants=new DAOAdherant().retreive();
            Collection<Emprunt> Emprunts;
            if(request.getAttribute("Emps")!=null) {
                Emprunts = (Collection<Emprunt>) request.getAttribute("Emps");
            }
            else {
                 Emprunts=new DAOEmprunt().retreive();
            }
            for(Emprunt Emp:Emprunts) {
                DAOExemplaire daoE=new DAOExemplaire();
        %>
        <tr>
            <td><%= Emp.getId().getCin() %></td>
            <td><%= daoE.getIsbn(Emp.getId().getIdexmp()) %></td>
            <td><%= Emp.getId().getIdexmp() %></td>
            <td><%= Emp.getId().getDateemp() %></td>
            <td>
                <a href="RendreExp?idemp=<%=Emp.getExemplaire().getIdexp() %>&&cin=<%= Emp.getId().getCin() %>&&date=<%= Emp.getId().getDateemp() %>"
                   class="btn btn-warning">Rendre le livre</a>
            </td>

        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="EffEmpServlet" method="post">
        <div class="mb-3">
            <label for="isbn" class="form-label">Sélectionner l'ISBN :</label>
            <select id="isbn" name="isbn" class="form-select" aria-label="Default select example">
                <% Collection<Livre> Livres=new DAOLivre().retreive(); for(Livre L:Livres){ %>
                <option value="<%=L.getIsbn()%>"><%=L.getIsbn()%></option>
                <% } %>
            </select>
        </div>

        <div class="mb-3">
            <label for="cin" class="form-label">Sélectionner l'adhérent :</label>
            <select id="cin" name="cin" class="form-select" aria-label="Default select example">
                <% Collection<Adherant> Adherants=new DAOAdherant().retreive(); for(Adherant Adh:Adherants){ %>
                <option value="<%=Adh.getCin()%>"><%=Adh.getCin()%></option>
                <% } %>
            </select>
        </div>

        <input type="hidden" name="Effectuer"/>
        <button type="submit" class="btn btn-success">Effectuer un Emprunt</button>
    </form>

</div>
</body>
</html>
