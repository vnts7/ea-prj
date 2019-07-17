<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:master>
    <jsp:body>
        <div class="box">
            <form:form method="POST" modelAttribute="userModel" class="/registration" enctype="multipart/form-data">
                <h2 class="form-signin-heading">Create your account</h2>
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username" class="form-control" placeholder="User Login name"
                                    autofocus="true"></form:input>
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="name" class="form-control" placeholder="Name"
                                    autofocus="false"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control"
                                    placeholder="Password"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="passwordConfirm" class="form-control"
                                    placeholder="Confirm your password"></form:input>
                        <form:errors path="passwordConfirm"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="dateOfBirth">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="dateOfBirth" class="form-control"
                                    placeholder="Date of Birth (dd/mm/yyyy)"
                                    autofocus="false"></form:input>
                        <form:errors path="dateOfBirth"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="gender">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:radiobutton path="gender" value="0" label="Male"/>
                        <form:radiobutton path="gender" value="1" label="Female"/>
                    </div>
                </spring:bind>

                <spring:bind path="photo">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="custom-file">
                            <form:input type="file" path="photo" accept="image/x-png,image/gif,image/jpeg"
                                        multiple="multiple" cssClass="custom-file-input"></form:input>
                            <label class="custom-file-label" for="">Choose file</label>
                        </div>


                        <form:errors path="photo"></form:errors>
                    </div>
                </spring:bind>

                <button class="btn btn-primary">Submit</button>
            </form:form>
        </div>


    </jsp:body>
</t:master>