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

                        <div class="col-lg-6 col-md-8 no-pd">
                            <div class="main-ws-sec">


                                <c:if test="${user.recruiter == 1}">
                                    <div class="posts-section">
                                        <div class="post-bar">
                                            <div class="post_topbar">

                                                <p class="h3">Post job</p>

                                                <form class="p-3" method="POST" action="/jobs">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="name_offer" placeholder="Offer">
                                                    </div>
                                                    <div class="form-group">
                                                        <textarea class="form-control" name="description" rows="3" placeholder="Description"></textarea>
                                                    </div>

                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="place" placeholder="Place">
                                                    </div>

                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="price" placeholder="Price">
                                                    </div>



                                                    <div class="form-row">
                                                        <div class="col-md-4 mb-3">
                                                            <div class="input-group">

                                                                <input type="text" name="hashtag1" class="form-control" placeholder="Hashtag" required>

                                                            </div>
                                                        </div>

                                                        <div class="col-md-4 mb-3">
                                                            <div class="input-group">

                                                                <input type="text" name="hashtag2" class="form-control" placeholder="Hashtag" required>

                                                            </div>
                                                        </div>

                                                        <div class="col-md-4 mb-3">
                                                            <div class="input-group">

                                                                <input type="text" name="hashtag3" class="form-control" placeholder="Hashtag" required>

                                                            </div>
                                                        </div>
                                                    </div>



                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                </form>



                                        </div>
                                        </div>
                                    </div>
                                </c:if>


                                <div class="posts-section">
                                    <tr>




                                        <c:forEach var="job" items="${jobs}">

                                            <div class="post-bar">
                                                <div class="post_topbar">
                                                    <c:if test="${user.recruiter == 1}">
                                                    <div class="usy-dt">
                                                        <img src="${root}/public/images/users/avatar.jpg" height="50" alt="">
                                                        <div class="usy-name">
                                                            <c:forEach var="users" items="${users}">
                                                                <c:if test="${users.id == job.idRecruteur}">
                                                                    <h3>${users.firstName} ${users.lastName}</h3>
                                                                </c:if>
                                                            </c:forEach>
                                                            <span><img src="${root}/public/images/clock.png" alt="">${job.date}</span>
                                                        </div>
                                                    </div>

                                                <c:forEach var="users" items="${users}">
                                                    <c:if test="${users.id == job.idRecruteur}">
                                                        <div class="ed-opts">
                                                            <a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                            <ul class="ed-options p-2 m-2" >
                                                                <li><a href="/jobs?id=${job.id}" title="">Delete</a></li>
                                                            </ul>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                                    </c:if>

                                                </div>
                                                <div class="epi-sec">
                                                    <ul class="descp">
                                                        <li><img src="${root}/public/images/icon9.png" alt=""><span>${job.place}</span></li>
                                                    </ul>
                                                    <ul class="bk-links">

                                                        <c:forEach var="jobpostulation" items="${jobpostulation}">
                                                            <c:if test="${user.id == jobpostulation.iduser && job.id == jobpostulation.idjob}">
                                                                <li><a href="/jobs?idjob=${jobpostulation.id}&action=delete" class="btn btn-outline-danger">Supprimer la candidature</a></li>
                                                                <c:set var="tester" value="yes" scope="request" />
                                                            </c:if>
                                                        </c:forEach>
                                                            <c:if test="${tester == yes}">
                                                                <li><a href="/jobs?idjob=${job.id}&iduser=${user.id}&action=add" class="btn btn-outline-primary">Postulation rapide</a></li>
                                                            </c:if>

                                                    </ul>
                                                </div>
                                                <div class="job_descp">
                                                    <h3><td>${job.nomOffre}</td></h3>
                                                    <ul class="job-dt">
                                                        <li><a href="#" title="" class="bg-primary">Full Time</a></li>
                                                        <li><span>dt${job.price} / hr</span></li>
                                                    </ul>
                                                    <p><td>${job.place}</td></p>
                                                    <ul class="skill-tags">
                                                        <li><a href="#" title="">${job.hashtag1}</a></li>
                                                        <li><a href="#" title="">${job.hashtag2}</a></li>
                                                        <li><a href="#" title="">${job.hashtag3}</a></li>
                                                    </ul>
                                                </div>
                                            </div>

                                        </c:forEach>

                                    </tr>
                                </div>
                            </div>
                        </div>


                        <div class="col-lg-3 pd-right-none no-pd">
                            <div class="right-sidebar">
                                <file:topjobs/>
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


