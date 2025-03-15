<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
    <title>Ride_IT</title>
</head>
<body>
    <header>
        <h1>Ride_IT</h1>

        <section class="menu">
            <ul class="menu-list">
                <li class="active">Home</li>
                <li>Cars</li>
                <li>About Us</li>
                <li>Contact</li>
            </ul>

            <button>
                <i class="fas fa-times"></i>
                <i class="fas fa-bars"></i>
            </button>
        </section>
    </header>

    <section class="main">
        <section class="left">
            <p class="title">RIDE-IT - Easy and Fast</p>
            <p class="msg">Book your ride with ease! Our car booking platform offers a seamless experience to find, compare, and reserve vehicles at the best rates. Whether you need a quick city ride or a long-distance journey, we’ve got you covered. Choose your car, select your date, and hit the road hassle-free!</p>
            <a href="LoginController?action=login"><button class="cta">Get Started</button></a>
        </section>

        <section class="right">
            <img src="./images/home.svg" alt="Langing image">
        </section>

    </section>

    <script>
        var menu = document.querySelector('.menu');
        var menuBtn = document.querySelector('.menu button');
        menuBtn.addEventListener('click', () => {
            menu.classList.toggle('opened')
        })
    </script>
</body>
</html>