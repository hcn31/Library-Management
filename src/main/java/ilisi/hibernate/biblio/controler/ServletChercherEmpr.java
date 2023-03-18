package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Emprunt;
import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.emprunt.DAOEmprunt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

public class ServletChercherEmpr extends HttpServlet {

DAOEmprunt D=new DAOEmprunt();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idemp = request.getParameter("isbn");
        Collection<Emprunt> Emps=new Vector<>();
        Emps.add(D.findById(idemp));

        request.setAttribute("Emps", Emps);
        RequestDispatcher R=request.getRequestDispatcher("/GestionEmprunts.jsp");

        R.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
