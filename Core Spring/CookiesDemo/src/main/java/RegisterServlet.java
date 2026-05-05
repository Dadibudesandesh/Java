import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        response.addCookie(new Cookie("fname", fname));
        response.addCookie(new Cookie("lname", lname));
        response.addCookie(new Cookie("email", email));
        response.addCookie(new Cookie("age", age));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       
        out.println("<h1>Registration Successful</h1>");
        out.println("<h4>Name: "+fname+"<h4>");
        out.println("<h4>Name: "+lname+"<h4>");
        out.println("<h4>Email: "+email+"<h4>");
        out.println("<h4>Age: "+age+"<h4>");
    }
}