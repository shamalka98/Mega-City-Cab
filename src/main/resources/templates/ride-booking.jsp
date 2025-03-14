<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ride Booking</title>
    <link rel="stylesheet" href="/static/ride-booking.css"> <!-- Updated the path to CSS file -->
</head>
<body>
    <h1>Book a Ride</h1>

    <form action="<c:url value='/book-ride'/>" method="post">
        <label for="pickup">Pickup Location:</label>
        <input type="text" id="pickup" name="pickup" required>

        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" required>

        <label for="time">Pickup Time:</label>
        <input type="time" id="time" name="time" required>

        <label for="driver">Select a Driver:</label>
        <select id="driver" name="driverId" required>
            <c:forEach var="driver" items="${drivers}">
                <option value="${driver.driverId}">${driver.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Book Ride</button>
    </form>
</body>
</html>
