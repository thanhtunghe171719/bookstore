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
                    <dl class="narrow-by-list">
                        <dt class="odd">NHÓM SẢN PHẨM</dt>
                        <dd class="odd">
                            <ol>
                                <li>
                                    <a href="booklist">Tất Cả Nhóm Sản Phẩm</a>
                                </li>
                            </ol>
                            <c:forEach var="category" items="${category}">
                                <div id="current-category">
                                    <a href="booklist?category=${category}">${category.getCategoryName()}</a>
                                </div>
                            </c:forEach>
                        </dd>
                    </dl>
                </div>
                <div class="content">
                    <div class="toolbar-top">
                        <div class="toolbar">
                            <div class="sorter">
                                <div class="abc-xyz">
                                    <div class="dropdown-text">
                                        <p>Sắp xếp theo: </p>
                                    </div>
                                    <div class="sort-by">
                                        <div class="selectedBox">
                                            <span class="selected selected-order">Bán Chạy Tuần</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="products-grid">
                        <c:forEach items="${book}" var="book">
                            <div class="product-item">
                                <div class="product-content">
                                    <div class="product-clearfix">
                                        <a>
                                            <span>
                                                <img src="${book.getImage()}" style="width: 190px" alt="gocnhoconang" border="0">
                                            </span>
                                        </a>
                                    </div>
                                    <h2 class="product-title">${book.getTitle()}</h2>
                                    <p>${book.getPrice()} đ</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div>
                <div class="container">
                    <ol class="breadcumb">
                        <li class="home"><a href="#">Trang Chủ</a></li>
                    </ol>
                </div>
            </div>
        </div>
    </body>
</html>
