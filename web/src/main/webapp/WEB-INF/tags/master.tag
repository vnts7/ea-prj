<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Minder</title>
    <link rel="stylesheet" type="text/css" href="/res/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/res/css/fa-all.css"/>
    <link rel="stylesheet" type="text/css" href="/res/style.css"/>
</head>
<body>

<div id="pageheader">
    <jsp:invoke fragment="header"/>
</div>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <jsp:doBody/>
</div>


<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>