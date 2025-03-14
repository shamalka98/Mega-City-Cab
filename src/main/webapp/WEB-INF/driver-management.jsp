<%@ page import="java.util.List" %>
<%@ page import="com.megacitycab.model.Driver" %>

<html>
<head>
    <title>Driver Management</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4;">

    <h2 style="text-align: center; color: #333;">Driver Management</h2>

    <form method="post" style="max-width: 400px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <label style="font-weight: bold;">Driver ID:</label>
        <input type="text" name="driverId" style="width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">Name:</label>
        <input type="text" name="name" style="width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">License:</label>
        <input type="text" name="license" style="width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;"><br>

        <label style="font-weight: bold;">Assigned Vehicle:</label>
        <input type="text" name="assignedVehicle" style="width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;"><br>

        <button type="submit" style="width: 100%; background-color: #28a745; color: white; padding: 10px; border: none; border-radius: 4px; cursor: pointer;">
            Add Driver
        </button>
    </form>

    <h3 style="text-align: center; margin-top: 20px; color: #333;">Driver List</h3>

    <table style="width: 80%; margin: 0 auto; border-collapse: collapse; background: white; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <tr style="background: #007bff; color: white; text-align: left;">
            <th style="padding: 10px; border: 1px solid #ddd;">Driver ID</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Name</th>
            <th style="padding: 10px; border: 1px solid #ddd;">License</th>
            <th style="padding: 10px; border: 1px solid #ddd;">Assigned Vehicle</th>
        </tr>
        <% List<Driver> drivers = (List<Driver>) request.getAttribute("drivers"); %>
        <% if (drivers != null && !drivers.isEmpty()) { %>
            <% for (Driver driver : drivers) { %>
                <tr style="background: #f9f9f9; text-align: left;">
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= driver.getDriverId() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= driver.getName() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= driver.getLicense() %></td>
                    <td style="padding: 10px; border: 1px solid #ddd;"><%= driver.getAssignedVehicle() %></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="4" style="padding: 10px; text-align: center; color: red;">No drivers available</td>
            </tr>
        <% } %>
    </table>

</body>
</html>
