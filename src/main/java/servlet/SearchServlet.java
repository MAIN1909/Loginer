package servlet;

import dao.ItemDao;
import service.HtmlServise;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

//@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        try {
            PrintWriter out = response.getWriter();

//            out.println(HtmlServise.formMainPage("Search", new MySqlItemDao().getByName(name)));
            //out.println(HtmlServise.formMainPage("Search", new FileSystemItemDao().getByName(name)));
            out.println(((HtmlServise) SpringContextHolder.getContext().getBean("html")).formMainPage("Search", ((ItemDao) SpringContextHolder.getContext().getBean("idao")).getByName(name)));

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
