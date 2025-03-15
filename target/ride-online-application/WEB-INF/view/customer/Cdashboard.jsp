<!DOCTYPE html>
<html lang="en">
        <%@ page import="java.util.List" %>
        <%@ page import="com.rideCompany.model.Book" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Boxicons -->
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <!-- My CSS -->
    <link rel="stylesheet" href="assets/dashboard.css">

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
                            <a class="active" href="#">Home</a>
                        </li>
                    </ul>
                </div>

            </div>


            <div class="table-data">
                <div class="order">
                    <div class="head">
                        <h3>Recent Orders</h3>

                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>book nu</th>
                                <th>vehicle</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Journey</th>
                                <th>Status</th>
                                <th>Action</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                  <%
                       List<Book> BookList = (List<Book>) request.getAttribute("LoginController");
                       if (BookList != null && !BookList.isEmpty()) {
                           for (Book book : BookList) {
                  %>
                            <tr>
                                <td><%= book.getId() %></td>
                                <td><%= book.getVehicle()%></td>
                                <td><%= book.getDate()%></td>
                                <td><%= book.getTime()%></td>
                                <td><%= book.getStartlocation()%> - <%= book.getEndlocation()%></td>
                                <td><%= book.getStatus()%></td>
                                <td><a href="BookController?action=cancel&cid=<%= book.getId() %>" class="btn btn-danger">cancel</a></td>
                            </tr>

                        </tbody>
                        <%
                           }
                           } else {
                        %>
                            <tr>
                            <td colspan="6" style="text-align:center;">No Book  display.</td>
                            </tr>
                        <%
                            }
                        %>
                    </table>
                </div>

            </div>
        </main>
        <!-- MAIN -->
    </section>
    <!-- CONTENT -->


    <script src="assets/dashboard.js"></script>
</body>

</html>