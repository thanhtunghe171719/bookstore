<%-- 
    Document   : blog
    Created on : May 28, 2024, 2:53:56 PM
    Author     : kobietkolam
--%>

<%@ page import="java.util.List" %>
<%@ page import="Entity.Post" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Blog</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <!--header-->
            <div class="container-header" >
                <!--logo-->
                <div class="logo-column">
                    <a href="home" >BOOKSHOP</a>
                </div>

                <!--menu-->
                <div class="menu">
                    <ul>
                        <li><a href="home">Home</a></li>
                        <li><a href="product">Product</a></li>
                        <li><a href="blog">Blog</a></li>
                        <li><a href="#">Cart</a></li>
                    </ul>
                </div>

                <!--user info-->
                <%-- <div class="user-info">
                    <ul>
                        <% users user = (users) request.getAttribute("user"); %>
                        <%
                            if (user != null) {
                        %>
                        <li>
                            <a>Hello, <%= user.getFullname() %></a>
                            <table>
                                <tr>
                                    <td >
                                        <a href="change-password" style="font-size: 15px;padding-right: 10px;">change password</a>
                                        <a href="editprofile" style="font-size: 15px;padding-right: 10px;">user profile</a>
                                        <a href="LogOutController" style="font-size: 15px;">Logout</a>
                                    </td>
                                </tr>
                            </table>
                        </li>
                        <%
                            } else {
                        %>
                        <li><a href="LoginController">Login</a></li>
                        <li><a href="RegisterController">Register</a></li>
                            <%
                                }
                            %>
                    </ul>
</div>--%>
            </div>

                <%--    <% 
                Vector<Slider> vectorCam = (Vector<Slider>) request.getAttribute("3slider");
            
%> 

            <!--slide-->
            <section class="slider_section">
                <div class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item " onclick="showSlide(0)">
                            <div>
                                <img src="<%= vectorCam.get(0).getImage()%>"> 
                                <div class="read_more" style="display: none" onclick="showSlide(0)">
                                    <p style="font-size: 20px;width: 400px"><%= vectorCam.get(0).getTitle()%></p>
                                    <a href="#">
                                        Read More
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item " onclick="showSlide(1)">
                            <div>
                                <img src="<%= vectorCam.get(1).getImage()%>">
                                <div class="read_more"onclick="showSlide(1)">
                                    <p style="font-size: 20px;width:400px "><%= vectorCam.get(1).getTitle()%></p>
                                    <a href="#">
                                        Read More
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item" onclick="showSlide(2)">
                            <div>
                                <img src="<%= vectorCam.get(2).getImage()%>">
                                <div class="read_more" style="display: none" onclick="showSlide(2)">
                                    <p style="font-size: 20px;width:400px "><%= vectorCam.get(2).getTitle()%></p>
                                    <a href="#">
                                        Read More
                                    </a>
                                </div>
                            </div>
                        </div>

                    </div>
                    <ol class="carousel-indicators">
                        <li data-slide-to="0" onclick="showSlide(0)"></li>
                        <li data-slide-to="1" class="active" onclick="showSlide(1)"></li>
                        <li data-slide-to="2" onclick="showSlide(2)"></li>
                    </ol>
                </div>
            </section>

%> --%>


            <div class="main-content">
                <div class="blog-posts">
                    <c:forEach var="post" items="${postList}">
                        <div class="post">
                            <img src="${post.thumbnail}" alt="${post.title}">
                            <h2><a href="post?id=${post.id}">${post.title}</a></h2>
                            <p>${post.briefInfo}</p>
                        </div>
                    </c:forEach>

                    <div class="pagination">
                        <c:forEach var="i" begin="1" end="${noOfPages}">
                            <a href="blog?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
                        </c:forEach>
                    </div>
                </div>
                <div class="sidebar">
                    <div class="search-box">
                        <h3>Search</h3>
                        <form action="search" method="get">
                            <input type="text" name="query" placeholder="Search posts...">
                            <button type="submit">Search</button>
                        </form>
                    </div>
                    <div class="categories">
                        <h3>Categories</h3>
                        <ul>
                            <c:forEach var="category" items="${categories}">
                                <li><a href="category?name=${category}">${category}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <div class="latest-posts">
                        <h3>Latest Posts</h3>
                        <ul>
                            <c:forEach var="latestPost" items="${latestPosts}">
                                <li><a href="post?id=${latestPost.id}">${latestPost.title}</a></li>
                                </c:forEach>
                        </ul>
                    </div>

                </div>
            </div>

            <div class="footer">
                <div>
                    <p>Email : abc123@gmail.com</p>
                    <p>Address : Hoa Lac, Thach That, Ha Noi, Vietnam</p>
                    <p>Number Phone : 0197913546</p>
                </div>
            </div>
        </div>
    </body>
</html>

