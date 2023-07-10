package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.PostgreSqlRepo;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/sort5")
public class Sort5 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        PostgreSqlRepo.sort5().forEach(student -> out.println("<h2>" + student.getName() + "  " +
      student.getSum() + "</h2>"));
        out.println("<br/><a href=\"getAll\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}