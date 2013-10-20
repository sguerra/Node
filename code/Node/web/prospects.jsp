<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/include/startofpage.jsp"/>
    </head>
    <body>
        <jsp:include page="/include/topbar.jsp"/>
        <section class="col-lg-5 col-lg-offset-1 well">
            <legend>prospectos</legend>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>nombre</th>
                        <th>tipo</th>
                        <th>email</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>mr usuario</td>
                        <td>aplicante</td>
                        <td>mruser@mail.com</td>
                        <td><div class="btn btn-default">ignorar</div>
                        <div class="btn btn-info">aplicar</div></td>
                    </tr>
                    <tr>
                        <td>usuario co</td>
                        <td>compañia</td>
                        <td>company@mail.com</td>
                        <td><div class="btn btn-default">ignorar</div>
                        <div class="btn btn-info">aplicar</div></td>
                    </tr>
                </tbody>
            </table>
        </section>
        <section class="col-lg-4 col-lg-offset-1 well">
            <legend>aplicados</legend>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>nombre</th>
                        <th>tipo</th>
                        <th>email</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>mr usuario</td>
                        <td>aplicante</td>
                        <td>mruser@mail.com</td>
                        <td><div class="btn btn-default">ignorar</div>
                    </tr>
                    <tr>
                        <td>usuario co</td>
                        <td>compañia</td>
                        <td>company@mail.com</td>
                        <td><div class="btn btn-default">ignorar</div>
                    </tr>
                </tbody>
            </table>
        </section>
    </body>
</html>
