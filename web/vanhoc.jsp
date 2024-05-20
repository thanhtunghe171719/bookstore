<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Book List</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            header {
                padding: 10px 0;
                background: #333;
                color: white;
                text-align: center;
            }
            .container {
                display: flex;
            }
            .sidebar {
                width: 20%;
                padding: 15px;
                background: #f4f4f4;
            }
            .content {
                width: 80%;
                padding: 15px;
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
            }
            .book-card {
                border: 1px solid #ccc;
                border-radius: 5px;
                width: calc(33.333% - 20px);
                box-sizing: border-box;
                padding: 10px;
                text-align: center;
                transition: transform 0.2s;
            }
            .book-card:hover {
                transform: scale(1.05);
            }
            .book-image {
                width: 100px;
                height: 150px;
                object-fit: cover;
            }
            .book-title {
                font-size: 1.2em;
                margin: 10px 0;
            }
            .book-price {
                color: #b12704;
                font-weight: bold;
            }
            ul {
                list-style-type: none;
                padding: 0;
            }
            li {
                margin-bottom: 10px;
            }
            a {
                text-decoration: none;
                color: #333;
            }
            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Book Store</h1>
        </header>
        <div class="container">
            <div class="sidebar">
                <h2>Nhóm sản phẩm</h2>
                <ul>
                    <li><a href="booklist">All Category</a></li>
                        <c:forEach var="category" items="${categoryList}">
                        <li><a href="booklist?category=${category}">${category}</a></li>
                        </c:forEach>
                </ul>
            </div>
            <div class="content">
                <c:forEach var="book" items="${bookList}">
                    <div class="book-card">
                        <a href="bookdetails?id=${book.id}">
                            <img class="book-image" src="${book.imageUrl}" alt="${book.title}">
                            <div class="book-title">${book.title}</div>
                            <div class="book-price">$${book.price}</div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
