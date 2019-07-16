<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:body>
        <c:if test="${user!=null}">
            <div class="pf">
                <img src="/photo/${user.photo}.jpg">
                <div class="overlay">
                    <h5>${user.name}, ${user.age}</h5>
                    <p>${user.bio}</p>
                </div>
                <div class="actions">
                    <form method="post">
                        <input type="hidden" name="action" value="1" id="hdAction"/>
                        <input type="hidden" name="likee" value="${user.id}"/>
                        <button type="submit" onmousedown="beforeSubmit(0)"><i
                                class="fas fa-heart-broken text-danger"></i>
                        </button>
                        <button type="submit" onmousedown="beforeSubmit(1)"><i class="fas fa-heart text-success"></i>
                        </button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <script>
                        function beforeSubmit(action) {
                            $("#hdAction").val(action);
                        }
                    </script>
                    <!-- uses solid style -->
                </div>
            </div>
        </c:if>

        <c:if test="${m_user!=null}">
            <div class="modal fade" id="matchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">It's a Match</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="match">
                                <img src="/photo/${auth.photo}.jpg">
                                <img src="/photo/${m_user.photo}.jpg">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Continue Finding
                            </button>
                            <a class="btn btn-primary" href="/match?id=${match}">Go & See</a>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                $('#matchModal').modal('show');
            </script>
        </c:if>
    </jsp:body>
</t:master>