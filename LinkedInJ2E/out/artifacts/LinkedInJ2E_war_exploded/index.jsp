<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>LinkedIn2</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" type="text/css" href="${root}/public/css/animate.css">
  <link rel="stylesheet" type="text/css" href="${root}/public/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${root}/public/css/line-awesome.css">
  <link rel="stylesheet" type="text/css" href="${root}/public/css/line-awesome-font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="${root}/public/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="${root}/public/css/style.css">
  <link rel="stylesheet" type="text/css" href="${root}/public/css/responsive.css">
</head>
<body>
<div class="wrapper">

  <header>
    <div class="container">
      <div class="header-data">
        <div class="logo" style="margin-bottom: 10px">
          <a href='/' title=""><img src="${root}/public/images/logo_white.png" height="35" alt=""></a>
        </div>
      </div>
    </div>
  </header>

  <!-- =================== Home ============== -->
  <div class="wrapper">
    <div class="sign-in-page">
      <div class="signin-popup">
        <div class="signin-pop" style="margin-bottom: 100px">
          <div class="row">
            <div class="col-lg-6">
              <div class="cmp-info">
                <div class="cm-logo">
                  <img src="${root}/public/images/logo_black.png" height="50" alt="">
                  <br/>
                  <p>Linkedin2.0,  is a global freelancing platform and social networking where businesses and independent professionals connect and collaborate remotely</p>
                </div>
                <img src="${root}/public/images/cm-main-img.png" alt="">
              </div>
            </div>
            <div class="col-lg-6">
              <div class="login-sec">
                <ul class="sign-control">
                  <li data-tab="tab-1" class="current"><a href="#" title="">Sign in</a></li>
                  <li data-tab="tab-2" ><a href="#" title="">Sign up</a></li>
                </ul>
                <div class="sign_in_sec current" id="tab-1">
                  <h3>Sign in</h3>
                  <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger">
                      <strong>
                          ${errorMessage}
                      </strong>
                    </div>
                  </c:if>
                  <form action="/login" method="POST" autocomplete="off">
                    <div class="row">
                      <div class="col-lg-12 no-pdd">
                        <div class="sn-field">
                          <input type="email" value='${param.email}' name="email" placeholder="Email...">
                          <i class="la la-user"></i>
                        </div>
                      </div>
                      <div class="col-lg-12 no-pdd">
                        <div class="sn-field">
                          <input type="password" name="password" value="" placeholder="Password">
                          <i class="la la-lock"></i>
                        </div>
                      </div>
                      <div class="col-lg-12 no-pdd">
                        <div class="checky-sec">
                          <div class="fgt-sec">
                            <input type="checkbox" name="cc" id="c1">
                            <label for="c1">
                              <span></span>
                            </label>
                            <small>Remember me</small>
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-12 no-pdd">
                        <button type="submit" value="submit">Sign in</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="sign_in_sec" id="tab-2">
                  <div class="dff-tab current" id="tab-3">
                    <c:if test="${not empty errorMessage1}">
                      <div class="alert alert-danger">
                        <strong>
                            ${errorMessage1}
                        </strong>
                      </div>
                    </c:if>
                    <form action="/register" method="post" autocomplete="off">
                      <div class="row">
                        <div class="col-lg-12 no-pdd">
                          <div class="sn-field">
                            <input type="email" name="email" id="email" class="form-control" placeholder="E-Mail" required maxlength="255" value='${param.email}'>
                            <i class="la la-briefcase"></i>
                          </div>
                        </div>
                        <div class="col-lg-12 no-pdd">
                          <div class="sn-field">
                            <input type="text" name="first_name" id="first_name" class="form-control" placeholder="First name" required maxlength="255" value='${param.first_name}'>
                            <i class="la la-user"></i>
                          </div>
                        </div>
                        <div class="col-lg-12 no-pdd">
                          <div class="sn-field">
                            <input type="text" name="last_name" id="last_name" class="form-control" placeholder="Last name" required maxlength="255" value='${param.last_name}'>
                            <i class="la la-user"></i>
                          </div>
                        </div>
                        <div class="col-lg-12 no-pdd">
                          <div class="sn-field">
                            <input type="password" name="password" id="password" class="form-control" required maxlength="255" placeholder="Password">
                            <i class="la la-lock"></i>
                          </div>
                        </div>
                        <div class="col-lg-12 no-pdd">
                          <div class="sn-field">
                            <input type="password" name="confirm_password" id="confirm_password" class="form-control" required maxlength="255" placeholder="Confirm password">
                            <i class="la la-lock"></i>
                          </div>
                        </div>
                        <div class="col-lg-12 no-pdd">
                          <div class="checky-sec st2">
                            <div class="fgt-sec">
                              <input type="checkbox" name="cc" id="c2">
                              <label for="c2">
                                <span></span>
                              </label>
                              <small>Yes, I understand and agree to the Linkedin2.0 Terms & Conditions.</small>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-12 no-pdd">
                          <button type="submit">Get Started</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- =================== !Home ============== -->

  <footer>
    <div class="footy-sec mn no-margin">
      <div class="container">
        <ul>
          <li><a href="#" title="">Help Center</a></li>
          <li><a href="#" title="">Privacy Policy</a></li>
        </ul>
        <p><img src="${root}/public/images/copy-icon2.png" alt="">Copyright 2018</p>
        <img class="fl-rgt" src="${root}/public/images/logo_black.png" height="20" alt="">
      </div>
    </div>
  </footer>
</div>
<script type="text/javascript" src="${root}/public/js/jquery.min.js"></script>
<script type="text/javascript" src="${root}/public/js/popper.js"></script>
<script type="text/javascript" src="${root}/public/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${root}/public/js/script.js"></script>
</body>
</html>

