package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

@WebServlet(name = "ServletAddAdh", value = "/ServletAddAdh")
public class ServletAddAdh extends HttpServlet {

    DAOAdherant D=new DAOAdherant();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin = request.getParameter("cin");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        if(!D.create(new Adherant(cin,nom,prenom))) {
           request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
           return;
        }
        Collection<Adherant> Adherants= (Vector<Adherant>)D.retreive();
        request.setAttribute("Adherant",Adherants);
        RequestDispatcher R=request.getRequestDispatcher("/RedirectAdh");

            R.forward(request, response);
       

    }
}
