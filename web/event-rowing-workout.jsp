
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div  class="cd-schedule-modal__event-info" >
    <div>

        <c:forEach var="bird" items="${birdList}">

            <div>
                <img style="width: 350px" src="${bird.birdPhoto}">
                <li>Name : ${bird.getBirdName()}</li>
                <li> Weight :${bird.getWeight()}</li>
                <li> Height :${bird.getHeight()}</li>
                <li> Color  :${bird.getColor()}</li>
              
            </div>


        </c:forEach>   

    </div>
</div>
