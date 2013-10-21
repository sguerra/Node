<%@page import="model.petition.Entity"%>
<%@page import="model.entities.UserType"%>
<%@page import="model.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="./pages/error.jsp" %>

<!DOCTYPE html>
<%
    User user = ((User)session.getAttribute(Entity.user.toString()));
%>
<html>
    <head>
        <jsp:include page="/include/startofpage.jsp"/>
    </head>
    <body>
        <jsp:include page="/include/topbar.jsp"/>
        <section class="col-lg-10 col-lg-offset-1 well">
            <legend>Perfil</legend>
            <%if(user.getUserType()==UserType.company){%>
                <jsp:include page="/pages/profile/company.jsp"/>
            <%}else{%>
                <jsp:include page="/pages/profile/applicant.jsp"/>
            <%}%>
        </section>
    </body>
</html>
