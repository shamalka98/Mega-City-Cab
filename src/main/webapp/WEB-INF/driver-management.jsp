<%@ page import="java.util.List" %>
<%@ page import="com.megacitycab.model.Driver" %>

<html>
<body>
    <h3>Driver Management</h3>
    <form method="post">
        Driver ID: <input type="text" name="driverId"><br>
        Name: <input type="text" name="name"><br>
        License: <input type="text" name="license"><br>
        Assigned Vehicle: <input type="text" name="assignedVehicle"><br>
        <button type="submit">Add Driver</button>
    </form>

    <h3>Driver List</h3>
    <table border="1">
        <tr>
            <th>Driver ID</th>
            <th>Name</th>
            <th>License</th>
            <th>Assigned Vehicle</th>
        </tr>
        <% List<Driver> drivers = (List<Driver>) request.getAttribute("drivers"); %>
        <% for (Driver driver : drivers) { %>
        <tr>
            <td><%= driver.getDriverId() %></td>
            <td><%= driver.getName() %></td>
            <td><%= driver.getLicense() %></td>
            <td><%= driver.getAssignedVehicle() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
