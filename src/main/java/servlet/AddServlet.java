package servlet;

import dao.ItemDao;
import entity.Item;
import service.ItemServise;
import spring.SpringContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

//@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String pic = request.getParameter("pic");
        if (!name.equals(null) && !description.equals(null) && !price.equals(null) && !pic.equals(null)) {
            response.sendRedirect("/loginer/main");

            try {
                // new MySqlItemDao().save(new Item(UUID.randomUUID(), name, description, Integer.parseInt(price), pic));
                ((ItemDao) SpringContextHolder.getContext().getBean("idao")).save(new Item(UUID.randomUUID(), name, description, Integer.parseInt(price), pic));

                // new FileSystemItemDao().save(new Item(UUID.randomUUID(), name, description, Integer.parseInt(price), pic));

            } catch (Exception e) {

                e.printStackTrace();
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            out.println(((ItemServise) SpringContextHolder.getContext().getBean("html_item")).formCreatePage("Add new item"));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
