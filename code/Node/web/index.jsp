<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/include/startofpage.jsp"/>
    </head>
    <body>
        <jsp:include page="/include/topbar.jsp"/>
          
        <section class="col-lg-5 col-lg-offset-1 well">
            <h1>Node es la puerta de acceso al mercado de trabajo en internet</h1>
            <br>
            <h2>¡Encuentre trabajo ya!</h2>
            <br>
            <h3>Consulte nuestro directorio de empresas, y tenga acceso on-line a nuestra bolsa de trabajo con las mejores ofertas de empleo</h3>
        </section>
        <section class="col-lg-4 col-lg-offset-1 well">
            <jsp:include page="/pages/register.jsp"/>
        </section>
        
        
    </body>
</html>
