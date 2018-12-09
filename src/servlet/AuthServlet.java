package servlet;

import Servise.HtmlServise;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthServlet", urlPatterns = "/")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        if ("admin".equals(login)) {
            request.getSession().setAttribute("login", login);
            response.sendRedirect("/loginer/main");
        } else {
            response.sendRedirect("/loginer/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.println(
                    HtmlServise.formAuthPage("Логинер")
//                    "<html>\n" +
//                    "  <head>\n" +
//                    "    <title></title>\n" +
//                    "  </head>\n" +
//                    "  <body>\n" +
//                    "    <div>\n" +
//                    "      <form action='/loginer/' method='POST'>\n" +
//                    "        <input type='text' name='login'/>\n" +
//                    "        <input type='submit' value='Sign In Me'/> \n" +
//                    "      </form>\n" +
//                    "    </div>\n" +
//                    "  </body>\n" +
//                    "</html>"
            );
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
