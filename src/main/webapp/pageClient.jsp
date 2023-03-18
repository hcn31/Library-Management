<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import=" ilisi.hibernate.biblio.model.bo.Livre ,java.util.Collection" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Liste des livres de la bibliothèque</title>
  <!-- CSS de Bootstrap -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <!-- JS de Bootstrap -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNVQ8o8" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand">Bibliotheque</a>
  <a class="btn btn-primary my-2 my-sm-0 btn-lg"  href="index.jsp">Login</a>
</nav>

<div class="container">
  <form method="POST" action="ServletChercheLivreClient" class="form-inline mb-3">
    <input type="hidden" name="rechercher"/>
    <div class="form-group mr-2">
      <input type="text" name="isbn" class="form-control" placeholder="ISBN">
    </div>
    <button type="submit" class="btn btn-primary">Chercher livre par titre</button>
  </form>

    <%
      Collection<Livre> livres = (Vector<Livre>)request.getAttribute("livre");
      if(livres!=null&&!livres.isEmpty()){
     %>
  <table class="table table-striped table-bordered">
    <thead>
    <tr>
      <th>ISBN</th>
      <th>Titre</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${livre}" var="l">
      <tr>
        <td><c:out value="${l.isbn}"/></td>
        <td><c:out value="${l.titre}"/></td>
      </tr>
    </c:forEach>


    </tbody>
  </table>
  <%
    }
  %>
</div>

</body>
</html>
