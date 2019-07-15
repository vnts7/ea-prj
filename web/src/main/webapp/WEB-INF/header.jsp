<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="stylesheet" type="text/css" href="/res/bootstrap.min.css"/>
<script src="/res/jquery-3.3.1.slim.min.js"></script>
<script src="/res/popper.min.js"></script>
<script src="/res/bootstrap.min.js"></script>
<%--<div class="container">--%>
    <nav class="navbar navbar-dark bg-dark navbar-expand m-navbar">
        <a class="navbar-brand" href="/"><span class="logo">M</span>inder</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/find">Find</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/match">My Matches</a>
                </li>

            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello <sec:authentication property="name"/></a>
                </li>
                <li class="nav-item">

                    <a class="nav-link" href="/logout">[Logout]</a>
                </li>
            </ul>
        </div>
    </nav>
<%--</div>--%>
<style>
    .m-navbar{
        background-color: #9c27b0 !important;
    }
    .logo{
        color:#ff9500;
        font-size: 1.5em;
    }
    .navbar-brand{
        padding-top: 0;
        line-height: .9;
    }
    .navbar-dark .navbar-nav .nav-link {
        color: rgba(255,255,255,.8);
    }
</style>