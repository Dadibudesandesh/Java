import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletPage extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        // Get name parameter from form
        String name = req.getParameter("name");

        // Set response content type
        resp.setContentType("text/html");

        // Get writer to send response
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome Page</title>");
        out.println("</head>");
        out.println("<body>");

        if (name != null && !name.trim().isEmpty()) {
            out.println("<h2>Welcome, " + name + " !</h2>");
        } else {
            out.println("<h2>Welcome, Guest!</h2>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}