package ru.abub;


import ru.abub.logic.Model;
import ru.abub.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/addHtml")
public class ServletAddHtml extends HttpServlet {

    Model model = Model.getInstance();
    private AtomicInteger counter = new AtomicInteger(model.getFromList().size() + 1);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        double salary = Double.parseDouble(request.getParameter("salary"));

        User user = new User(name, surname, salary);

        model.add(user, counter.getAndIncrement());

        pw.print("<html>" + "<h3>Пользователь " + name + " " + surname + "с зарплатой=" + salary +
                "успешно создан! :)</h3>" + "<a href=\"addUser.html\">Создать нового пользователя</a><br/>" +
                "<a href=\"index.jsp\">Домой</a>" + "</html>");
    }

}
