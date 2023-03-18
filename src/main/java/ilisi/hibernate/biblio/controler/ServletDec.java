package ilisi.hibernate.biblio.controler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class ServletDec extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletDec() {
        super();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess= request.getSession();
        System.out.println(sess.getAttribute("login"));
            sess.removeAttribute("login");
            sess.invalidate();
            response.sendRedirect(request.getContextPath() + "/pageClient.jsp");

    }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
