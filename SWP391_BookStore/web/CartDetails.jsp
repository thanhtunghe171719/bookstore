<%-- 
    Document   : newjsp
    Created on : May 27, 2024, 11:13:19 AM
    Author     : TDG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Vector, Entity.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change PassWord</title>
        <!--style-->
        <link href="./css/newcss.css" rel="stylesheet"/>
        <link href="./css/cssChangePassWord.css" rel="stylesheet"/>
        <style>

        
        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="content">
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
                        
                        
                    <div>
                        <!--bên trái-->
                        <div class="bar-search">
                            
                        </div>
                        <!--bên phải--> 
                        <div class="bar-list">
                            <!--trên bên phải-->
                            <div class="bar-list-top">
                                <div>
                                    <p>Sắp xếp theo: </p>
                                </div>
                                <div class="option-list">
                                    <select class="selected-order" name="sort">
                                        <option value="new">Mới nhất</option>
                                        <option value="price_asce">Giá tăng dần</option>
                                        <option value="price_decr">Giá giảm dần</option>
                                    </select>
                                </div>
                            </div>
                            <!--dưới bên phải-->
                            <div class="list-cart-items">
                                
                            </div>
                        </div>
                        
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
        </div>
    </body>
    

</html>
