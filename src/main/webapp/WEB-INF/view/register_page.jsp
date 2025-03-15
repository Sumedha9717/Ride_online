<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New</title>
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
            <h4>Welcome</h4>
            <form action="LoginController?action=add" method="post" class="right-form createNew-form">

                <ul>
                    <li>
                        <h3>Create Your Account</h3>
                    </li>
                    <li>
                    <input type="text" placeholder="Username" id="username" name="username" required>
                    </li>
                    <li>
                    <input type="text" placeholder="Email" id="email" name="email" required>
                    </li>
                    <li>
                    <input type="password" placeholder="Password" id="password" name="password" required>
                    </li>
                    <li>
                    <input type="password" placeholder="Confirm Password" id="confirm_password" name="confirm_password" required>
                    </li>
                    <li>
                    <!-- Hardcoded role -->
        			<input type="hidden" name="role" value="Customer"> <!-- Set the role to "Customer" -->
                    <input type="submit" value="Register">
                    </li>
                </ul>

            </form>

            <div class="footer createNew-footer">
                <ul>
                    <li><a href="LoginController?action=back">Back</a></li>

                </ul>
            </div>

            <div class="footer createNew-footer">
                <ul>
                    <li><a href="LoginController?action=login>Back</a></li>

                </ul>
            </div>
            <div class="vr-line"></div>
        </div>

    </div>
</body>
</html>