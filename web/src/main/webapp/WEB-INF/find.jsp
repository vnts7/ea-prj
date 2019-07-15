<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:body>
        <h1>Find page</h1>
        <div class="pf">
            <img src="/photo/123.jpg">
            <div class="overlay">
                <h2>${user.name}, ${user.dateOfBirth}</h2>
                <p>${user.bio}</p>
            </div>
            <div class="actions">
                
                <i class="fas fa-heart-broken text-danger"></i> <!-- uses solid style -->
                <i class="fas fa-heart text-success"></i> <!-- uses solid style -->
            </div>
        </div>
    </jsp:body>
</t:master>