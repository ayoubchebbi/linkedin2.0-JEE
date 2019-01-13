<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="file" tagdir="/WEB-INF/tags" %>
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
    <!-- =================== Networks ============== -->
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

                        <div class="col-lg-9 col-md-9 no-pd">
                            <section>
                                <div class="container">
                                    <div class="company-title">
                                        <h3>All Connexion</h3>
                                    </div>

                                    <div class="companies-list">
                                        <div class="row">

                                            <c:forEach var="user_profile" items="${al}">
                                                <c:if test="${user_profile.id != user.id}">
                                                    <div class="col-lg-4 col-md-5 col-sm-6">
                                                        <div class="company_profile_info">
                                                            <div class="company-up-info">
                                                                <img src="${root}/public/images/users/avatar.jpg" alt="">
                                                                <h3>${user_profile.firstName } ${user_profile.lastName }</h3>
                                                                <h4>${user_profile.email }</h4>
                                                                <ul>
                                                                    <li><a href="DeleteFriend?id=${user_profile.getId()}" class="follow" title="Remove from friends">Delete friend</a></li>
                                                                    <li><a href="messages?id=${user_profile.id}" title="" class="message-us"><i class="fa fa-envelope"></i></a></li>
                                                                </ul>
                                                            </div>
                                                            <a href="/profile?id=${user_profile.id}" title="" class="view-more-pro">View Profile</a>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- =================== !Networks ============== -->
    <file:footer/>

</div>
<file:foot/>
</body>
</html>

