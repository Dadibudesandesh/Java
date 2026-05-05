import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Cookie userCookie = new Cookie("username", username);
        Cookie passCookie = new Cookie("password", password);

        response.addCookie(userCookie);
        response.addCookie(passCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Login Successful</h1>");

        out.println("<h3>Entered Details:</h3>");
        out.println("<h4><b>Username:</b> " + username + "</h4>");
        out.println("<h4><b>Password:</b> " + password + "</h4>");
    }
}