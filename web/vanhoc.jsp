<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Book Store</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <section class="header">
            <div class="header-top">
                <img src="logo.png" alt="Store Logo" class="logo">
                <div class="header-right">
                    <div class="icons">
                        <a href="#">Thông Báo</a>
                        <a href="#">Giỏ Hàng</a>
                        <a href="#">Tài Khoản</a>
                    </div>
                    <div class="search-bar">
                        <input type="text" placeholder="Tìm kiếm">
                        <button>Search</button>
                    </div>
                    <div class="language">
                        <button>VN</button>
                    </div>
                </div>
            </div>
        </section>
        <div class="main">
            <div>
                <div class="container">
                    <ol class="breadcumb">
                        <li class="home"><a href="#">Trang Chủ</a></li>
                    </ol>
                </div>
            </div>
            <div class="container">
                <div class="sidebar">
                    <dt>NHÓM SẢN PHẨM</dt>
                    <dd>
                        <ol>
                            <li><a href="booklist">Tất Cả Nhóm Sản Phẩm</a></li>
                                <c:forEach var="category" items="${categoryList}">
                                <li><a href="booklist?category=${category}">${category}</a></li>
                                </c:forEach>
                        </ol>
                    </dd>
                </div>
                <div class="content">
                    <div class="banner">
                        <div class="banner-item">
                            <h3>Queen Of Sale</h3>
                            <img src="sale1.jpg" alt="Sale 1">
                            <p>-40%</p>
                        </div>
                        <div class="banner-item">
                            <h3>Tân Việt Sale Chào Hè</h3>
                            <img src="sale2.jpg" alt="Sale 2">
                            <p>-45%</p>
                        </div>
                    </div>

                    <div class="products">
                        <c:forEach items="${book}" var="book">
                            <div class="product-item">
                                <img src="${book.getImage()}" alt="gocnhocuanang" border="0">
                                <p>${book.getTitle()}</p>
                                <p>${book.getPrice()} đ</p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
