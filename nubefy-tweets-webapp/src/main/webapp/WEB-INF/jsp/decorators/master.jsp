<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" href='<spring:url value="/css/main.css"/>' type="text/css" />
    <script src='<spring:url value="/javascript/jquery/jquery-1.7.min.js"/>' type="text/javascript"></script>
    <script src='<spring:url value="/javascript/jquery/jquery-ui-1.8.11.min.js"/>' type="text/javascript"></script>
    <script type="text/javascript">
    var contextPath = '<c:url value="/" />';  
    </script>
    <title><decorator:title default="Nubefy Assignment"/></title>
    <decorator:head/>
</head>
<body>

<div id="container">

    <div id="header">
      <h1>Nubefy Assignment</h1>
    </div>
    <div id="content">
        <decorator:body/>
    </div>

    <div id="footer">
    </div>
</div>


</body>
</html>