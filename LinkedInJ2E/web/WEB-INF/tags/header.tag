<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<header>
    <div class="container">
        <div class="header-data">
            <div class="logo">
                <a title=""><img src="${root}/public/images/logo.png" alt=""></a>
            </div>
            <div class="search-bar">
                <form action="/networks" method="post" autocomplete="off">
                    <input type="text" name="name" placeholder="Search...">
                    <button type="submit"><i class="la la-search"></i></button>
                </form>
            </div>
            <nav>
                <ul>
                    <li>
                        <a href="/dashboard" title="">
                            <span><img src="${root}/public/images/icon1.png" alt=""></span> Home
                        </a>
                    </li>
                    <li>
                        <a href="/networks" title="">
                            <span><img src="${root}/public/images/icon4.png" alt=""></span> My Network
                        </a>
                    </li>
                    <li>
                        <a href="/jobs" title="">
                            <span><img src="${root}/public/images/icon5.png" alt=""></span> Jobs
                        </a>
                    </li>
                    <c:if test="${user.recruiter == 1}">

                        <li>
                            <a href="/candidate" title="">
                                <span><img src="${root}/public/images/icon7.png" alt=""></span> candidate
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="/messages" title="" class="not-box-open">
                            <span><img src="${root}/public/images/icon6.png" alt=""></span> Messages
                        </a>
                    </li>


                </ul>
            </nav>

            <div class="menu-btn">
                <a  title=""><i class="fa fa-bars"></i></a>
            </div>

            <div class="user-account">


                <div class="user-info">
                    <img src="${root}/public/images/users/avatar.jpg" height="35" alt="">
                    <a title=""><strong>${user.firstName}</strong></a>
                </div>
                <div class="user-account-settingss">
                    <ul class="us-links">
                        <li><a href="/profile" title="Profile">Profile</a></li>
                        <li><a href="/edit" title="Update">Update</a></li>
                        <li><a href="/password" title="Update">Password</a></li>
                    </ul>
                    <h3 class="tc"><a href="/logout" title="Logout">Logout</a></h3>
                </div>

            </div>
        </div>
    </div>
</header>