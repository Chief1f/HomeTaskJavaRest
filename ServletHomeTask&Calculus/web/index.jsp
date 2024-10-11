<%--
  Created by IntelliJ IDEA.
  User: MASLENOK
  Date: 08.10.2024
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@page import ="ru.abub.logic.Model"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h1>Домашняя страница по работе с пользователями</h1>
  Ввведите id пользователя (0 - для вывода всего списка пользователей)
  <br/>

  Доступно: <%
   Model model = Model.getInstance();
   out.print(model.getFromList().size());
   %>

  <form method="get" action="getHtml">
    <label>ID:
      <input type="text" name="id"><br/>
    </label>
    <button type="submit">Поиск</button>
  </form>

  <a href="addUser.html">Создать нового пользователя</a>
  </body>
</html>
