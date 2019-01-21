package service;

import entity.Item;

import java.util.Collection;

public class HtmlServise {

    private static String formHead(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("  <head>\n");
        sb.append("    <title>" + title + "</title>\n");
        sb.append("  </head>\n");
        sb.append("  <body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>\n");
        return sb.toString();
    }

    private static String formTale() {
        return "</body>\n" +
                "</html>";
    }

    public static String formAuthPage(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(formHead(title));
        sb.append("<div>\n");
        sb.append("    <form action='/loginer/' method='POST'>\n");
        sb.append("     <input type='text' name='login'/>\n");
        sb.append("     <input type='submit' value='Sign In Me'/> \n");
        sb.append("    </form>\n");
        sb.append("</div>\n");
        sb.append(formTale());
        return sb.toString();
    }

    public static String formMainPage(String title, Collection<Item> items) {
        StringBuilder sb = new StringBuilder();
        sb.append(formHead(title));
        sb.append("<h1 align = 'center'>Продам Обои</h1>\n");
        for (Item i : items) {
            sb.append("<div align = 'right'>");
            sb.append("<a href=/loginer/item?id=" + i.getId() + "><img src='" + i.getPic() + "'/></a><br/>\n");
            sb.append("<p><big><big><big>" + i.getName() + "</big></big></big></p>\n");
            sb.append("<h3>" + i.getDescription() + "</h3>\n");
            sb.append("Price: " + i.getPrice() + "\n");
            sb.append("id: " + i.getId() + "\n");
            sb.append("</div>\n");
        }
        sb.append(formTale());
        return sb.toString();
    }

    public static String formItemPage(String title, Item item) {
        StringBuilder sb = new StringBuilder();
        sb.append(formHead(title));
        sb.append("<h1 align = 'center'>Страница с выбраным товаром</h1>\n");
        sb.append("<div align = 'left'>");
        sb.append("<img width=\"60%\" src='" + item.getPic() + "'/><br/>\n");
        sb.append("<p style=\"font-size:28px\">" + item.getName() + "</p>\n");
        sb.append("<h2>" + item.getDescription() + "</h2>\n");
        sb.append("<h3> Price: " + item.getPrice() + "<br/>\n");
        sb.append("id: " + item.getId() + "</h3> \n");
        sb.append("</div>\n");
        sb.append(formTale());
        return sb.toString();

    }
}
