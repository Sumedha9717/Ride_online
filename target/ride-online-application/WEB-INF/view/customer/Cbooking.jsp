<!DOCTYPE html>
<html lang="en">


<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<!-- Boxicons -->
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<!-- My CSS -->
	<link rel="stylesheet" href="assets/dashboard.css">
	<link rel="stylesheet" href="assets/booking.css">

	<title>Ride-IT</title>
</head>

<body>


<%@ include file="heder.jsp"%>



	<!-- CONTENT -->
	<section id="content">
                    <%
                    Integer Id = (Integer) session.getAttribute("userId");
                    String Username = (String) session.getAttribute("name");
                    String Email = (String) session.getAttribute("email");
                    String Mobile = (String) session.getAttribute("mobile");
                    String Nic = (String) session.getAttribute("nic");
                    String Address = (String) session.getAttribute("address");
                    String vehicleprice  = (String) session.getAttribute("vehicleprice");
                    String vehicleaddition = (String) session.getAttribute("vehicleaddition");
                    String vehicleestimate = (String) session.getAttribute("vehicleestimate");
                    String vehiclename = (String) session.getAttribute("vehiclename");

                    %>

		<!-- MAIN -->
		<main>
			<div class="head-title">
				<div class="left">
					<h1>Dashboard</h1>
					<ul class="breadcrumb">
						<li>
							<a href="#">Dashboard</a>
						</li>
						<li><i class='bx bx-chevron-right'></i></li>
						<li>
							<a class="active" href="#">Booking</a>
						</li>
					</ul>
				</div>

			</div>


		    <div class="table-data">
		        <div class="order">
		            <div class="head">
		                <form action="BookController?action=add " method="post">
		                    <div class="row ">
		                        
		                        <div class="col">
		                            <label>Name:</label>
		                            <input type="text" class="form-control" name="name" value="<%= Username != null ? Username : "" %>" placeholder="Enter  Name">
		                            
		                        </div>
		                        
		                        <div class="col">
		                            <label>Address:</label>
		                            <input type="text" class="form-control" name="address"  value="<%= Address != null ? Address : "" %>" placeholder="Enter Address">
		                            
		                        </div>

		                    </div>
		                    
                            <div class="row ">
                                
                                <div class="col">
                                    <label>Mobile number:</label>
                                    <input type="tell" class="form-control" name="mobile" value="<%= Mobile != null ? Mobile : "" %>" placeholder="Enter Mobile number">
                                    
                                </div>
                                
                                <div class="col">
                                    <label>Email Address:</label>
                                    <input type="email" class="form-control" name="email" value="<%= Email != null ? Email : "" %>" placeholder="Enter email address">
                                    
                                </div>

                            </div> 
                            
                            
                            <div class="row ">
                                
                                <div class="col">
                                    <label>Nic number:</label>
                                    <input type="text" class="form-control" name="nic" value="<%= Nic != null ? Nic : "" %>" placeholder="Enter nic number here">
                                    
                                </div>
                                
                                <div class="col">
                                    <label>vehicle type:</label>
                                    <input type="text" class="form-control" name="vehicle"  placeholder="Enter location here">
                                    
                                </div>

                            </div>
                            
                            <div class="row ">
                                
                                <div class="col">
                                    <label>Date:</label>
                                    <input type="date" class="form-control" name="date" placeholder="Enter time here">
                                    
                                </div>
                                
                                <div class="col">
                                    <label>Time:</label>
                                    <input type="time" class="form-control" name="time"  placeholder="Enter time here">
                                    
                                </div>

                            </div>
                            
                            <div class="row ">
                                
                                <div class="col">
                                    <label>Start Location:</label>
                                    <input type="text" class="form-control" name="startlocation" placeholder="Enter location here">
                                    
                                </div>
                                
                                <div class="col">
                                    <label>End  Location:</label>
                                    <input type="text" class="form-control" name="endlocation"  placeholder="Enter location here">
                                    
                                </div>

                            </div>
                                                       
						    <div class="container">
						        <div class="row">
						            <div class="col">
						                <button class="btn" type="submit">Book Now</button>
						            </div>
						        </div>
						    </div>

		                </form>
		            </div>
		        </div>
		    </div>
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->


	<script src="assets/dashboard.js"></script>
</body>

</html>