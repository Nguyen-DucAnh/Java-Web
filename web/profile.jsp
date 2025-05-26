<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <style>
            .gradient-custom {
                background: #f6d365;
                background: -webkit-linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));
                background: linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));
            }
            .back-to-home {
                margin-top: 20px; /* Khoảng cách phía trên */
            }
        </style>
    </head>
    <body>
        <section class="vh-100" style="background-color: #f4f5f7;">
            <div class="container py-5 h-100">

                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-6 mb-4 mb-lg-0">

                        <div class="card mb-3" style="border-radius: .5rem;">

                            <div class="row g-0">
                                <div class="col-md-4 gradient-custom text-center text-white"
                                     style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                         alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
                                    <h5>Hello ${sessionScope.user.lastName}</h5>
                                    <button onclick="location.href = 'logout'" class="btn btn-danger mb-5"><i class="fas fa-sign-out-alt"></i> LogOut</button>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body p-4">
                                        <c:if test="${empty sessionScope.user}">
                                            <h6 onclick="location.href = 'addProfile.jsp';">
                                                 Information <i class="bi bi-pencil"></i> 
                                            </h6>
                                        </c:if>
                                         <c:if test="${not empty sessionScope.user}">
                                            <h6 onclick="location.href = 'loadeditprofile';">
                                                 Information <i class="bi bi-pencil"></i> 
                                            </h6>
                                        </c:if>
                                        <hr class="mt-0 mb-4">
                                        <div class="row pt-1">
                                            <div class="col-6 mb-3">
                                                <h6>Email</h6>
                                                <p class="text-muted" style="white-space: nowrap;">
                                                    <c:if test="${not empty sessionScope.user.email}">
                                                        ${sessionScope.user.email}
                                                    </c:if>    
                                                </p>
<!--                                                <h6>
                                                    <c:if test="${not empty sessionScope.user.email}">
                                                        <a href="editEmail.jsp" class="text-muted btn-small">Change email</a>
                                                    </c:if>
                                                    <c:if test="${empty sessionScope.user.email}">
                                                        <a href="editEmail.jsp" class="text-muted btn-small">Add email</a>
                                                    </c:if>
                                                </h6>-->
                                            </div>
                                            <div class="col-6 mb-3">
                                                <h6>Phone</h6>
                                                <p class="text-muted" style="white-space: nowrap;">
                                                    <c:if test="${not empty sessionScope.user.phone}">
                                                        ${sessionScope.user.phone}
                                                    </c:if>

                                                </p>
<!--                                                <h6>
                                                    <c:if test="${not empty sessionScope.user.phone}">
                                                        <a href="#" class="text-muted btn-small">Change Phone</a>
                                                    </c:if>
                                                    <c:if test="${empty sessionScope.user.phone}">
                                                        <a href="#" class="text-muted btn-small">Add Phone</a>
                                                    </c:if>
                                                </h6>-->
                                            </div>
                                        </div>

                                        <hr class="mt-0 mb-4">
                                        <h6>Account</h6>
                                        <h7 style="color: green">${requestScope.ms}</h7>
                                        <div class="row pt-1">
                                            <div class="col-6 mb-3">
                                                <h6><a href="editAccount.jsp" class="text-muted">Change Password</a></h6>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-start">
                                            <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                                            <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                                            <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
                                        </div>
                                    </div>
                                </div>                                                 
                            </div>
                        </div>

                        <div class="text-center back-to-home">
                            <a href="index.jsp" class="btn btn-primary">Back to home</a>
                        </div>
                    </div>
                </div>  

            </div>
        </section>       
    </body>
</html>