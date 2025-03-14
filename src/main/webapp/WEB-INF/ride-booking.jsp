<%@ page import="java.util.List" %>
<%@ page import="com.megacitycab.model.Ride" %>

<html>
<head>
    <title>Ride Booking</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4;">

    <h1 style="text-align: center; color: #333;">Book a Ride</h1>

    <form method="post" style="max-width: 400px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <label style="font-weight: bold;">Pickup Location:</label>
        <input type="text" name="pickup" style="width: 100%; padding: 8px; margin-bottom: 10px;
                border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">Destination:</label>
        <input type="text" name="destination" style="width: 100%; padding: 8px; margin-bottom: 10px;
                border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">Pickup Time:</label>
        <input type="time" name="time" style="width: 100%; padding: 8px; margin-bottom: 10px;
                border: 1px solid #ccc; border-radius: 4px;"><br>

        <button type="submit" style="width: 100%; background-color: #28a745; color: white; padding: 10px;
                border: none; border-radius: 4px; cursor: pointer;">
            Book Ride
        </button>
    </form>

    <h3 style="text-align: center; margin-top: 20px; color: #333;">Car List</h3>

    <table style="width: 80%; margin: 0 auto; border-collapse: collapse; background: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <tr style="background: #007bff; color: white; text-align: left;">
            <th style="padding: 10px; border: 1px solid #ddd;">Pickup Location</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Destination</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Time</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Driver</th>
        </tr>
        <% List<Ride> rideList = (List<Ride>) request.getAttribute("rides"); %>
        <% if (rideList != null && !rideList.isEmpty()) { %>
            <% for (Ride ride : rideList) { %>
                <tr style="background: #f9f9f9; text-align: left;">
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= ride.getPickupLocation() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= ride.getDestination() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= ride.getTime() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= ride.getDriver() %></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="4" style="padding: 10px; text-align: center; color: red;">No rides available</td>
            </tr>
        <% } %>
    </table>

</body>
</html>
