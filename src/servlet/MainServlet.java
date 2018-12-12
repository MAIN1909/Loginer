package servlet;

import servise.HtmlServise;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("login") != null) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            try {
                PrintWriter out = response.getWriter();
                //хранить картинки на piccy.info
                out.println(HtmlServise.formMainPage("Главная"));
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/loginer/");
        }
    }
}
