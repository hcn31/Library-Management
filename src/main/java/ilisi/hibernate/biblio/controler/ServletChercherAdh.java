package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;
public class ServletChercherAdh extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DAOAdherant D=new DAOAdherant();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin = request.getParameter("cin");
        Collection<Adherant> Adherants=new Vector<>();
        Adherant A=(Adherant)D.findByCin(cin);
        Adherants.add(A);
        request.setAttribute("Adherant", Adherants);
        RequestDispatcher R=request.getRequestDispatcher("/ChercherAdherant.jsp");
            R.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
