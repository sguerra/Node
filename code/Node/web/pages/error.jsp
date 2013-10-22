<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true"%>
<html>
<head>
    <jsp:include page="../include/startofpage.jsp"/>
</head>
<body class="body-error">

<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8 content-error">
            <div class="msg-error">
                <h1> Error :  <h2><i><%=exception!=null?exception.getMessage():""%> </i></h2></h1>
            </div>
        </div>
    </div>
</div>

</body>
</html>