<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalTime, java.time.LocalDateTime" %>



<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script>document.getElementsByTagName("html")[0].className += " js";</script>
        <link rel="stylesheet" href="CSS/style.css">
        <title>Schedule Template | CodyHouse</title>
    </head>
    <body>
        <header class="cd-main-header text-center flex flex-column flex-center">

            <h1 class="text-xl">Schedule Course</h1>
            
        </header>

        <div class="cd-schedule cd-schedule--loading margin-top-lg margin-bottom-lg js-cd-schedule">
            <div class="cd-schedule__timeline">
                <ul>
                    <li><span>09:00</span></li>
                    <li><span>09:15</span></li>
                    <li><span>Slot 1</span></li>
                    <li><span>09:45</span></li>
                    <li><span>10:00</span></li>
                    <li><span>Slot 2</span></li>
                    <li><span>10:30 </span></li>
                    <li><span>10:45</span></li>
                    <li><span>Slot 3</span></li>
                    <li><span>11:15</span></li>
                    <li><span>11:30</span></li>
                    <li><span>11:45</span></li>
                    <li><span>Slot 4</span></li>
                    <li><span>12:15</span></li>
                    <li><span>12:30</span></li>


                </ul>
            </div> <!-- .cd-schedule__timeline -->

            <div class="cd-schedule__events" >

                <ul>



                    <!--          <ul>
                                <li class="cd-schedule__event">
                                  <a data-start="09:30" data-end="10:30" data-content="event-abs-circuit" data-event="event-1" href="#0">
                                    <em class="cd-schedule__name">Abs Circuit</em>
                                  </a>
                                </li>
                      
                                <li class="cd-schedule__event">
                                  <a data-start="11:00" data-end="12:30" data-content="event-rowing-workout" data-event="event-2" href="#0">
                                    <em class="cd-schedule__name">Rowing Workout</em>
                                  </a>
                                </li>
                      
                                <li class="cd-schedule__event">
                                  <a data-start="14:00" data-end="15:15"  data-content="event-yoga-1" data-event="event-3" href="#0">
                                    <em class="cd-schedule__name">Yoga Level 1</em>
                                  </a>
                                </li>
                              </ul>-->

                    <c:forEach var="schedule" items="${schedules}">
                            
                        <li class="cd-schedule__group" >
                            <div class="cd-schedule__top-info"><span>${schedule.date}</span></div>
                            <ul> 

                                <c:if test="${schedule.slot == 1}">
                                    <li class="cd-schedule__event">

                                        <a data-start="09:30" data-end="10:30" data-content="event-abs-circuit" data-event="event-1" href="#0">
                                            <em class="cd-schedule__name">Slot : ${schedule.slot} - BirdID : ${schedule.birdId}</em>


                                            <em class="cd-schedule__name">
                                                <c:if test="${not empty schedule.coachName}">
                                                    <%-- Hiển thị tên huấn luyện viên --%>
                                                 Coach:   ${schedule.coachName}
                                                </c:if>
                                                <%-- Nếu không có tên huấn luyện viên --%>
                                                <c:if test="${empty schedule.coachName}">
                                                    No coach
                                                </c:if>
                                            </em>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${schedule.slot == 2}">
                                    <li class="cd-schedule__event">
                                        <a data-start="10:45" data-end="11:45" data-content="event-rowing-workout" data-event="event-2" href="#0">
                                            <em class="cd-schedule__name">Slot : ${schedule.slot} - BirdID : ${schedule.birdId}</em>

                                            <em class="cd-schedule__name">
                                                <c:if test="${not empty schedule.coachName}">
                                                    <%-- Hiển thị tên huấn luyện viên --%>
                                                    Coach: ${schedule.coachName}
                                                </c:if>
                                                <%-- Nếu không có tên huấn luyện viên --%>
                                                <c:if test="${empty schedule.coachName}">
                                                    No coach
                                                </c:if>
                                            </em>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${schedule.slot == 3}">
                                    <li class="cd-schedule__event">
                                        <a data-start="12:00" data-end="13:00"  data-content="event-yoga-1" data-event="event-3" href="#0">
                                            <em class="cd-schedule__name">Slot : ${schedule.slot} - BirdID : ${schedule.birdId}</em>


                                            <em class="cd-schedule__name">
                                                <c:if test="${not empty schedule.coachName}">
                                                    <%-- Hiển thị tên huấn luyện viên --%>
                                                    Coach    ${schedule.coachName}
                                                </c:if>
                                                <%-- Nếu không có tên huấn luyện viên --%>
                                                <c:if test="${empty schedule.coachName}">
                                                    No coach
                                                </c:if>
                                            </em>
                                        </a>
                                    </li>
                                </c:if>
                            </ul> 

                        </c:forEach>

                    </li>
                </ul>
            </div>

            <div class="cd-schedule-modal">
                <header class="cd-schedule-modal__header">
                    <div class="cd-schedule-modal__content">
                        <span class="cd-schedule-modal__date"></span>
                        <h3 class="cd-schedule-modal__name"></h3>
                    </div>

                    <div class="cd-schedule-modal__header-bg"></div>
                </header>

                <div class="cd-schedule-modal__body">
                    <div class="cd-schedule-modal__event-info">
                        
                    </div>
                    <div class="cd-schedule-modal__body-bg"></div>
                </div>

                <a href="#0" class="cd-schedule-modal__close text-replace">Close</a>
            </div>

            <div class="cd-schedule__cover-layer"></div>
        </div> <!-- .cd-schedule -->

        <script src="js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
        <script src="js/main.js"></script>
    </body>
</html>