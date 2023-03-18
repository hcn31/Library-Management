import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.bo.Livre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

public class RedirectAdh extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher R = null;

        Collection<Adherant> Adherants = (Vector<Adherant>) request.getAttribute("Adherant");
        request.setAttribute("Adherant", Adherants);
        R = request.getRequestDispatcher("/GestionAdherant.jsp");
        try {
            R.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
