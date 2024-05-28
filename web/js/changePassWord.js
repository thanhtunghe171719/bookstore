/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


        const storedPassword = "";

        function checkPasswords() {
            const oldPassword = document.getElementById('oldPassword').value;
            const newPassword = document.getElementById('newPassword').value;
            const confirmNewPassword = document.getElementById('confirmNewPassword').value;

            let oldPasswordValid = false;
            let newPasswordValid = false;
            let confirmNewPasswordValid = false;

            // Check old password
            if (oldPassword === storedPassword) {
                document.getElementById('oldPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
                oldPasswordValid = true;
            } else {
                document.getElementById('oldPasswordResult').innerHTML = "<span style='color:red;'>✘</span>";
            }

            //check old password different new password
            if (newPassword !== "" && newPassword !== storedPassword) {
                document.getElementById('newPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
                newPasswordValid = true;
            } else {
                document.getElementById('newPasswordResult').innerHTML = "<span style='color:red;'>✘</span>";
            }
            
            // Check new password and confirm new password match
            if (newPassword !== "" && newPassword === confirmNewPassword) {
                document.getElementById('confirmNewPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
                newPasswordValid = true;
                confirmNewPasswordValid = true;
            } else {
                document.getElementById('confirmNewPasswordResult').innerHTML = "<span style='color:red;'>✘</span>";
            }

            // Show or hide save button
            if (oldPasswordValid && newPasswordValid && confirmNewPasswordValid) {
                document.getElementById('saveButton').style.display = 'inline';
                document.getElementById('check-3-password').innerHTML = "";
            } else {
                document.getElementById('saveButton').style.display = 'none';
                document.getElementById('check-3-password').innerHTML = "<span style='color:red;'>empty or input wrong</span>";
            }
        }
        
        function showAlert() {
            alert("Change successful");
            return true;
        }