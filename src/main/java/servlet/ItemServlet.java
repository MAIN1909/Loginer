package servlet;

import dao.ItemDao;
import entity.Item;
import service.HtmlServise;
import spring.SpringContextHolder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ItemServlet", urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
//Для MySql
//        Item itemById = new MySqlItemDao().getById(id);
//Для Hibernate
        Item itemById = ((ItemDao) SpringContextHolder.getContext().getBean("idao")).getById(id);

        PrintWriter out = response.getWriter();
        out.println(((HtmlServise) SpringContextHolder.getContext().getBean("html")).formItemPage("Товар", itemById));
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
