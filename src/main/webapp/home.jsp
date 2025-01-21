<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.Model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Information</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        /* Header Styles */
        header {
            background-color: #007bff;
            color: white;
            padding: 20px 0;
            margin-bottom: 30px;
        }

        header h1 {
            margin: 0;
            font-size: 30px;
        }

        /* Button to Add Student */
        .add-student-container {
            margin-bottom: 30px;
        }

        .add-student-btn {
            background-color: #28a745;
            color: white;
            padding: 14px 28px;
            font-size: 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .add-student-btn:hover {
            background-color: #218838;
        }

        /* Main Container for Cards */
        .container {
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 0 15px;
        }

        /* Card Styles */
        .card {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 30%;
            padding: 20px;
            box-sizing: border-box;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        }

        .card h3 {
            font-size: 24px;
            color: #333;
            margin-bottom: 15px;
        }

        .card p {
            font-size: 16px;
            color: #555;
            margin: 8px 0;
        }

        .card .actions {
            margin-top: 20px;
        }

        .card button {
            padding: 12px 25px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
            transition: background-color 0.3s ease;
        }

        .card button:hover {
            background-color: #0056b3;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .card {
                width: 45%;
            }
        }

        @media (max-width: 480px) {
            .card {
                width: 100%;
            }
        }
    </style>
</head>
<body>

    <!-- Header Section -->
    <header>
        <h1>Student Information</h1>
    </header>

    <!-- Add Student Button -->
    <div class="add-student-container">
        <a href="addStudent.jsp" class="add-student-btn">Add New Student</a>
    </div>

    <!-- Display Students -->
    <div class="container">
        <%-- Fetch student list from session --%>
        <%
            ArrayList<Student> slist = (ArrayList<Student>) session.getAttribute("studentlist");
            if (slist != null && !slist.isEmpty()) {
                for (Student stu : slist) {
        %>

        <div class="card">
            <h3><%= stu.getName() %></h3>
            <p><strong>ID:</strong> <%= stu.getId() %></p>
            <p><strong>Email:</strong> <%= stu.getEmail() %></p>
            <p><strong>Mobile:</strong> <%= stu.getMobile() %></p>
            <p><strong>Address:</strong> <%= stu.getAddress() %></p>
            <div class="actions">
                <a href="FetchOne?id=<%= stu.getId() %>"><button>Edit</button></a>
                <a href="Delete?sid=<%= stu.getId()%>"><button>Delete</button></a>
            </div>
        </div>

        <%  
            }
        } else {
        %>
            <p>No student information available. <br> Please add some students.</p>
        <%  
        }
        %>
    </div>

</body>
</html>
