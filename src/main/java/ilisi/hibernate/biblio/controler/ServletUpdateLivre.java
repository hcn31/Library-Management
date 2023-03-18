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

@WebServlet(name = "ServletUpdateLivre", value = "/ServletUpdateLivre")
public class ServletUpdateLivre extends HttpServlet {

    DAOLivre D=new DAOLivre();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("titre");
        int nbr= Integer.parseInt(request.getParameter("nbr"));
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHH"+nbr);

        Livre L=new Livre(isbn,titre);
        D.update(L);
        DAOExemplaire daoE=new DAOExemplaire();
        int tot=daoE.retreive().size();
        Long countExp=daoE.countIsbn(L.getIsbn());
        int change= (int) (nbr - countExp);
        Long explaireEmprut=daoE.countExpEmprunt(L.getIsbn());

        if(change>=0) {
            for(int i=tot;i<(tot+change);i++) {
                daoE.create(new Exemplaire(i, L));
            }}
        else if((explaireEmprut-change)<=countExp){
            System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
            int i=-change;
            Vector<Exemplaire> empruLivs=daoE.retreiveExpEmprunt(isbn);
            for(Exemplaire e: daoE.retreiveByIsbn(isbn)){
                System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
                if(i==0) break;
                if(!empruLivs.contains(e)){
                    daoE.delete(e);
                    i--;
                }
            }
        }else {// 5 exp  3 emprunt retreiveExpEmprunt
            String msg="impossible de diminuer le nombre des exemplaire tanqu'il son emprute";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/pageErreur.jsp").forward(request,response);

        }


        Collection<Livre> books= (Vector<Livre>)D.retreive();
        request.setAttribute("livre",books);
        RequestDispatcher R=request.getRequestDispatcher("/Redirect");
        try {
            R.forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
