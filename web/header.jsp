<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <li><a href="product">Product</a></li>
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