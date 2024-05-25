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
        <jsp:include page="header.jsp"/>

        <div class="main">
            <div class="container">
                <div class="search_container">
                    <form action="search" method="post">
                        <input name="search" class="search_input" type="text" placeholder="Search">
                    </form>
                </div>
            </div>
            <div class="container">
                <div class="sidebar">
                    <dl class="narrow-by-list">
                        <dt class="odd">NHÓM SẢN PHẨM</dt>
                        <dd class="odd">
                            <ol>
                                <li>
                                    <a href="product">Tất Cả Nhóm Sản Phẩm</a>
                                </li>
                            </ol>
                            <c:forEach var="category" items="${category}">
                                <div class="odd" id="current-category">
                                    <a class="${tag == category.categoryId ? "active-category" : "normal-category"}" href="product?categoryid=${category.categoryId}">${category.getCategoryName()}</a>
                                </div>
                            </c:forEach>
                            <input type="hidden" id="currentCategoryId" value="${param.categoryid}">
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
                                            <select class="selected-order" name="sort" id="sort" onchange="location = this.value;">
                                                <option value="product?categoryid=${param.categoryid}&index=1&sort=newest" <% if((request.getAttribute("sort") != null) && request.getAttribute("sort").equals("newest")){ %> selected <% } %>>Mới nhất</option>
                                                <option value="product?categoryid=${param.categoryid}&index=1&sort=price_asc" <% if((request.getAttribute("sort") != null) && request.getAttribute("sort").equals("price_asc")){ %> selected <% } %>>Giá tăng dần</option>
                                                <option value="product?categoryid=${param.categoryid}&index=1&sort=price_desc" <% if((request.getAttribute("sort") != null) && request.getAttribute("sort").equals("price_desc")){ %> selected <% } %>>Giá giảm dần</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <input type="hidden" id="currentCategoryId" value="${param.categoryid}">

                    <div class="product-row">
                        <div class="products-grid">
                            <c:forEach items="${book}" var="book">
                                <div class="product-item">
                                    <div class="product-content">
                                        <div class="product-clearfix">
                                            <a href="#">
                                                <span>
                                                    <img class="product-image" src="${book.getImage()}" alt="${book.getTitle()}" border="0">
                                                </span>
                                            </a>
                                        </div>
                                        <h2 class="product-title">
                                            <a class="product-text" href="#">${book.getTitle()}</a>
                                        </h2>
                                        <div class="product-price">
                                            <span>${book.getPrice()} đ</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="index-page">
                        <c:if test="${pagetag > 1}">
                            <a class="icon-turn-left" href="product?categoryid=${param.categoryid}&index=${pagetag - 1}">&nbsp;</a>
                        </c:if>
                        <c:forEach begin="1" end="${page}" var="page">
                            <li>
                                <a class="${pagetag == page ? "active-page" : ""}" href="product?categoryid=${param.categoryid}&index=${page}">${page}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${pagetag < page}">
                            <a class="icon-turn-right" href="product?categoryid=${param.categoryid}&index=${pagetag + 1}">&nbsp;</a>
                        </c:if>
                    </div>
                </div>
            </div>

            <div>
                <div class="container">
                    <ol class="breadcumb">
                        <li class="home"><span>&nbsp;</span></li>
                    </ol>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
