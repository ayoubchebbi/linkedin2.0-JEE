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

                            <div class="posts-section">
                                <div class="post-bar">
                                    <div class="post_topbar">

                                        <p class="h3">Edit your profile</p>

                                        <form class="p-3" method="POST" action="/edit">


                                            <div class="form-group">
                                                <input type="email" class="form-control" name="email" value="${user.email}" placeholder="Email">
                                            </div>

                                            <div class="form-group">
                                                <input type="text" class="form-control" name="name" value="${user.firstName}" placeholder="First Name">
                                            </div>

                                            <div class="form-group">
                                                <input type="text" class="form-control" name="surname" value="${user.lastName}"  placeholder="Last Name">
                                            </div>

                                            <div class="form-group">
                                                <input type="text" class="form-control" name="post" value="${user.post}" placeholder="Post">
                                            </div>

                                            <div class="form-group">
                                                <input type="text" class="form-control" name="phone" value="${user.phone}" placeholder="Phone">
                                            </div>

                                            <div class="form-group">
                                                <input type="date" class="form-control" name="birthday" value="${user.birthDate}" placeholder="Date">
                                            </div>





                                            <button type="submit" class="btn btn-primary">Edit</button>
                                        </form>



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

