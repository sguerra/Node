<legend>Registrarse</legend>
<form action="user.add" method="post">
    <div class="form-group">
        <label>nombre de usuario</label>
        <input name="username" type="text" class="form-control"/>
    </div>
    <div class="form-group">
        <label>tipo de usuario</label>
        <select name="userType" class="form-control">
            <option value="1">aplicante</option>
            <option value="2">empresa</option>
        </select>
    </div>
    <div class="form-group">
        <label>correo</label>
        <input name="email" type="text" class="form-control"/>
    </div>
    <div class="form-group">
        <label>contraseña</label>
        <input name="password" type="password" class="form-control"/>
        <label>repetir contraseña</label>
        <input type="password" class="form-control"/>
    </div>
    <a class="btn btn-link pull-left" href="./?">iniciar sesión</a>
    <button type="submit" class="btn btn-info pull-right">registrar</button>

</form>