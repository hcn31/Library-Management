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

@WebServlet(name = "ServletAddLivre", value = "/ServletAddLivre")
public class ServletAddLivre extends HttpServlet {

    DAOLivre D=new DAOLivre();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("titre");
        int nbr = Integer.parseInt(request.getParameter("nbr"));
    Livre L=new Livre(isbn,titre);
        if(!D.create(L)){
            request.getRequestDispatcher("/pageErreur.jsp").forward(request,response);
            return;
        }
        DAOExemplaire daoE=new DAOExemplaire();
        int count=daoE.retreive().size();
        for(int i=count;i<(nbr+count);i++) {
            daoE.create(new Exemplaire(i, L));
        }
        Collection<Livre> books= (Vector<Livre>)D.retreive();
        request.setAttribute("livre",books);
       request.getRequestDispatcher("/Redirect").forward(request, response);


    }
}
