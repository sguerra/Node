<%@page import="model.entities.UserType"%>
<%@page import="model.entities.User"%>
<%@page import="model.entities.Applicant"%>
<%@page import="model.petition.Entity"%>
<%
    User applicant = null;
    if(session.getAttribute(Entity.user.toString())!=null)
        applicant = (User)session.getAttribute(Entity.user.toString());
%>

<section class="col-lg-6 well">
    <form method="post" action="applicant.modify">
        <input name="userId" type="hidden" value="<%=applicant.getUserId()%>">
        <input name="username" type="hidden" value="<%=applicant.getUserName()%>">
        <input name="password" type="hidden" value="<%=applicant.getPassword()%>">
        <input name="userType" type="hidden" value="<%=applicant.getUserType()%>">
        <input name="email" type="hidden" value="<%=applicant.getEmail()%>">
        <div class="form-group">
            <label>Nombre</label>
            <input name="name" type="text" class="form-control" value="<%=applicant==null?"":applicant.getName()%>"/>
        </div>
        <div class="form-group">
            <label>Edad</label>
            <input name="age" type="text" class="form-control" value="<%=applicant==null?"":applicant.getAge()==0?"":applicant.getAge()%>"/>
        </div>
        <div class="form-group">
            <label>Teléfono</label>
            <input name="phone" type="text" class="form-control" value="<%=applicant==null?"":applicant.getPhone()%>"/>
        </div>
        <div class="form-group">
            <label>Dirección</label>
            <input name="address" type="text" class="form-control" value="<%=applicant==null?"":applicant.getAddress()%>"/>
        </div>
        <div class="form-group">
            <label>Profesión</label>
            <input name="description" type="text" class="form-control " value="<%=applicant==null?"":applicant.getDescription()%>"/>
        </div>
        <div class="form-group">
            <label>Habilidades</label>
            <select class="form-control" multiple="true">
            </select>
            <br>
            <div class="btn btn-default btn-get-skill" class>agregar</div>
            <div class="btn btn-default" class>quitar</div>
        </div>
        <div class="form-group">
            <label>Contacto</label>
            <input name="contact" type="text" class="form-control" value="<%=applicant==null?"":applicant.getContact()%>"/>
        </div>
        <div class="form-group">
            <label>CV</label>
            <br>
            <div class="btn btn-default" class>quitar</div>
            <div class="btn btn-default" class>ver</div>
            <div class="input-group">
                <input type="text" class="form-control">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button">agregar</button>
                </span>
              </div>
        </div>
        <button class="btn btn-info pull-right">guardar</button>
    </form>
</section>
<section class="col-lg-4 col-lg-offset-1 well">
    <jsp:include page="./user.jsp"/>
</section>