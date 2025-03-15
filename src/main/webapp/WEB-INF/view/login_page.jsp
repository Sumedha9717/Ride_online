<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log_in page</title>
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/ride-online-application/css/log_reg_fo.css">
    <link rel="stylesheet" type="text/css" href="./css/log_reg_fo.css">
</head>
<body>
	<div class="container">

        <div class="left-div">
            <div class="left-image">
                <img src="./images/Login.png" alt="login_img">
            </div>
            <div class="left-text">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora alias temporibus nihil quasi ut
                    quae?</p>
            </div>
        </div>

        <!-- right div start  -->

        <div class="right-div">
            <h4>Welcome Back</h4>
            <form action="LoginController?action=enter" method="post" class="right-form">

                <ul>
                    <li>
                        <h3>Login Your Account</h3>
                    </li>
                    <li><i class="fas fa-user"></i> <input type="text" name="email" placeholder="Username" required></li>
                    <li><i class="fas fa-lock"></i> <input type="password" name="password" placeholder="Password" required></li>
                    <li><input type="submit" value="Login"></li>
                </ul>

            </form>

            <div class="footer">
                <ul>
                    <li><a href="LoginController?action=register">Create account</a></li>
                    <li><a href="Forgot Password.html">Forgot password?</a></li>
                    <li><a href="/ride-online-application/index.jsp">Back</a></li>
                </ul>
            </div>
            <div class="vr-line"></div>
        </div>

    </div>
</body>
</html>