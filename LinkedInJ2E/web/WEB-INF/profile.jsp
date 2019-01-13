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
    <!-- =================== Profile ============== -->
    <section class="cover-sec">
        <img src="${root}/public/images/bg.jpg" height="300" alt="">
    </section>
    <main>
        <div class="main-section">
            <div class="container">
                <div class="main-section-data">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="main-left-sidebar">
                                <div class="user_profile">
                                    <div class="user-pro-img">
                                        <img src="${root}/public/images/users/avatar.jpg" alt="">
                                    </div>

                                    <div class="user_pro_status">

                                        <div class="star-descp text-center">
                                            <h2>${user.firstName} ${user.lastName}</h2>
                                            <span>${user.post}</span>
                                        </div>

                                        <a href="AddFriend?id=${user.getId()}" class="follow" title="Remove from friends">
                                            <button class="btn btn-primary">Add friend</button>
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="main-ws-sec">

                                <div >
                                    <div class="user-profile-ov">
                                        <h3>Email:</h3>
                                        <p>${user.email}</p>
                                        <br/>
                                        <h3>Phone:</h3>
                                        <p>${user.phone}</p>
                                        <br/>
                                        <h3>Gender:</h3>
                                        <p>
                                            <c:choose>
                                                <c:when test="${user.sex!=''}">${user.sex}</c:when>
                                                <c:otherwise>Unknown</c:otherwise>
                                            </c:choose>
                                        </p>
                                        <br/>
                                        <h3> Date of birth::</h3>
                                        <p>
                                            ${user.birthDate}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


    <!-- =================== !Profile ============== -->
    <file:footer/>

</div>
<file:foot/>

</body>
</html>

