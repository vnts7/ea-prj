
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:body>
        <h1>Notifications</h1>
        <div class="list-group">
            <c:forEach items="${list}" var="i">
                <a href="/match?id=${i.target.id}" class="list-group-item list-group-item-action">${i.content}</a>
            </c:forEach>
        </div>
    </jsp:body>
</t:master>

