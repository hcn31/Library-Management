package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;
import ilisi.hibernate.biblio.model.dao.livre.DAOLivre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;
public class ServletAuth extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletAuth() {
        super();

    }
    //DAOUsers DU=new DAOUsers(Connexion.getInstance());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if(login.equals("admin")&&pass.equals("admin"))
        {
            HttpSession ses = request.getSession();
            ses.setAttribute("login", login);
            DAOLivre D=new DAOLivre();
            Collection<Livre> books=D.retreive();
            request.setAttribute("livre", books);
            RequestDispatcher R=request.getRequestDispatcher("/Redirect");

                R.forward(request, response);

        }
        else
        {
            request.getRequestDispatcher("/pageErreur.jsp").forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
