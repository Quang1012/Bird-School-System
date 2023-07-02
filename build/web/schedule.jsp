<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalTime, java.time.LocalDateTime" %>



<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script>document.getElementsByTagName("jsp")[0].className += " js";</script>
        <link rel="stylesheet" href="CSS/schedule.css">
        <title>Schedule</title>
    </head>
    <body>
        <header class="cd-main-header text-center flex flex-column flex-center">
            <h1 class="text-xl">Schedule Course</h1>
        </header>
        <section class="schedule">
            <table class="schedule-table">
                <tr class="schedule-table__title">
                    <th class="table-title__text">Bird Id</th>
                    <th class="table-title__text">Bird Name</th>
                    <th class="table-title__text">Coach Id</th>
                    <th class="table-title__text">Class Id</th>
                    <th class="table-title__text">Slot</th>
                    <th class="table-title__text">Date</th>
                </tr>
            </table>
            <c:forEach var="o" items="${schedules}">
                <tr class="schedule-table__content">
                    <td class="table-content__text">${o.birdId}</td>
                    <td class="table-content__text">${o.birdName}</td>
                    <td class="table-content__text">${o.coachId}</td>
                    <td class="table-content__text">${o.classId}</td>
                    <td class="table-content__text">
                        <p>${o.slot}</p>
                        <p>
                            <c:if test="${o.slot == 1}">7:00 - 8:30</c:if>
                            <c:if test="${o.slot == 2}">8:45 - 10:15</c:if>
                            <c:if test="${o.slot == 3}">10:30 - 12:00</c:if>
                            <c:if test="${o.slot == 4}">12:30 - 14:00</c:if>
                            <c:if test="${o.slot == 5}">14:15 - 15:45</c:if>
                            <c:if test="${o.slot == 6}">16:00 - 17:30</c:if>
                        </p>
                    </td>
                    <td class="table-content__text">01</td>
            </c:forEach>
        </section>

    </body>
</html>