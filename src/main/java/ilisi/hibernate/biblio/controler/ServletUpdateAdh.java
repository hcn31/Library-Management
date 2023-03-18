package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

@WebServlet(name = "ServletUpdateAdh", value = "/ServletUpdateAdh")
public class ServletUpdateAdh extends HttpServlet {

    DAOAdherant D=new DAOAdherant();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cin = request.getParameter("cin");
        String Nom = request.getParameter("nom");
        String Prenom = request.getParameter("prenom");
        D.update(new Adherant(Cin,Nom,Prenom));
        Collection<Adherant> Adherants= (Vector<Adherant>)D.retreive();
        request.setAttribute("livre",Adherants);
        RequestDispatcher R=request.getRequestDispatcher("/RedirectAdh");
        R.forward(request, response);
    }
}
