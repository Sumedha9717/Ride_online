<!DOCTYPE html>
<html lang="en">
        <%@ page import="java.util.List" %>
        <%@ page import="com.rideCompany.model.Vehicle" %>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<!-- Boxicons -->
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<!-- My CSS -->
	<link rel="stylesheet" href="assets/dashboard.css">
	<link rel="stylesheet" href="assets/vehicle.css">

	<title>Ride-IT</title>
</head>

<body>


<%@ include file="heder.jsp"%>



	<!-- CONTENT -->
	<section id="content">


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
							<a class="active" href="#">Vehicle</a>
						</li>
					</ul>
				</div>

			</div>
			
                  <%
                       List<Vehicle> vehicleList = (List<Vehicle>) request.getAttribute("VehicleController");
                       if (vehicleList != null && !vehicleList.isEmpty()) {
                           for (Vehicle vehicle : vehicleList) {
                  %>

			<div class="container">
			    <div class="table-data">
			        <div class="order">
			            <div class="head">
			                <div class="row">
			                    <h1><%= vehicle.getName() %></h1>
			                    <h3>RS:<%= vehicle.getPrice() %></h3>
			                     <h4><%= vehicle.getDestination() %>KM</h4>
			                </div>
			            </div>
			        </div>
			    </div>		    
			</div>
                        <%
                           }
                           } else {
                        %>
                          
                            
                           
                        <%
                            }
                        %>

		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->


	<script src="assets/dashboard.js"></script>
</body>

</html>