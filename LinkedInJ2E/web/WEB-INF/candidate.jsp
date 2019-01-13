<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="file" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>LinkedIn2</title>
    <file:head/>
</head>
<body>
<div class="wrapper">
    <file:header/>
    <!-- =================== Jobs ============== -->
    <main>
        <div class="main-section">
            <div class="container">
                <div class="main-section-data">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 pd-left-none no-pd">
                            <div class="main-left-sidebar no-margin">
                                <file:profile/>
                                <file:suggestions/>

                            </div>
                        </div>

                        <div class="col-lg-9 col-md-8 no-pd">
                            <div class="main-ws-sec">


                                    <div class="posts-section">
                                        <div class="post-bar">
                                            <div class="post_topbar">

                                                <p class="h3">Candidate list</p>

                                                <table class="table table-striped">
                                                    <thead>
                                                    <tr>
                                                        <th scope="col">id</th>
                                                        <th scope="col">Offer</th>
                                                        <th scope="col">Candidate</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="listjob" items="${listjob}">
                                                        <c:if test="${listjob.idRecruteur == user.id}">
                                                            <c:forEach var="listcandidature" items="${listcandidature}">
                                                                <c:if test="${listjob.id == listcandidature.idjob}">

                                                                    <tr>
                                                                        <th scope="row">${listcandidature.id}</th>
                                                                        <td>${listjob.nomOffre}</td>
                                                                        <td>
                                                                            <c:forEach var="listuser" items="${listuser}">
                                                                                <c:if test="${listuser.id == listcandidature.iduser}">
                                                                                   <a href="/profile?id=${listuser.id}">${listuser.firstName} ${listuser.lastName}</a>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                        </td>
                                                                    </tr>


                                                                </c:if>
                                                            </c:forEach>
                                                        </c:if>
                                                    </c:forEach>

                                                    </tbody>
                                                </table>


                                            </div>
                                        </div>
                                    </div>


                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- =================== !Jobs ============== -->
    <file:footer/>

</div>
<file:foot/>

</body>
</html>


