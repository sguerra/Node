<legend>Empresa</legend>
<section class="col-lg-6 well">
    <form>
        <div class="form-group">
            <label>Nombre ó Razón Social</label>
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
            <label>Descripción</label>
            <input type="text" class="form-control"/>
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
            <input type="text" class="form-control"/>
        </div>
        <button class="btn btn-info pull-right">guardar</button>
    </form>
</section>
<section class="col-lg-4 col-lg-offset-1 well">
    <jsp:include page="/pages/profile/user.jsp"/>
</section>