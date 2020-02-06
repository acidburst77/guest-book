<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lightburst7
  Date: 05.02.2020
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GuestBook posts</title>
    <link rel="stylesheet" href="<c:url value="/src/libs/bootstrap/css/bootstrap.min.css" />" type="text/css" rel="stylesheet">
</head>
<body>
    <main role="main" class="flex-shrink-0">
        <div class="container">
            <h1 class="mt-5">Гостевая книга</h1>
            <p class="lead">Добавь свою запись</p>

            <table class="table">
                <tr colspan="3">
                    <form action="add" method="post" class="form-inline">
                        <div class="col-auto my-4">
                            <label for="inputPostText" class="sr-only">текст поста</label>
                            <input type="text" class="form-control" name="txt" id="inputPostText" placeholder="текст поста">
                        </div>
                        <div class="col-auto my-4">
                        <button type="submit" class="btn btn-primary mb-2">Добавить</button>
                        </div>
                    </form>
                </tr>
                <c:forEach items="${requestScope.posts}" var="post">
                    <tr>
                        <td>${post.id}</td>
                        <td><c:out value="${post.txt}" /></td>
                        <td><a href="delete?id=${post.id}">Удалить</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </main>

    <script src="<c:url value="/src/libs/jquery/jquery-3.4.1.min.js" />"></script>
    <script src="<c:url value="/src/libs/bootstrap/js/bootstrap.js" />"></script>
</body>
</html>
