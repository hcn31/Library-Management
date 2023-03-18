package ilisi.hibernate.biblio.controler;

import ilisi.hibernate.biblio.model.bo.Emprunt;
import ilisi.hibernate.biblio.model.bo.EmpruntId;
import ilisi.hibernate.biblio.model.dao.emprunt.DAOEmprunt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RendreExp extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int idex= Integer.parseInt(request.getParameter("idemp"));
       String cin=request.getParameter("cin");
       String date=request.getParameter("date");

        System.out.println(idex);

        DAOEmprunt daom=new DAOEmprunt();


        EmpruntId idemp=new EmpruntId(idex,cin, date);
        daom.delete(new Emprunt(idemp, 1));
        request.getRequestDispatcher("GestionEmprunts.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
