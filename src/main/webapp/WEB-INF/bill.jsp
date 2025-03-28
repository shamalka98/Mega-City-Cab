<%@ page import="java.text.DecimalFormat" %>
<html>
<head>
    <title>Bill</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4;">

    <h1 style="text-align: center; color: #333;">Ride Bill</h1>

    <div style="text-align: center; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <h2 style="color: #333;">Thank you for booking with us!</h2>
        <p style="font-size: 20px; font-weight: bold; color: #28a745;">
            Total Amount: $<%= new DecimalFormat("#.00").format(request.getAttribute("totalAmount")) %>
        </p>

        <!-- Button to go back to the ride booking page -->
        <form action="/ride-booking" method="get">
            <button type="submit" style="padding: 10px 20px; font-size: 16px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">
                Go Back to Ride Booking
            </button>
        </form>

        <!-- Help Button -->
        <button onclick="showHelp()" style="padding: 10px 20px; background-color: #ffc107; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; margin-top: 20px;">
            Help
        </button>

        <form action="/login" method="get">
                    <button type="submit" style="padding: 10px 20px; background-color: #dc3545; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; margin-top: 20px;">
                        Exit
                    </button>
    </div>

    <!-- Help Popup Script -->
    <script type="text/javascript">
        function showHelp() {
            alert("Help: To book a ride, fill out the form with pickup location, destination, and time.");
        }
    </script>

</body>
</html>
