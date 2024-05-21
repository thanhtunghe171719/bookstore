<%-- 
    Document   : index
    Created on : May 20, 2024, 10:46:59 AM
    Author     : TDG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Vector, Entity.*" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <link rel="icon" href="images/fevicon.png" type="image/gif" />
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  
  
  <title>Home</title>


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

  
  
</head>

<body>

  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section long_section px-0">
      <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a class="navbar-brand" href="index.html">
          <span>
            BookShop
          </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class=""> </span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
            <ul class="navbar-nav ">
              <li class="nav-item active">
                <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="about.html"> Product</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="furniture.html">Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="blog.html">Cart</a>
              </li>   
            </ul>
          </div>
          <div class="quote_btn-container">
            <a href="">
              <span>
                    <%String user = (String) request.getAttribute("user");%>
                    <%
                        if (user != null) {
                    %>
                            Hello, <%= user %>
                    <%
                        } else {
                    %>
                            Login
                    <%
                        }
                    %>

              </span>
              <i class="fa fa-user" aria-hidden="true"></i>
            </a>
            <form class="form-inline">
              <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                <i class="fa fa-search" aria-hidden="true"></i>
              </button>
            </form>
          </div>
        </div>
      </nav>
    </header>
    <!-- end header section -->
    
    <!-- slider section -->
            <% 
              Vector<Campaigns> vectorCam = (Vector<Campaigns>) request.getAttribute("3campaigns");
              if (vectorCam != null && !vectorCam.isEmpty()) {
            %>   
    <section class="slider_section long_section">
      <div id="customCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            

                  <div class="carousel-item active">
                    <div class="container ">
                      <div class="row">
                        <div class="col-md-5">
                          <div class="detail-box">
                            <p>
                              <%= vectorCam.get(0).getDescription()%>
                            </p>
                            <div class="btn-box">
                              <a href="" class="btn1">
                                Read More
                              </a>
                              
                            </div>
                          </div>
                        </div>
                        <div class="col-md-7">
                          <div class="img-box">
                            <img src="images/slider-img.png" alt="">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <div class="container ">
                      <div class="row">
                        <div class="col-md-5">
                          <div class="detail-box">
                            
                            <p>
                              <%= vectorCam.get(1).getDescription()%>
                            </p>
                            <div class="btn-box">
                              <a href="" class="btn1">
                                Read More
                              </a>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-7">
                          <div class="img-box">
                            <img src="images/slider-img.png" alt="">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <div class="container ">
                      <div class="row">
                        <div class="col-md-5">
                          <div class="detail-box">
                            
                            <p>
                              <%= vectorCam.get(2).getDescription()%>
                            </p>
                            <div class="btn-box">
                              <a href="" class="btn1">
                                Read More
                              </a>
                              
                            </div>
                          </div>
                        </div>
                        <div class="col-md-7">
                          <div class="img-box">
                            <img src="images/slider-img.png" alt="">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
            
            </div>
            <ol class="carousel-indicators">
              <li data-target="#customCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#customCarousel" data-slide-to="1"></li>
              <li data-target="#customCarousel" data-slide-to="2"></li>
            </ol>
          </div>
 
    </section>
        <%}%>                    
    <!-- end slider section -->
    
  </div>

  <!-- furniture section -->

  <section class="furniture_section layout_padding">
    <div class="container">
      <div class="heading_container">
        <h2>
          Xu Hướng Mua Sắm
        </h2>
          <table >
              <tr>
                  <td ><a href="HomePageURL?service=sale">Giảm Giá</a></td>
                  <td ><a href="HomePageURL?service=sold">Số Lượng Bán</a></td>
                  <td ><a href="HomePageURL?service=new">Sản Phẩm Mới</a></td>
              </tr>
          </table>
      </div>
      
      <% 
         Vector<Product> vectorPro = (Vector<Product>) request.getAttribute("6products");
         if (vectorPro != null && !vectorPro.isEmpty()) {
            int count = 0;
            for (Product product : vectorPro) {
               if (count % 3 == 0) {
                   if (count > 0) {
                       out.println("</div>");
                   }
                   out.println("<div class='row'>");
               }
                double originalPrice = product.getPrice();
                int discount = product.getDiscount();
                double discountedPrice = originalPrice - (originalPrice * discount / 100);
    
      %>     

                <div class="col-md-6 col-lg-4">
                  <div class="box">
                    <div class="img-box">
                        <img src="<%=product.getPicture()%>" alt="">
                    </div>
                    <div class="detail-box">
                      <h5>
                        <%=product.getTitle()%>
                      </h5>
                      <div class="price_box">
                        <h6 class="price_heading">
                          <% if (discount > 0) { %>
                            <span style="text-decoration: line-through;">$<%= originalPrice %></span>
                            <span>$<%= String.format("%.2f", discountedPrice) %> (<%= discount %>% off)</span>
                          <% } else { %>
                            <span>$<%= originalPrice %></span>
                          <% } %>
                        </h6>
                        <a href="">
                          Detail
                        </a>
                        <a href="">
                          Buy
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              
      
      <%
            count++;
            }
            if (count > 0) {
                out.println("</div>");
            }
        }
      %>
      
    </div>
  </section>
  <!-- end furniture section -->

            <!--footer-->
            <div class="footer">
                <div>
                    <p>Email : abc123@gmail.com</p>
                    <p>Address : Hoa Lac, Thach That, Ha Noi, Vietnam</p>
                    <p>Number Phone : 0197913546</p>
                </div>
            </div>
            <!--end footer-->

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap"></script>
  <!-- End Google Map -->

</body>

</html>