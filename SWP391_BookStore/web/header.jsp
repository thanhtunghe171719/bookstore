<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Vector, Entity.*" %>
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
        </ul>
    </div>

    <!--user info-->
    <div class="user-info">
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
                                    <a href="#" style="font-size: 15px;padding-right: 10px;">user profile</a>
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