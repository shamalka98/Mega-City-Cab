<%@ page import="java.util.List" %>
<%@ page import="com.megacitycab.model.Car" %>

<html>
<body>
    <h3>Car Management</h3>
    <form method="post">
        Car ID: <input type="text" name="carId"><br>
        Model: <input type="text" name="model"><br>
        Available: <input type="checkbox" name="availability"><br>
        <button type="submit">Add Car</button>
    </form>

    <h3>Car List</h3>
    <table border="1">
        <tr>
            <th>Car ID</th>
            <th>Model</th>
            <th>Availability</th>
        </tr>
        <% List<Car> cars = (List<Car>) request.getAttribute("cars"); %>
        <% for (Car car : cars) { %>
        <tr>
            <td><%= car.getCarId() %></td>
            <td><%= car.getModel() %></td>
            <td><%= car.isAvailability() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
