package service;

import entity.Item;

import java.util.Collection;

public class HtmlServise {

    String formHead(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("  <head>\n");
        sb.append("<title>")
                .append(title)
                .append("</title>\n");
        sb.append("  </head>\n");
        sb.append("  <body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>\n");
        return sb.toString();
    }

    String formTale() {
        return "</body>\n" +
                "</html>";
    }

    public String formAuthPage(String title) {
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

    public String formMainPage(String title, Collection<Item> items) {
        StringBuilder sb = new StringBuilder();

        String code = "<h1 align = 'center'></h1>";
        String search = "<div><form action='/loginer/search'>" +
                " <input type='text' name='name'/>" +
                " <input type='submit' value='Search'/>" +
                "  </form></div>";
        String add = "<div><form action='/loginer/add'>" +
                " <input type='submit' value='Create new item'/>" +
                "  </form></div>";
        for (Item i : items) {
            code += "<div align = 'center'>" +
                    "<a href ='/loginer/item?id=" + i.getId() + "'> <img src='" + i.getPic() + "'/></a><br/>\n" +
                    "<p><big><big><big>" + i.getName() + "</big></big></big></p>\n" +
                    "<h3>" + i.getDescription() + "</h3>\n" +
                    "Price: " + i.getPrice() + "\n" +
                    "id: " + i.getId() + "\n" +
                    "</div>\n";
        }
        return sb.append(formHead(title)).append(search).append(add).append(code).append(formTale()).toString();


    }
}
