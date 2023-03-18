package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.*;
import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;
import ilisi.hibernate.biblio.model.dao.emprunt.DAOEmprunt;
import ilisi.hibernate.biblio.model.dao.exemplaire.DAOExemplaire;
import ilisi.hibernate.biblio.model.dao.livre.DAOLivre;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Vector;

@WebServlet(name = "EffEmpServlet", value = "/EffEmpServlet")
public class EffEmpServlet extends HttpServlet {

    DAOEmprunt D=new DAOEmprunt();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin = request.getParameter("cin");
        String isbn = request.getParameter("isbn");
        DAOEmprunt daoEM=new DAOEmprunt();
        DAOExemplaire daoE=new DAOExemplaire();
        DAOAdherant daoA=new DAOAdherant();
        DAOLivre daoL = new DAOLivre();
        Livre L=daoL.findByIsbn(isbn);
        Adherant ads=daoA.findByCin(cin);
        Exemplaire exp=daoE.getAvailableExp(isbn);
        if(exp==null) request.getRequestDispatcher("/pageErreur.jsp").forward(request,response);
        daoEM.create(new Emprunt(new EmpruntId(exp.getIdexp(), ads.getCin(), LocalDate.now().toString() )));
        request.getRequestDispatcher("/GestionEmprunts.jsp").forward(request,response);

        /*

        if(!D.create(new Adherant(cin,nom,prenom))) {
            request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
            return;
        }
        Collection<Adherant> Adherants= (Vector<Adherant>)D.retreive();
        request.setAttribute("Adherant",Adherants);
        RequestDispatcher R=request.getRequestDispatcher("/RedirectAdh");

        R.forward(request, response);

*/
    }
}
