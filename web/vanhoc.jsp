<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Book List</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 15px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <h2>Book List</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td>${book.price}</td>
                    <td>${book.stock}</td>
                    <td><img src="${book.imageUrl}" alt="${book.title}" width="50" height="50"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
