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
        <!--<link href="css/styleHomePage.css" rel="stylesheet"/>-->
        <style>
            .container-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 20px;
                background-color: #f8f8f8;
            }
            .logo-column a {
                font-size: 24px;
                font-weight: bold;
                text-decoration: none;
                color: #000;
            }
            .menu ul, .user-info ul {
                display: flex;
                list-style-type: none;
                margin: 0;
                padding: 0;
            }
            .menu ul li, .user-info ul li {
                margin-right: 100px;
            }
            .menu ul li a, .user-info ul li a {
                text-decoration: none;
                color: #000;
                font-size: 18px;
            }
            .user-info ul li a {
                font-weight: bold;
            }
            
            
/* Định dạng carousel */

.carousel {
    width: 100%;
    margin: auto;
    margin-bottom: 20px;
    overflow: hidden; /* Ngăn chặn các phần tử tràn ra ngoài */
}

/* Hiển thị carousel item trên cùng một hàng */
.carousel-inner {
    display: flex;
    flex-wrap: nowrap; /* Không cho phép wrap sang dòng mới */
}

/* Định dạng mỗi carousel item */
.carousel-item {
    flex: 0 0 auto;
    width: 15%; /* Mỗi item chiếm toàn bộ chiều rộng của carousel */
    padding: 10px;
    position: relative;
}
.carousel-item:nth-child(1), .carousel-item:nth-child(3) {
    display: flex; /* Sử dụng Flexbox */
    align-items: center; /* Canh giữa nội dung theo chiều dọc */
}
.carousel-item:nth-child(2) {
    flex: 0 0 auto;
    width: 65%;
}
.carousel-item img {
    display: block;
    margin: 0 auto; /* Căn giữa theo chiều ngang */
}
/* Định dạng cho hình ảnh trong carousel item */
.carousel-item:nth-child(1) img, .carousel-item:nth-child(3) img{
    width: 200px;
    height: 300px;
    object-fit: cover;
}
.carousel-item:nth-child(2) img{
    width: 900px;
    height: 600px;
    object-fit: cover;
}
/* Định dạng cho các dấu chấm chỉ mục */
.carousel-indicators {
    list-style-type: none;
    display: flex;
    justify-content: center;
    padding: 0;
    margin-top: 10px; /* Thêm khoảng cách giữa carousel và các dấu chấm chỉ mục */
}

.carousel-indicators li {
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: #ccc;
    margin: 0 5px;
    cursor: pointer;
}

.carousel-indicators li.active {
    background-color: #000;
}

.slider_section .carousel-item .read_more a {
  display: inline-block;
  padding: 10px 15px;
  background-color: #f89646;
  color: #ffffff;
  border-radius: 0;
  border: 1px solid #f89646;
  -webkit-transition: all .2s;
  transition: all .2s;
}

.slider_section .carousel-ite .read_more a :hover {
  background-color: transparent;
  color: #f89646;
}

.read_more {
  position: absolute;
  bottom: 20%; /* Điều chỉnh khoảng cách từ dưới lên */
  left: 20%;
  transform: translateX(-50%);
  color: white;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
}



.body-page {
    width: 100%;
    overflow-x: auto; /* Cho phép cuộn ngang nếu nội dung quá rộng */
}

.table-container {
    width: 100%;
    overflow-x: auto; /* Cho phép cuộn ngang nếu bảng quá rộng */
}

.custom-table {
    width: 100%;
    border-collapse: collapse;
    table-layout: fixed; /* Đảm bảo bảng có kích thước cố định */
}

.custom-table th,
.custom-table td {
    padding: 10px;
    text-align: center;
}

.custom-table th {
    font-weight: bold;
    border: 1px black solid;
}

.custom-table th a,
.custom-table td a {
    color: #000;
    text-decoration: none;
}

.custom-table th a:hover,
.custom-table td a:hover {
    color: #f89646; /* Màu khi rê chuột qua */
}

.trend-heading {
    font-size: 20px;
    font-weight: bold;
    text-align: center;
}

.custom-table tr:first-child {
    background-color: #fcddef; /* Đặt màu nền cho hàng đầu tiên */
}

.custom-table th {
    width: calc(100% / 3); /* Chia đều độ rộng của các cột */
}


.product-table {
    width: 100%;
    margin-top: 20px; /* Khoảng cách giữa bảng sản phẩm và bảng xu hướng mua sắm */
    border-collapse: collapse;
}

.product-box {
    border: 1px solid #ccc; /* Đường viền cho sản phẩm */
    padding: 10px;
    margin-bottom: 20px; /* Khoảng cách giữa các sản phẩm */
}

.product-img img {
    width: 100%; /* Hiển thị ảnh sản phẩm full width */
    height: auto; /* Duy trì tỷ lệ khung hình */
}

.product-detal {
    padding: 10px;
}

.product-detal h4 {
    margin-top: 0; /* Loại bỏ khoảng trắng trên của tiêu đề */
}

.product-price {
    font-size: 20px;
    font-weight: bold;
    color: #f89646; /* Màu cho giá sản phẩm */
}

.add-cart {
    margin-top: 10px; /* Khoảng cách giữa giá và nút mua */
}

.add-cart a {
    display: inline-block;
    padding: 5px 10px;
    margin-right: 10px; /* Khoảng cách giữa các nút */
    text-decoration: none;
    color: #fff;
    background-color: #f89646; /* Màu nền của nút */
    border-radius: 5px; /* Bo tròn góc của nút */
}

.add-cart a:hover {
    background-color: #000; /* Màu nền của nút khi rê chuột qua */
}



    .product-table td {
        padding: 10px; /* Space between product cells */
    }

    .product-box {
        width: 200px; /* Fixed width for product box */
        margin: auto; /* Center product box */
    }

    .product-img img {
        width: 100px; /* Smaller image width */
        height: 100px; /* Smaller image height */
    }


.footer {
    background-color: #0db3fd91; /* Background color */
    padding: 20px; /* Padding around the content */
    text-align: center; /* Center-align the content */
}

.footer p {
    font-size: 20px;
    margin: 5px 0; /* Add some space between paragraphs */
}




            
        </style>
    </head>
    <body>
        
        <!--header-->
        <div class="container-header" >
            <!--logo-->
            <div class="logo-column">
                <a href="HomePage.html" >BOOKSHOP</a>
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
                    <li><a href="#">Hello, <%= user %></a></li>
                    <%
                        } else {
                    %>
                        <li><a href="#">Login</a></li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>

        <% 
            Vector<Campaigns> vectorCam = (Vector<Campaigns>) request.getAttribute("3campaigns");
            
        %> 
        
        <!--slide-->
        <section class="slider_section">
            <div class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item " onclick="showSlide(0)">
                        <div>
                            <img src="<%= vectorCam.get(0).getImage()%>"> 
                            <div class="read_more" style="display: none" onclick="showSlide(0)">
                                <p><%= vectorCam.get(0).getDescription()%></p>
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
                                <p><%= vectorCam.get(1).getDescription()%></p>
                                <a href="HomePage.html">
                                    Read More
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item" onclick="showSlide(2)">
                        <div>
                            <img src="<%= vectorCam.get(2).getImage()%>">
                            <div class="read_more" style="display: none" onclick="showSlide(2)">
                                <p><%= vectorCam.get(2).getDescription()%></p>
                                <a href="HomePage.html">
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
                <tr>
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
        int originalPrice = product.getPrice();
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
                        <a href="HomePage.html">Detail</a>
                        <a href="HomePage.html">Buy</a>
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
                
                </tr>
            </table>

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
