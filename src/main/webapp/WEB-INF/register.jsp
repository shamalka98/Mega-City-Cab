<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            background-color: #28a745;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        p {
            margin-top: 10px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        div[style="color: red; font-weight: bold;"] {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h2>User Registration</h2>

    <%-- Display error messages if any --%>
    <% if (request.getAttribute("error") != null) { %>
        <div style="color: red; font-weight: bold;">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <form action="register" method="post">
        <label>Registration Number:</label>
        <input type="text" name="regNo" required><br><br>

        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="text" name="password" required><br><br>

        <label>Name:</label>
        <input type="text" name="name" required><br><br>

        <label>Address:</label>
        <input type="text" name="address" required><br><br>

        <label>Phone Number:</label>
        <input type="text" name="phone" required><br><br>

        <label>NIC:</label>
        <input type="text" name="nic" required><br><br>

        <button type="submit">Register</button>
    </form>

    <p>Already have an account? <a href="login">Login here</a></p>
</body>
</html>
