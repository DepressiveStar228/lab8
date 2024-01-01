<%-- 
    Document   : student
    Created on : 13 окт. 2023 г., 20:30:03
    Author     : artem
--%>

<%@page import="java.util.*"%>
<%@page import="sumdu.edu.ua.mavenproject2.model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
    </head>
    <body>
        <h1><%= (new java.util.Date()).toLocaleString()%></h1>
        <p><<a href="http://localhost:8080/logout">Log out</a>></p>
        
        <sec:authorize access="hasAutority('ADMIN')">
            <h3><a href="http://localhost:8080/registration">To sign-up new user </a></h3>
            <form method="post" action="StudentAdd">
                <table>
                <tbody>
                    <tr>
                        <td><label for="name">Name</td>
                        <td><input id="name" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><label for="surname">Surname</td>
                        <td><input id="surname" type="text" name="surname"></td>
                    </tr>
                    <tr>
                        <td><label for="age">Age</td>
                        <td><input id="age" type="text" name="age"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</td>
                        <td><input id="email" type="email" name="email"></td>
                    </tr>
                    <tr>
                        <td><label for="group">Group</td>
                        <td><input id="group" type="text" name="group"></td>
                    </tr>
                    <tr>
                        <td><label for="faculty">Faculty</td>
                        <td><input id="faculty" type="text" name="faculty"></td>
                    </tr>
                </tbody>
                </table>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" name="send" value="Відправити">
            </form>
        </sec:authorize>
        
            <sec:authorize access="isAuthenticated()"></sec:authorize>
            
            <sec:authentication property="principal.username" var="username" />
            <p>Welcome, <c:out value="${username}" />!</p>
            <c:if test="${students.size() > 0}">
                <table class="list">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Group</th>
                        <th>Faculty</th>
                        <th>Ref</th>
                    </tr>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td><c:out value="${student.getId()}"/></td>
                            <td><c:out value="${student.getName()}"/></td>
                            <td><c:out value="${student.getSurname()}"/></td>
                            <td><c:out value="${student.getAge()}"/></td>
                            <td><c:out value="${student.getEmail()}"/></td>
                            <td><c:out value="${student.getGroup()}"/></td>
                            <td><c:out value="${student.getFaculty()}"/></td>
                            <td>
                                <a href="UserContent?id2=${student.getId()}">Marks</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>                     
    </body>
</html>
