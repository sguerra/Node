<%@page import="java.util.List"%>
<%@page import="model.entities.User"%>
<%@page import="model.entities.UserType"%>
<%@page import="model.response.ResponseObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/include/startofpage.jsp"/>
    </head>
    <body>
        <jsp:include page="/include/topbar.jsp"/>
        <section class="col-lg-10 col-lg-offset-1 well">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>nombre</th>
                        <th>tipo</th>
                        <th>email</th>
                    </tr>
                </thead>
                <%
                    List<User> users = (List<User>)session.getAttribute(ResponseObject.users.toString());
                %>
                <tbody>
                    <%for(User user : users){%>
                    <tr>
                        <td><%=user.getUserName()%></td>
                        <td><%=user.getUserType()==UserType.applicant?"Aplicante":user.getUserType()==UserType.company?"Empresa":"Admin"%></td>
                        <td><%=user.getEmail()%></td>
                        <td><div class="btn btn-danger">borrar</div></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </section>
    </body>
</html>
