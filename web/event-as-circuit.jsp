
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div  class="cd-schedule-modal__event-info" >
    <div>

        <c:forEach var="bird" items="${birdList}">


            <c:if test="${bird.getClassID() == 1}">

                <div>

                    <li> CoureID : ${bird.getCourseID()}</li>
                    <li> ClassID :${bird.getClassID()}</li>
                    <li> TypeeofClass  :${bird.getTypeofclass()}</li>
                    <li> Address  : ${bird.getAddress()}</li>
                </div>

            </c:if>

        </c:forEach>   
    </div>
</div>
