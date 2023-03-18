package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.livre.DAOLivre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

public class ServletChercheLivreClient extends HttpServlet {
    private static final long serialVersionUID = 1L;


    DAOLivre D=new DAOLivre();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        Collection<Livre> books=new Vector<>();
        Livre A=(Livre)D.findByIsbn(isbn);
        books.add(A);
        request.setAttribute("livre", books);
        RequestDispatcher R=request.getRequestDispatcher("/pageClient.jsp");

            R.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
