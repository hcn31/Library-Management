package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;
import ilisi.hibernate.biblio.model.dao.livre.DAOLivre;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

@WebServlet(name = "ServletDeleteAdh", value = "/ServletDeleteAdh")
public class ServletDeleteAdh extends HttpServlet {

    DAOAdherant D=new DAOAdherant();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cin = request.getParameter("cin");
        Adherant K=D.findByCin(Cin);
        D.delete(K);

        Collection<Adherant> Adherants= (Vector<Adherant>)D.retreive();

        request.setAttribute("Adherant",Adherants);

        RequestDispatcher R=request.getRequestDispatcher("/RedirectAdh");

            R.forward(request, response);

    }
}
