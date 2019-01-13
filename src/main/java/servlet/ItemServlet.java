package servlet;

import dao.MySqlItemDao;
import entity.Item;
import service.HtmlServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ItemServlet", urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Item itemById = new MySqlItemDao().getById(id);
        PrintWriter out = response.getWriter();
        out.println(HtmlServise.formItemPage("Товар", itemById));
        out.close();
//        Item itemById = null;
//        for (Item i : new MySqlItemDao().get()) {
//            if (id.equals(i.getId().toString())) {
//                itemById = i;
//            }
//        }
//        try {
//            PrintWriter out = response.getWriter();
//            out.println(HtmlServise.formItemPage("Товар",itemById));
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
