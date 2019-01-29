package service;

import entity.Item;
import spring.SpringContextHolder;


public class ItemServise {
    public String formItemPage(Item item) {
        StringBuilder sb = new StringBuilder();
        String code = "<h1 align = 'center'>" + item.getName() + "</h1><a href='/loginer/main'><input type='submit' value='Return to main'/></a>";

        code += "<div align = 'center'>" +

                "<img src='" + item.getPic() + "'/><br/>\n" +
                "<p><big><big><big>" + item.getName() + "</big></big></big></p>\n" +
                "<h3>" + item.getDescription() + "</h3>\n" +
                "Price: " + item.getPrice() + "\n" +
                "id: " + item.getId() + "\n" +
                "</div>\n";


        return sb.append(((HtmlServise) SpringContextHolder.getContext().getBean("html")).formHead("Товар")).append(code).append(((HtmlServise) SpringContextHolder.getContext().getBean("html")).formTale()).toString();

    }

    public String formCreatePage(String title) {
        StringBuilder sb = new StringBuilder();
        String code = "<h1 align = 'center'></h1>";
        String c = "<div align = 'center'><form action='/loginer/add' method='post'>" +
                " <input type='text' name='name'/>" +
                " <input type='text' name='description'/>" +
                " <input type='text' name='price'/>" +
                " <input type='text' name='pic'/>" +
                " <input type='submit' value='Create new item'/>" +
                "  </form></div>";

        return sb.append(((HtmlServise) SpringContextHolder.getContext().getBean("html")).formHead(title)).append(code).append(c).append(((HtmlServise) SpringContextHolder.getContext().getBean("html")).formTale()).toString();

    }
}

