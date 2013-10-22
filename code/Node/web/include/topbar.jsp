<%@page import="model.entities.UserType"%>
<%@page import="model.petition.Entity"%>
<%@page import="model.entities.User"%>
<%@page pageEncoding="utf-8"%>
<div class="header">
    <header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">Node</a>
            </div>
            <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                <ul class="nav navbar-nav">        
            <%
                User user = null;
                if(session.getAttribute(Entity.user.toString())!=null)
                     user= ((User)session.getAttribute(Entity.user.toString()));
            %>
            
            <%if(user!=null){%>
                <%if(user.getUserType()==UserType.company || user.getUserType()==UserType.applicant){%>
                        <li><a href="./prospects.jsp">Inicio</a></li>
                        <li><a href="./suggested.jsp">Sugeridos</a></li>
                        <li><a href="./profile.jsp">Perfil</a></li>
                <%}if(user.getUserType()==UserType.admin){%>
                        <li><a href="./profile.jsp">Perfil</a></li>
                        <li><a href="./admin.jsp">Administrar</a></li>
                <%}%>
            <%}%>
                </ul>
            </nav>
        </div>
    </header>
</div>