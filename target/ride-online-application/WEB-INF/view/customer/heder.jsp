<%@ page import="java.util.List" %>
<%@ page import="com.rideCompany.model.Header" %>
<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand">
			<i class='bx bxs-smile'></i>
			<span class="text">Ride_IT-Customer</span>
		</a>
		<ul class="side-menu top">
			<li class="active">
				<a href="LoginController?action=dashboard">
					<i class='bx bxs-dashboard'></i>
					<span class="text">Dashboard</span>
				</a>
			</li>
			<li>
            	<a href="LoginController?action=booking">
            		<i class='bx bxs-shopping-bag-alt'></i>
            		<span class="text">Booking</span>
            	</a>
            </li>
			<li>
				<a href="LoginController?action=vehicle">
					<i class='bx bxs-shopping-bag-alt'></i>
					<span class="text">Vehicles</span>
				</a>
			</li>


			<li>
				<a href="#">
					<i class='bx bxs-group'></i>
					<span class="text">Drivers</span>
				</a>
			</li>
		</ul>
                <%
                    String userName = (String) session.getAttribute("name");
                    Integer userId = (Integer) session.getAttribute("userId");


                %>
		<ul class="side-menu">
			<li>
				<a href="#">
					<i class='bx bxs-contact'></i>
					<span class="text"><%= userName %></span>
				</a>
			</li>
			<li>
				<a href="Login?action=logout" class="logout">
					<i class='bx bxs-log-out-circle'></i>
					<span class="text">Logout</span>
				</a>
			</li>
		</ul>
	</section>
	<!-- SIDEBAR -->