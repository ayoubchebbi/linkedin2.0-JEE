<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="user-data full-width">
    <div class="user-profile">
        <div class="username-dt">
            <div class="usr-pic">
                <img src="${root}/public/images/users/avatar.jpg" alt="">
            </div>
        </div>
        <div class="user-specs">
            <h3>${user.firstName} ${user.lastName}</h3>
            <span> ${user.post} </span>
        </div>
    </div>
    <a href="/profile" title="">
        <ul class="user-fw-status">
            <li>
                View Profile
            </li>
        </ul>
    </a>
</div>