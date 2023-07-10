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
        out.println("<html>\n" +
                "<style>\n" +
                "body {n" +
                "font-family: Montserrat;\n" +
                "font-size: 16px;\n" +
                "font-weight: 500;\n" +
                "}\n" +
                "h2:nth-child(odd) {\n" +
                "background-color: white;\n" +
                "}\n" +
                "h2:nth-child(even) {\n" +
                "background-color: green;\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n");
        PostgreSqlRepo.sort5().forEach(student -> out.println("<h2>" + student.getName() + "  " +
                student.getSum() + "</h2>"));
        out.println("<br/><a href=\"http://localhost:63342/Java4Tihonenko/servlets/html/start.html\">Return to main</a>");
        out.println("<br/><a href=\"getAll\">All information from online school</a>");
        out.println("</body></html>");
        out.close();
    }
}
