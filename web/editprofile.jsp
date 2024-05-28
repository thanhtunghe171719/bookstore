<%-- 
    Document   : editProfile
    Created on : May 27, 2024, 2:06:51 PM
    Author     : kobietkolam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Profile</title>
        <link rel="stylesheet" href="styles.css">
        <link href="./css/newcss.css" rel="stylesheet"/>
        <link href="./css/cssChangePassWord.css" rel="stylesheet"/>
        <link href="./css/customStyles.css" rel="stylesheet"/>
        <style>
            .tab-pane {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #f9f9f9; /* Light grey background for contrast */
            }

            .login {
                width: 100%;
                max-width: 500px;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                background-color: #fff;
                border-radius: 8px;
            }

            .login_form_container {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .form-row {
                width: 100%;
                margin-bottom: 15px;
            }

            .form-row label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            .input_type {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .save_button {
                width: 100%;
                display: flex;
                justify-content: center;
            }

            .primary_btn {
                background-color: #007bff; /* Blue color for the button */
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .primary_btn:hover {
                background-color: #0056b3; /* Darker blue on hover */
            }

            .edit {
                background-color: transparent; /* Transparent background */
                color: #007bff; /* Blue text color */
                padding: 10px 20px;
                border: 2px solid #007bff; /* Blue border */
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease, color 0.3s ease;
            }

            .edit:hover {
                background-color: #007bff; /* Blue background on hover */
                color: #fff; /* White text color on hover */

            }


        </style>
    </head>
    <body>
        <!--header-->
       
            <div class="content" >
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

                </div>
            </div>
                

        <!--profile popup-->
        <div class="tab-pane fade show active" id="account-details">
  
            <c:if test="${requestScope.STATUS != null}">
                <h6 style="color: green">${requestScope.STATUS}</h6>
            </c:if>
            <div class="login">
                <div class="login_form_container">
                    <form id="form-1" action="editprofile" method="post">
                        <input type="hidden" name="user_id" value="${user.userId}">
                        <div class="form-row">
                            <label for="fullname">Full Name</label>
                            <input class="input_type" type="text" name="fullname" value="${user.fullname}" readonly>
                        </div>
                        <div class="form-row">
                            <label for="email">Email</label>
                            <input class="input_type" type="text" name="email" value="${user.email}" readonly>
                        </div>
                        <div class="form-row">
                            <label for="gender">Gender</label>
                            <input class="input_type" type="text" name="gender" value="${user.gender}" readonly>
                        </div>
                        <div class="form-row">
                            <label for="address">Address</label>
                            <input class="input_type" type="text" name="address" value="${user.address}" readonly>
                        </div>
                        <div class="form-row">
                            <label for="phone">Phone</label>
                            <input class="input_type" type="text" name="phone" value="${user.phone}" readonly>
                        </div>
                        <div class="save_button">
                            <button onclick="changeType(this)" id="edit" type="button" class="edit">Edit</button>
                        </div>
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

        <script type="text/javascript">
            function changeType(button) {
                var inputElements = document.querySelectorAll(".input_type");
                if (button.id === "edit") {
                    button.id = "save";
                    button.textContent = "Save";
                    inputElements.forEach(x => {
                        if (x.name !== "email") {
                            x.readOnly = false;
                            x.classList.add("default_input");
                        }
                    });
                } else {
                    document.getElementById("form-1").submit();
                }
            }
        </script>
    </div>
</body>
</html>

