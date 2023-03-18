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

public class Redirect extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            RequestDispatcher R = null;
            System.out.println(request.getAttributeNames());
            Collection<Livre> books = (Vector<Livre>) request.getAttribute("livre");
            request.setAttribute("livre", books);
            R = request.getRequestDispatcher("/AffichageLivre.jsp");
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
