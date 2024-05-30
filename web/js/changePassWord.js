/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

    let oldPasswordValid = false;
    let newPasswordValid = false;
    let confirmNewPasswordValid = false;   
            
    function checkOldPasswords() {
        const oldPassword = document.getElementById('oldPassword').value;
        // Check old password
        if (oldPassword !== "") {
            document.getElementById('oldPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
            oldPasswordValid = true;
        } else {
            document.getElementById('oldPasswordResult').innerHTML = "<span style='color:red;'>✘ not empty</span>";
            oldPasswordValid = false;
        }
        checkNewPasswords();
        checkConfirmNewPasswords();
        checkButton();
    }        
    
    function checkNewPasswords() {
        const oldPassword = document.getElementById('oldPassword').value;
        const newPassword = document.getElementById('newPassword').value;
        //check old password different new password
        if (newPassword !== "") {
            if (newPassword !== oldPassword) {
                document.getElementById('newPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
                newPasswordValid = true;
            }else{
                document.getElementById('newPasswordResult').innerHTML = "<span style='color:red;'>✘ not same old password</span>";
                newPasswordValid =false;
            }
        } else {
            document.getElementById('newPasswordResult').innerHTML = "<span style='color:red;'>✘ not empty</span>";
            newPasswordValid =false;
        }
        checkOldPasswords();
        checkConfirmNewPasswords();
        checkButton();
    }
    
    function checkConfirmNewPasswords() {
        const newPassword = document.getElementById('newPassword').value;
        const confirmNewPassword = document.getElementById('confirmNewPassword').value;
        // Check new password and confirm new password match
        if (newPassword !== "") {
            if (newPassword === confirmNewPassword) {
                document.getElementById('confirmNewPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
                confirmNewPasswordValid = true;
            }else{
                document.getElementById('confirmNewPasswordResult').innerHTML = "<span style='color:red;'>✘ not same new password</span>";
                confirmNewPasswordValid = false;
            }
        } else {
            document.getElementById('confirmNewPasswordResult').innerHTML = "<span style='color:red;'>✘ not empty</span>";
            confirmNewPasswordValid = false;
        }
        checkButton();
    }

        function checkButton() {
            
            // Show or hide save button
            if (oldPasswordValid && newPasswordValid && confirmNewPasswordValid) {
                document.getElementById('saveButton').style.display = 'inline';
                document.getElementById('check-3-password').innerHTML = "";
            } else {
                document.getElementById('saveButton').style.display = 'none';
                //document.getElementById('check-3-password').innerHTML = "<span style='color:red;'>empty or input wrong</span>";
            }
        }
        