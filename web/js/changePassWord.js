/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

    let oldPasswordValid = false;
    let newPasswordValid = false;
    let confirmNewPasswordValid = false;   
            
    function checkOldPasswords() {
        const oldPassword = document.getElementById('oldPassword').value;

        // Kiểm tra old password
        if (oldPassword.length >= 8 &&/^[A-Z].*$/.test(oldPassword) &&/^\S+$/.test(oldPassword)) {
            document.getElementById('oldPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
            oldPasswordValid = true;
        } else {
            document.getElementById('oldPasswordResult').innerHTML = "<span style='color:red;'>✘</span>";
            oldPasswordValid = false;
        }
        checkButton();
    }

    function checkNewPasswords() {
        const oldPassword = document.getElementById('oldPassword').value;
        const newPassword = document.getElementById('newPassword').value;

        // Kiểm tra new password
        if (newPassword.length >= 8 &&/^[A-Z].*$/.test(newPassword) &&/^\S+$/.test(newPassword)) {
            document.getElementById('newPasswordResult').innerHTML = "<span style='color:green;'>✔</span>";
            newPasswordValid = true;
        } else {
            document.getElementById('newPasswordResult').innerHTML = "<span style='color:red;'>✘</span>";
            newPasswordValid = false;
        }
        checkButton();
    }

    
    function checkConfirmNewPasswords() {
        const newPassword = document.getElementById('newPassword').value;
        const confirmNewPassword = document.getElementById('confirmNewPassword').value;
        // Check new password and confirm new password match
        if (confirmNewPassword !== "") {
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
    

let passwordVisible = [false, false, false]; // Mảng để lưu trữ trạng thái của từng trường mật khẩu

function togglePasswordVisibility(index) {
    let passwordInputId;
    if (index === 0) {
        passwordInputId = 'oldPassword';
    } else if (index === 1) {
        passwordInputId = 'newPassword';
    } else if (index === 2) {
        passwordInputId = 'confirmNewPassword';
    } else {
        console.error("Invalid index provided to togglePasswordVisibility function");
        return;
    }

    const passwordInput = document.getElementById(passwordInputId);
    const eyeIcon = document.getElementById(`togglePassword${index}`);

    passwordVisible[index] = !passwordVisible[index];

    if (passwordVisible[index]) {
        passwordInput.type = 'text';
        eyeIcon.src = 'https://cdn-icons-png.freepik.com/512/64/64943.png';
    } else {
        passwordInput.type = 'password';
        eyeIcon.src = 'https://rip.to/EZXBR';
    }
}

