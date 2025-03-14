<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Log_in page</title>
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
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora alias temporibus nihil quasi utquae?</p>
                    <a href="/ride_online/index.jsp"><button class="btn btn-light btn-sm">Back</button></a>
                </div>
            </div>

            <!-- right div start  -->

            <div class="right-div">
                <h4>Welcome Back</h4>
                <form action="Login?action=access" method="post" class="right-form" onsubmit="return validateForm()">

                    <ul>
                        <li>
                            <h3>Login Your Account</h3>
                        </li>
                        <li><i class="fas fa-user"></i> <input type="text" name="username" placeholder="Username" required></li>
                        <li><i class="fas fa-lock"></i> <input type="password" name="password" placeholder="Password" required></li>
                        <li><input type="submit" value="Login"></li>
                    </ul>

                </form>

                <div class="footer">
                    <ul>
                        <li><a href="RegisterController?action=register">Create account</a></li>
                        <li><a href="Forgot Password.html">Forgot password?</a></li>
                        <li type="hidden"><a href="#">fot</a></li>
                    </ul>
                </div>
                <div class="vr-line"></div>
            </div>

        </div>

        <!-- show Error Messages -->
        <div class="modal fade" id="messageModal" tabindex="-1" aria-labelledby="messageModalLabel" aria-hidden="true">
               <div class="modal-dialog">
                   <div class="modal-content">
                       <div class="modal-body text-center">
                           <p id="modalMessage">Please login</p> <!-- Default message -->
                       </div>
                       <div class="modal-footer justify-content-center">
                           <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                       </div>
                   </div>
               </div>
           </div>

           <script>
               // Check if there's an error message from the server
               const errorMessage = "<%= request.getAttribute("errorMessage") %>"; // Properly evaluate JSP expression
               if (errorMessage && errorMessage.trim() !== "" && errorMessage !== "null") {
                   // Update the modal message
                   document.getElementById("modalMessage").innerText = errorMessage;
               }

               // Show the modal when the page loads
               const messageModal = new bootstrap.Modal(document.getElementById('messageModal'));
               messageModal.show();

               // Function to validate the form
               function validateForm() {
                   const username = document.getElementById("username").value.trim();
                   const password = document.getElementById("password").value.trim();

                   if (username === "" || password === "") {
                       // Update the modal message
                       document.getElementById("modalMessage").innerText = "Username and password are required!";
                       // Show the modal
                       messageModal.show();
                       return false; // Prevent form submission
                   }
                   return true; // Allow form submission
               }
           </script>
    </body>

    </html>