<%@page import="model.entities.UserType"%>
<%@page import="model.petition.Entity"%>
<%@page import="model.entities.User"%>
<%
    User user = ((User)session.getAttribute(Entity.user.toString()));
%>

<legend><%=user.getUserType()==UserType.applicant?"Aplicante":user.getUserType()==UserType.company?"Empresa":user.getUserType()==UserType.admin?"Admin":"Usuario"%></legend>

<form method="post" action="user.logout">
    <input type="hidden" name="userId" value="<%=user.getUserId()%>"/>
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
    <input type="hidden" name="userId" value="<%=user.getUserId()%>"/>
    <button class="btn btn-danger pull-right">cerrar cuenta</button>
</form>