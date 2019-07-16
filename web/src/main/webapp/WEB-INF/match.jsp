<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:body>
        <h1>My Matches</h1>
        <div class="row">
            <div class="col-3 list">
                <c:forEach items="${list}" var="i">
                    <c:if test="${i.id==selected}">
                        <c:set var="user" value="${i}"></c:set>
                    </c:if>
                    <a class="li" href="?id=${i.id}">
                        <img src="/photo/${i.photo}.jpg">
                        <b>${i.name}</b>
                    </a>
                </c:forEach>
            </div>
            <div class="col-1">
                <div class="v-line"></div>
            </div>
            <div class="col-8">
                <c:if test="${user!=null}">
                    <div class="pf">
                        <img src="/photo/${user.photo}.jpg">
                        <div class="overlay">
                            <h5>${user.name}, ${user.age}</h5>
                            <p>${user.bio}</p>
                            <p>${user.contact}</p>
                        </div>
                    </div>
                </c:if>

            </div>
        </div>
    </jsp:body>
</t:master>