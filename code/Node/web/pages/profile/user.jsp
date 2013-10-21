<%@page import="model.entities.UserType"%>
<%@page import="model.petition.Entity"%>
<%@page import="model.entities.User"%>
<%
    User user = ((User)session.getAttribute(Entity.user.toString()));
%>

<legend><%=user.getUserType()==UserType.applicant?"Aplicante":"Empresa"%></legend>

<form method="post" action="user.logout">
    <div class="form-group">
        <label>nombre de usuario</label>
        <p type="text" class="form-control-static"><%=user.getUserName()%></p>
    </div>
    <div class="form-group">
        <label>email</label>
        <p type="text" class="form-control-static"><%=user.getEmail()%></p>
    </div>
    <button class="btn btn-warning pull-left">cerrar sesión</button>
</form>
<form method="post" action="user.delete">
    <button class="btn btn-danger pull-right">cerrar cuenta</button>
</form>