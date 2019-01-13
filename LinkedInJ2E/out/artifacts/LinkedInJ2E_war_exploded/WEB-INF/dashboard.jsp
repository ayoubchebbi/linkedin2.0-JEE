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
    <!-- =================== Dashboard ============== -->
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
                                <div class="post-topbar p-0">
                                    <form action="/dashboard" method="POST" enctype="multipart/form-data">
                                        <div class="p-1">
                                            <textarea class="form-control rounded-0" name="contenu" style="border: 0px;resize:none;" rows="3" placeholder="Express yourself,  Hosni"></textarea>
                                        </div>
                                        <hr class="m-0">
                                        <div class="">

                                            <a title="emoji"><i class="la la-2x la-smile-o m-2"></i></a>

                                            <label for="upload">
                                                <span class="la la-2x la-camera text-primary m-2" aria-hidden="true"></span>
                                                <input type="file" id="upload" name="image" style="display:none" accept="image/*">
                                            </label>


                                            <label for="upload2">
                                                <span class="la la-2x la-video-camera text-primary m-2" aria-hidden="true"></span>
                                                <input type="file" id="upload2" name="video"  style="display:none" accept="video/*,audio/*">
                                            </label>

                                            <label for="upload3">
                                                <span class="la la-2x la-file-pdf-o text-primary m-2" aria-hidden="true"></span>
                                                <input type="file" id="upload3" name="file"  style="display:none" accept="file/pdf,file/ppt,file/word,file/txt">
                                            </label>

                                            <button type="submit" class="btn btn-primary btn-sm pull-right rounded-0 m-2">Publier</button>
                                        </div>
                                    </form>
                                </div>

                                <div>
                                    <c:forEach var="publication" items="${publications}">


                                        <div class="posts-section" style="padding-bottom: 30px;" >
                                            <div class="posty">
                                                <div class="post-bar no-margin">
                                                    <div class="post_topbar">
                                                        <div class="usy-dt">
                                                            <div class="user-picy">
                                                                <img src="${root}/public/images/users/avatar.jpg" alt="">
                                                            </div>
                                                            <div class="usy-name">

                                                                <c:forEach var="users" items="${users}">
                                                                    <c:if test="${users.id == publication.idUtilisateur}">
                                                                        <h3><a href="/profile?id=${users.id} ">${users.firstName} ${users.lastName}</a></h3>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <span><img src="${root}/public/images/clock.png" alt=""><fmt:formatDate type = "date" value = "${publication.date}" /></span>
                                                            </div>
                                                        </div>

                                                        <div class="ed-opts">
                                                            <a title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                            <ul class="ed-options">
                                                                <li><a href="/dashboard?id=${publication.id}" title="Delete">Delete</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>

                                                    <div class="job_descp">
                                                    <p>${publication.contenu}</p>
                                                    <c:if test="${publication.image != 'empty'}">

                                                        <div class="text-center">
                                                            <img class="align-content-center col-lg-12 col-md-12" src="http://localhost:8080/public/file/${publication.image}" class="img-thumbnail img-fluid" alt="Responsive image">
                                                        </div>
                                                    </c:if>

                                                    </div>



                                                    <c:set var="nb" value="${0}" scope="request"/>
                                                    <c:set var="likeexis" value="${false}" scope="request"/>

                                                    <c:forEach var="like" items="${likes}">
                                                        <c:if test="${like.idPublication == publication.id}">
                                                            <c:set var="nb" value="${nb+1}"  scope="request" />

                                                            <c:if test="${like.idUtilisateur == user.id}">
                                                                <c:set var="likeexis" value="${true}"  scope="request" />
                                                            </c:if>

                                                        </c:if>
                                                    </c:forEach>
                                                    <div class="job-status-bar">
                                                        <ul class="like-com">
                                                            <li>


                                                                    <c:if test="${likeexis == true}">
                                                                        <a href="/dashboard?idlike=${publication.id}" class="text-danger">  <i class="la la-heart"></i>Unlike</a>
                                                                    </c:if>
                                                                    <c:if test="${likeexis == false}">
                                                                <a href="/dashboard?idlike=${publication.id}">  <i class="la la-heart"></i>Like</a>
                                                                    </c:if>




                                                                <span class="ml-2">
                                                                    ${nb}
                                                                </span>
                                                            </li>
                                                            <li><a href="#" title="" class="com"><img src="${root}/public/images/com.png" alt="">Comments</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="comment-section">
                                                    <div class="comment-sec">
                                                        <ul>
                                                            <li>

                                                                <c:forEach var="commentaire" items="${commentaire}">
                                                                    <c:if test="${commentaire.idpublication == publication.id}">
                                                                        <div class="ed-opts">
                                                                            <a title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                                            <ul class="ed-options m-0 p-0 list-group">
                                                                                <li class="p-2 m-0 list-group-item-action"><a href="/dashboard?idcomm=${commentaire.id}" title="Delete">Delete</a></li>
                                                                            </ul>
                                                                        </div>

                                                                        <div class="comment-list p-0">


                                                                            <div class="bg-img">
                                                                                <a href="/profile?id=${commentaire.idutilisateur}"><img src="${root}/public/images/users/avatar.jpg" height="40" alt=""></a>
                                                                            </div>
                                                                            <div class="comment">
                                                                                <p class="bg-light rounded p-2 border">${commentaire.contenu}</p>
                                                                                <span><img src="${root}/public/images/clock.png" alt=""><fmt:formatDate type = "date" value = "${commentaire.date}" /></span>
                                                                            </div>
                                                                        </div>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="post-comment">
                                                        <div class="cm_img">
                                                            <img height="40" src="${root}/public/images/users/avatar.jpg"  alt="">
                                                        </div>
                                                        <form action="/dashboard?idpub=${publication.id}" method="post">

                                                            <div class="comment_box">
                                                                <input type="text" placeholder="your comment" name="comment" >

                                                            </div>
                                                            <div class="">
                                                                <button type="submit" name="commentaire" class="btn btn-primary  putll-righ rounded-0 ml-1">Post</button>
                                                            </div>
                                                        </form>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                    </c:forEach>

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

    <!-- =================== !Dashboard ============== -->
    <file:footer/>
</div>
<file:foot/>

</body>
</html>

