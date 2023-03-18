package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Exemplaire;
import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.exemplaire.DAOExemplaire;
import ilisi.hibernate.biblio.model.dao.livre.DAOLivre;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

@WebServlet(name = "ServletDeleteLivre", value = "/ServletDeleteLivre")
public class ServletDeleteLivre extends HttpServlet {

    DAOLivre D=new DAOLivre();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("titre");
        System.out.println(isbn+titre);
        Livre K=D.findByIsbn(isbn);
        DAOExemplaire DaoEx=new DAOExemplaire();
        Vector<Exemplaire> Exs=DaoEx.retreiveByIsbn(isbn);
        for(Exemplaire Ex:Exs){
           DaoEx.delete(Ex);
        }
        D.delete(K);

      Collection<Livre> books= (Vector<Livre>)D.retreive();

        request.setAttribute("livre",books);

        RequestDispatcher R=request.getRequestDispatcher("/Redirect");

            R.forward(request, response);


    }
}
