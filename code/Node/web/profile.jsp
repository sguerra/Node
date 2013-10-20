<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/include/startofpage.jsp"/>
    </head>
    <body>
        <jsp:include page="/include/topbar.jsp"/>
        <section class="col-lg-10 col-lg-offset-1 well">
            <%if(request.getParameter("company")!=null){%>
            <a href="?">aplicante</a>
            <jsp:include page="/pages/profile/company.jsp"/>
            <%}else{%>
            <a href="?company">empresa</a>
            <jsp:include page="/pages/profile/applicant.jsp"/>
            <%}%>
        </section>
    </body>
</html>
