<%-- 
    Document   : index
    Created on : May 21, 2024, 4:42:25 PM
    Author     : TDG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Vector, Entity.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--style-->
        <link href="./css/newcss.css" rel="stylesheet"/>
 
    </head>
    <body>
        
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
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Cart</a></li>
                    <div class="search_container">
                        <form action="search" method="post">
                            <input name="search" class="search_input" type="text" placeholder="Search product">
                        </form>
                    </div>
                </ul>
            </div>

            <!--user info-->
            <div class="user-info">
                <ul>
                    <% Vector<users> userVector = (Vector<users>) request.getAttribute("userVector"); %>
                    <%
                        if (userVector != null) {
                    %>
                    <li>
                        <a>Hello, <%=userVector.get(0).getFullname()%></a>
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
            </div>
        </div>

        <% 
            Vector<Slider> vectorCam = (Vector<Slider>) request.getAttribute("3slider");
            
        %> 
        
        <!--slide-->
        <section class="slider_section">
            <div class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="left-column">
                        <div class="carousel-item " onclick="showSlide(0)">
                            <div>
                                <img src="<%= vectorCam.get(0).getImage()%>"> 
                                <div class="read_more" onclick="showSlide(0)">
                                    <p><%= vectorCam.get(0).getTitle()%></p>
                                    <a href="#">
                                        Read More
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                                    
                    <div class="right-column">
                        <div class="carousel-item " onclick="showSlide(1)">
                            <div>
                                <img src="<%= vectorCam.get(1).getImage()%>">
                                <div class="read_more" style="display: none" onclick="showSlide(1)">
                                    <p><%= vectorCam.get(1).getTitle()%></p>
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
                                    <p><%= vectorCam.get(2).getTitle()%></p>
                                    <a href="#">
                                        Read More
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <ol class="carousel-indicators">
                    <li data-slide-to="0" class="active" onclick="showSlide(0)"></li>
                    <li data-slide-to="1" onclick="showSlide(1)"></li>
                    <li data-slide-to="2" onclick="showSlide(2)"></li>
                </ol>
            </div>
        </section>
            
 
                                
                                    <br>
    <div class="body-page">
        <div class="table-container">
            <table class="custom-table">
                <thead>
                    <tr>
                        <th colspan="3" class="trend-heading">Xu Hướng Mua Sắm</th>
                    </tr>
                    <tr>
                        <th><a href="home?service=sale">Giảm Giá</a></th>
                        <th><a href="home?service=sold">Số Lượng Bán</a></th>
                        <th><a href="home?service=new">Sản Phẩm Mới</a></th>
                    </tr>
                </thead>
            </table>
 
            <table class="product-table">
                
<%
    Vector<Books> vectorPro = (Vector<Books>) request.getAttribute("5products");
    if(vectorPro != null){
    int counter = 0; 
    for (Books book : vectorPro) {
        if (counter % 5 == 0) { 
            if (counter > 0) {
                out.println("</tr>");
            }
            out.println("<tr>");
        }
        double originalPrice = Double.parseDouble(book.getPrice());
        int discount = book.getDiscount();
        double discountedPrice = originalPrice - (originalPrice * discount / 100.0);
%>
        <td> 
            <div class="product-box"> 
                <div class="product-img">
                    <img src="<%=book.getImage()%>" alt="alt"/> 
                </div>
                <div class="product-detail">
                    <h4><%=book.getTitle()%></h4>
                    
                    <div class="product-price">
                        <% if (discount > 0) { %>
                            <span style="text-decoration: line-through;">$<%= originalPrice %></span>
                            <span>$<%= String.format("%.2f", discountedPrice) %> (<%= discount %>% off)</span>
                        <% } else { %>
                            <span>$<%= originalPrice %></span>
                        <% } %>
                    </div>
                    <div class="detail-product">
                        <a href="#">Detail</a>
                    </div>
                </div>
            </div>
        </td>
<%
        counter++;
    }
    if (counter % 5 != 0) {
        out.println("</tr>");
    }
}
%>

            </table>
        <div class="more-product"><a href="product">MORE PRODUCT</a></div>
        </div>
    </div>
<br>


<!--show any blog-->
<div class="blog-home">
    <table>
        <tr>
            <th colspan="5" style="font-size: 25px;">New Post</th>
        </tr>
        <tr>
            <%
                Vector<Post> vectorPost = (Vector<Post>) request.getAttribute("5post");
                if(vectorPost != null){
                    for (Post post : vectorPost) {
            %>
                <td>
                    <div class="each-post-home">
                        <img src="<%=post.getImage()%>" alt="alt"/> 
                        <h4><%=post.getTitle()%></h4>
                        <a href="#">read it</a>
                    </div>
                </td>
            <%}}%>
        </tr>
    </table>
        <div class="more-product"><a href="#">MORE POST</a></div>
</div>
        <br>
            <!--footer-->
            <div class="footer">
                <div>
                    <p>Email : abc123@gmail.com</p>
                    <p>Address : Hoa Lac, Thach That, Ha Noi, Vietnam</p>
                    <p>Number Phone : 0197913546</p>
                </div>
            </div>
            
        

        
        
    <!--JavaScript-->
    <!-- slide js -->
    <script src="js/slideHomePage.js"></script>
 
    </body>
</html>
