<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:body>

        <div class="pf">
            <img src="/photo/${user.photo}.jpg">
            <div class="overlay">
                <h5>${user.name}, ${user.age}</h5>
                <p>${user.bio}</p>
            </div>
            <div class="actions">
                <form method="post">
                   <input type="hidden" name="action" value="1" id="hdAction"/>
                    <button type="submit" onmousedown="beforeSubmit(0)"><i class="fas fa-heart-broken text-danger"></i></button>
                    <button type="submit" onmousedown="beforeSubmit(1)"><i class="fas fa-heart text-success"></i></button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <script>
                    function beforeSubmit(action){
                        $("#hdAction").val(action);
                    }
                </script>
                 <!-- uses solid style -->
            </div>
        </div>
    </jsp:body>
</t:master>