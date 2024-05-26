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
                <a href="HomePageURL" >BOOKSHOP</a>
            </div>

            <!--menu-->
            <div class="menu">
                <ul>
                    <li><a href="HomePageURL">Home</a></li>
                    <li><a href="#">Product</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Cart</a></li>
                </ul>
            </div>

            <!--user info-->
            <div class="user-info">
                <ul>
                    <% String user = (String) request.getAttribute("user"); %>
                    <%
                        if (user != null) {
                    %>
                    <li><a href="ChangePassWordURL">Hello, <%= user %></a></li>
                    <%
                        } else {
                    %>
                        <li><a href="ChangePassWordURL">Login</a></li>
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
            
 
                                

    <div class="body-page">
        <div class="table-container">
            <table class="custom-table">
                <thead>
                    <tr>
                        <th colspan="3" class="trend-heading">Xu Hướng Mua Sắm</th>
                    </tr>
                    <tr>
                        <th><a href="HomePageURL?service=sale">Giảm Giá</a></th>
                        <th><a href="HomePageURL?service=sold">Số Lượng Bán</a></th>
                        <th><a href="HomePageURL?service=new">Sản Phẩm Mới</a></th>
                    </tr>
                </thead>
            </table>
 
            <table class="product-table">
                
<%
    Vector<Product> vectorPro = (Vector<Product>) request.getAttribute("6products");
    int counter = 0; 
    for (Product product : vectorPro) {
        if (counter % 3 == 0) { 
            if (counter > 0) {
                out.println("</tr>");
            }
            out.println("<tr>");
        }
        int originalPrice = product.getPrice().intValue();
        int discount = product.getDiscount();
        double discountedPrice = originalPrice - (originalPrice * discount / 100.0);
%>
        <td style="padding: 5px;"> 
            <div class="product-box" style="width: 450px; margin: auto;"> 
                <div class="product-img">
                    <img src="<%=product.getImage()%>" alt="alt" style="width: 450px; height: 400px;"/> 
                </div>
                <div class="product-detail">
                    <h4><%=product.getTitle()%></h4>
                    
                    <div class="product-price">
                        <% if (discount > 0) { %>
                            <span style="text-decoration: line-through;">$<%= originalPrice %></span>
                            <span>$<%= String.format("%.2f", discountedPrice) %> (<%= discount %>% off)</span>
                        <% } else { %>
                            <span>$<%= originalPrice %></span>
                        <% } %>
                    </div>
                    <div class="add-cart">
                        <a href="#">Detail</a>
                        <a href="#">Buy</a>
                    </div>
                </div>
            </div>
        </td>
<%
        counter++;
    }
    if (counter % 3 != 0) {
        out.println("</tr>");
    }
%>

            </table>
        <div class="more-product"><a href="#">MORE</a></div>
        </div>
    </div>




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
