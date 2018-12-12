package servise;

public class HtmlServise {

    private static String formHead(String title) {
        return "<html>\n" +
                "  <head>\n" +
                "    <title>" + title + "</title>\n" +
                "  </head>\n" +
                "  <body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>\n";
    }

    private static String formTale() {
        return "</body>\n" +
                "</html>";
    }

    public static String formAuthPage(String title) {
        StringBuilder sb = new StringBuilder();
        String code = "    <div>\n" +
                "      <form action='/loginer/' method='POST'>\n" +
                "        <input type='text' name='login'/>\n" +
                "        <input type='submit' value='Sign In Me'/> \n" +
                "      </form>\n" +
                "</div>\n";
        return sb.append(formHead(title)).append(code).append(formTale()).toString();
    }


    public static String formMainPage(String title) {
        StringBuilder sb = new StringBuilder();
        String code = "<h1 align = 'center'>Продам Обои</h1>\n" +
                "<div align = 'right'><img src='http://i.piccy.info/i9/6a402bdc033cc60d9d418abbdf3f1cb0/1544399078/161873/1287748/bmw.jpg'<br/>\n" +
                "<p><big><big><big>Купи БМВ</big></big></big></p>\n" +
                "</div>\n"

//                "    <div>\n" +
//
//                "<h1 class='align-center'>Заголовок</h1>"
//
//                + "</div>\n"
                ;
        return sb.append(formHead(title)).append(code).append(formTale()).toString();

    }

}
