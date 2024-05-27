<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login and Register</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="form-container sign-up-container">
                <form id="registerForm">
                    <h1>Create Account</h1>
                    <input type="text" placeholder="H? và Tên" required>
                    <input type="email" placeholder="Email" required>
                    <input type="password" placeholder="M?t kh?u" required>
                    <button type="submit">Register</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <div style="color: red">${mess}</div>
                <form id="loginForm">
                    <h1>Login</h1>
                    <input type="text" placeholder="Username" required>
                    <input type="password" placeholder="Password" required>
                    <button type="submit">Login</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To stay connected with us, please log in with your personal information</p>
                        <button class="ghost" id="signIn">Login</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello!</h1>
                        <p>Enter your personal details and start your journey with us</p>
                        <form id="overlayRegisterForm">
                            <h1>Create Account</h1>
                            <input type="text" placeholder="Username" required>
                            <input type="password" placeholder="Password" required>
                            <button type="submit">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script>
            document.getElementById('loginForm').addEventListener('submit', function(event) {
                event.preventDefault();
                // Simulate successful login
                window.location.href = 'homepage.jsp';
            });

            document.getElementById('registerForm').addEventListener('submit', function(event) {
                event.preventDefault();
                // Simulate successful registration
                window.location.href = 'homepage.jsp';
            });

            document.getElementById('overlayRegisterForm').addEventListener('submit', function(event) {
                event.preventDefault();
                // Simulate successful registration
                window.location.href = 'homepage.jsp';
            });
        </script>
    </body>
</html>
