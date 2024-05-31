<%-- 
    Document   : ChangePassWord
    Created on : May 23, 2024, 8:59:42 AM
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
                        
                        
                    <% 
                        Vector<users> userInfor = (Vector<users>) request.getAttribute("userInfor");
                    %>     
                        <div class="user-setting">
                            <div class="menu-setting-user">
                                <div style="padding-bottom: 50px;"><div class="circle-user">PICTURE</div></div>
                                <ol>
                                    <li><a href="#">1.profile user</a></li>
                                    <li><a href="#">2.change password</a></li>
                                </ol>
                            </div>     
                            <div class="content-user-setting">
                                <form action="ChangePassWordURL?service=changePassWord" method="get">
                                    <table class="table-change-password">
                                        <caption style="font-size: 20px;padding: 10px;font-weight: bold;">Change Password</caption>
                                        <tr>
                                            <td>Old password </td>
                                            <td><input type="password" id="oldPassword" onkeyup="checkPasswords()"></td>
                                            <td id="oldPasswordResult"></td>
                                        </tr>
                                        <tr>
                                            <td>New password </td>
                                            <td><input type="password" id="newPassword" name="newPassword" onkeyup="checkPasswords()"></td>
                                            <td id="newPasswordResult"></td>
                                        </tr>
                                        <tr>
                                            <td>Confirm new password </td>
                                            <td><input type="password" id="confirmNewPassword" onkeyup="checkPasswords()"></td>
                                            <td id="confirmNewPasswordResult"></td>
                                        </tr>
                                        <tr>
                                            <td id="check-3-password"></td>
                                            <td colspan="3" style="text-align: center;">
                                                <input type="submit" id="saveButton" class="save-button" name="submit" value="save">
                                            </td>
                                        </tr>
                                    </table>
                                </form>
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
    
    
    <script src="./js/changePassWord.js"></script>
    <script>
        

    </script>
</html>
