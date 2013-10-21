<%@page import="model.entities.Company"%>
<%@page import="model.petition.Entity"%>
<%
    Company company = null;
    if(session.getAttribute(Entity.company.toString())!=null)
        company = (Company)session.getAttribute(Entity.company.toString());
%>

<section class="col-lg-6 well">
    <form method="post" action="company.modify">
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
            <div class="btn btn-default" class>agregar</div>
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