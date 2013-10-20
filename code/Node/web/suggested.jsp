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
                        <th>sugerencia</th>
                        <th>nombre</th>
                        <th>tipo</th>
                        <th>email</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>mr usuario</td>
                        <td>aplicante</td>
                        <td>mruser@mail.com</td>
                        <td><div class="btn btn-default">ignorar</div>
                        <div class="btn btn-info">contactar</div></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>usuario co</td>
                        <td>compañia</td>
                        <td>company@mail.com</td>
                        <td><div class="btn btn-default">ignorar</div>
                        <div class="btn btn-info">aplicar</div></td>
                    </tr>
                </tbody>
            </table>
        </section>
    </body>
</html>
