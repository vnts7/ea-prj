<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<<<<<<< HEAD
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
=======
>>>>>>> 91d780a5d159e53a1779d1b905ac27134cbeee5f
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<<<<<<< HEAD
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Minder</title>
</head>

<body>
<h1>Hello</h1>
<form:form action ="upload" method = "post"
      enctype = "multipart/form-data">
    <input type = "file"  name="files" accept="image/x-png,image/gif,image/jpeg" multiple/>
    <input type="submit" value ="Submit">
</form:form>
</body>

</html>

    <jsp:body>
        <h1>Index page</h1>
    </jsp:body>

