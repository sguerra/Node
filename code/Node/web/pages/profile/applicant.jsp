<%@page import="model.entities.Applicant"%>
<%@page import="model.petition.Entity"%>
<%
    Applicant applicant = null;
    if(session.getAttribute(Entity.applicant.toString())!=null)
        applicant = (Applicant)session.getAttribute(Entity.applicant.toString());
%>

<section class="col-lg-6 well">
    <form method="post" action="applicant.modify">
        <div class="form-group">
            <label>Nombre</label>
            <input name="name" type="text" class="form-control" value="<%=applicant==null?"":applicant.getName()%>"/>
        </div>
        <div class="form-group">
            <label>Edad</label>
            <input type="text" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Teléfono</label>
            <input type="text" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Dirección</label>
            <input type="text" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Profesión</label>
            <input type="text" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Habilidades</label>
            <select class="form-control" multiple="true">
            </select>
            <br>
            <div class="btn btn-default" class>agregar</div>
            <div class="btn btn-default" class>quitar</div>
        </div>
        <div class="form-group">
            <label>Contacto</label>
            <input type="text" class="form-control"/>
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