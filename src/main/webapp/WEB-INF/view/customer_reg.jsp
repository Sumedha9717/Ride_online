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
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/ride_online/css/log_reg_fo.css">
</head>
<body>
	<div class="container">

        <div class="left-div">
            <div class="left-image">
                <img src="/ride_online/images/Login.png" alt="login_img">
            </div>
            <div class="left-text">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora alias temporibus nihil quasi uequae?</p>
                <a href="/ride_online/index.jsp"><button class="btn btn-light btn-sm">Back</button></a>
            </div>
        </div>

        <!-- right div start  -->

        <div class="right-div">
            <h4>Welcome</h4>
            <form action="RegisterController?action=enter" method="post" class="right-form createNew-form">

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
        			<input type="hidden" name="role" value="customer"> <!-- Set the role to "Customer" -->
                    <input type="submit" value="Register">
                    </li>
                </ul>

            </form>

            <div class="footer createNew-footer">
                <ul>
                    <li><a href="index.jsp">Back</a></li>

                </ul>
            </div>
            <div class="vr-line"></div>
        </div>
    </div>

<!-- Bootstrap Modal for Error Messages -->
    <div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body text-center">
                    <p id="modalMessage">${errorMessage}</p> <!-- Error message from server -->
                </div>
                <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Check if there's an error message from the server
        const errorMessage = "<%= request.getAttribute("errorMessage") %>";
        if (errorMessage && errorMessage.trim() !== "" && errorMessage !== "null") {
            // Update the modal message
            document.getElementById("modalMessage").innerText = errorMessage;
            // Show the modal
            const errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
            errorModal.show();
        }

        // Function to validate the form
        function validateForm() {
            const username = document.getElementById("username").value.trim();
            const email = document.getElementById("email").value.trim();
            const password = document.getElementById("password").value.trim();
            const confirmPassword = document.getElementById("confirm_password").value.trim();

            // Validate password length
            if (password.length < 8) {
                document.getElementById("modalMessage").innerText = "Password must be at least 8 characters long.";
                const errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
                errorModal.show();
                return false; // Prevent form submission
            }

            // Validate password match
            if (password !== confirmPassword) {
                document.getElementById("modalMessage").innerText = "Passwords do not match.";
                const errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
                errorModal.show();
                return false; // Prevent form submission
            }

            // Validate email format
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                document.getElementById("modalMessage").innerText = "Please enter a valid email address.";
                const errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
                errorModal.show();
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }
    </script>

</body>
</html>