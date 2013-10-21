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
                <tbody>
                    <tr>
                        <td>mr usuario</td>
                        <td>aplicante</td>
                        <td>mruser@mail.com</td>
                        <td><div class="btn btn-danger">borrar</div></td>
                    </tr>
                    <tr>
                        <td>usuario co</td>
                        <td>compañia</td>
                        <td>company@mail.com</td>
                        <td><div class="btn btn-danger">borrar</div></td>
                    </tr>
                </tbody>
            </table>
        </section>
    </body>
</html>
