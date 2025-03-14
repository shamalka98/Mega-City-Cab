<%@ page import="java.util.List" %>
<%@ page import="com.megacitycab.model.Car" %>

<html>
<head>
    <title>Car Management</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4;">

    <h3 style="text-align: center; color: #333;">Car Management</h3>

    <form method="post" style="max-width: 400px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <label style="font-weight: bold;">Car ID:</label>
        <input type="text" name="carId" style="width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">Model:</label>
        <input type="text" name="model" style="width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">Available:</label>
        <input type="checkbox" name="availability" style="margin-bottom: 10px;"><br>

        <button type="submit" style="width: 100%; background-color: #28a745; color: white; padding: 10px; border: none; border-radius: 4px; cursor: pointer;">
            Add Car
        </button>
    </form>

    <!-- Help Button -->
    <button onclick="showHelp()" style="padding: 10px 20px; background-color: #ffc107; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; margin-top: 20px; display: block; margin-left: auto; margin-right: auto;">
        Help
    </button>

    <!-- Exit Button -->
    <form action="/login" method="get" style="text-align: center; margin-top: 20px;">
        <button type="submit" style="padding: 10px 20px; background-color: #dc3545; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer;">
            Exit
        </button>
    </form>

    <h3 style="text-align: center; margin-top: 20px; color: #333;">Car List</h3>

    <table style="width: 80%; margin: 0 auto; border-collapse: collapse; background: white; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <tr style="background: #007bff; color: white; text-align: left;">
            <th style="padding: 10px; border: 1px solid #ddd;">Car ID</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Model</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Availability</th>
        </tr>
        <% List<Car> cars = (List<Car>) request.getAttribute("cars"); %>
        <% if (cars != null && !cars.isEmpty()) { %>
            <% for (Car car : cars) { %>
                <tr style="background: #f9f9f9; text-align: left;">
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= car.getCarId() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= car.getModel() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;">
                        <% if (car.isAvailability()) { %>
                            <span style="color: green; font-weight: bold;">Available</span>
                        <% } else { %>
                            <span style="color: red; font-weight: bold;">Not Available</span>
                        <% } %>
                    </td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="3" style="padding: 10px; text-align: center; color: red;">No cars available</td>
            </tr>
        <% } %>
    </table>

    <form action="/driverManagement" method="get" style="text-align: center; margin-top: 20px;">
        <button type="submit" style="background-color: #007bff; color: white; padding: 10px; border: none; border-radius: 4px; cursor: pointer;">Go to Driver Management</button>
    </form>

    <!-- Help Popup Script -->
    <script type="text/javascript">
        function showHelp() {
            alert("Help: To manage cars, add car details such as Car ID, Model, and availability status.");
        }
    </script>

</body>
</html>
