<%@page import="model.entities.User"%>
<%@page import="model.petition.Entity"%>
<%
    User company = null;
    if(session.getAttribute(Entity.user.toString())!=null)
        company = (User)session.getAttribute(Entity.user.toString());
%>

<section class="col-lg-6 well">
    <form method="post" action="company.modify">
        <input name="userId" type="hidden" value="<%=company.getUserId()%>">
        <input name="username" type="hidden" value="<%=company.getUserName()%>">
        <input name="password" type="hidden" value="<%=company.getPassword()%>">
        <input name="userType" type="hidden" value="<%=company.getUserType()%>">
        <input name="email" type="hidden" value="<%=company.getEmail()%>">
        <div class="form-group">
            <label>Nombre ó Razón Social</label>
            <input name="name" type="text" class="form-control" value="<%=company==null?"":company.getName()%>"/>
        </div>
        <div class="form-group">
            <label>Teléfono</label>
            <input name="phone" type="text" class="form-control"  value="<%=company==null?"":company.getPhone()%>"/>
        </div>
        <div class="form-group">
            <label>Dirección</label>
            <input name="address" type="text" class="form-control" value="<%=company==null?"":company.getAddress()%>"/>
        </div>
        <div class="form-group">
            <label>Descripción</label>
            <input name="description" type="text" class="form-control" value="<%=company==null?"":company.getDescription()%>"/>
        </div>
        <div class="form-group">
            <label>Vacantes</label>
            <select class="form-control" multiple="true">
            </select>
            <br>
            <div class="btn btn-default btn-get-employment" class>agregar</div>
            <div class="btn btn-default" class>quitar</div>
        </div>
        <div class="form-group">
            <label>Contacto</label>
            <input name="contact" type="text" class="form-control" value="<%=company==null?"":company.getContact()%>"/>
        </div>
        <button class="btn btn-info pull-right">guardar</button>
    </form>
</section>
<section class="col-lg-4 col-lg-offset-1 well">
    <jsp:include page="/pages/profile/user.jsp"/>
</section>