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

    <!-- =================== Messages ============== -->
    <section class="messages-page">
        <div class="container">
            <div class="messages-sec">
                <div class="row">
                    <div class="col-lg-4 col-md-12 no-pdd">
                        <div class="msgs-list" id="style-4">
                            <div class="msg-title">
                                <h3>Messages</h3>
                            </div>
                            <div class="messages-list">
                                <ul>
                                    <c:forEach var="frr" items="${f}">
                                        <c:if test="${frr.id != user.id}">
                                            <a href="/messages?id=${frr.id}">
                                                <li>
                                                    <div class="usr-msg-details">
                                                        <div class="usr-ms-img">
                                                            <img src="${root}/public/images/users/avatar.jpg" alt="">
                                                        </div>
                                                        <div class="usr-mg-info">
                                                            <h3>${frr.getFirstName()} ${frr.getLastName()}</h3>
                                                        </div>
                                                    </div>
                                                </li>
                                            </a>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-8 col-md-12 pd-right-none pd-left-none" >
                        <div class="main-conversation-box">
                            <div class="messages-list">
                                <div class="message-bar-head">
                                    <div class="usr-msg-details">
                                        <div class="usr-ms-img">
                                            <img src="${root}/public/images/users/avatar.jpg" alt="">
                                        </div>
                                        <div class="usr-mg-info">
                                            <h3>${uu.getFirstName()} ${uu.getLastName()}</h3>
                                            <p>${uu.getPost()}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="messages-line"  style="margin-top: 100px">
                                    <div class="chat-messages" >
                                        <c:forEach var="message" items="${al}">
                                            <c:if test="${message.sender == user.id}">
                                                <div class="main-message-box ta-right">
                                                    <div class="pull-right ta-right" style="margin-right: 90px">
                                                        <div class="message-inner-dt">
                                                            <p class="pull-right ta-right">${message.body}</p>
                                                        </div><!--message-inner-dt end-->
                                                        <span class="pull-right ta-right">${message.date}</span>
                                                    </div><!--message-dt end-->
                                                    <div class="messg-usr-img  ">
                                                        <img src="/public/images/users/avatar.jpg" alt="" class="mCS_img_loaded">
                                                    </div><!--messg-usr-img end-->
                                                </div>
                                            </c:if>
                                            <c:if test="${message.sender != user.id}">

                                                <div class="main-message-box st3  pull-left">
                                                    <div class="message-dt st3">
                                                        <div class="message-inner-dt">
                                                            <p>${message.body}</p>
                                                        </div><!--message-inner-dt end-->
                                                        <span>${message.date}</span>
                                                    </div><!--message-dt end-->
                                                    <div class="messg-usr-img">
                                                        <img src="/public/images/users/avatar.jpg" alt="" class="mCS_img_loaded">
                                                    </div><!--messg-usr-img end-->
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="message-send-area" >
                                <form action="/messages?id=<%= (request.getParameter("id") != null) ? request.getParameter("id") : "2" %>" method="post">
                                    <div class="mf-field">
                                        <input type="text" autocomplete="off" name="messageToSend" placeholder="Type a message here">
                                        <button type="submit">Send</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- =================== !Messages ============== -->
    <file:footer/>

</div>
<file:foot/>

</body>
</html>

