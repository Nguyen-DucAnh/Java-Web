<%-- 
    Document   : order
    Created on : Mar 24, 2025, 4:31:48 AM
    Author     : Nguyen Duc Anh
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>EShopper - Bootstrap Shop Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/order.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="orderstatus" method="POST">
            <section class="vh-100" style="background-color: #8c9eff;">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12">
                            <div class="card card-stepper" style="border-radius: 16px;">

                                <div class="card-body p-5">

                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                        <div>
                                            <h5 class="mb-0">INVOICE <span class="text-primary font-weight-bold">#Y34XDHR</span></h5>
                                        </div>
                                        <c:forEach items="${requestScope.listO}" var="o">
                                            <div class="text-end">

                                                <p class="mb-0">Order Status: <span>${o.getStatusID().sName}</span></p>
                                                <p class="mb-0">OrderID: <span class="font-weight-bold">${o.id}</span></p>

                                            </div>
                                        </c:forEach>
                                    </div>

                                    <ul id="progressbar-2" class="d-flex justify-content-between mx-0 mt-0 mb-5 px-0 pt-0 pb-2">
                                        <li class="step0 active text-center" id="step1"></li>
                                        <li class="step0 active text-center" id="step2"></li>
                                        <li class="step0 active text-center" id="step3"></li>
                                        <li class="step0 text-muted text-end" id="step4"></li>
                                    </ul>

                                    <div class="d-flex justify-content-between">
                                        <div class="d-lg-flex align-items-center">
                                            <i class="fas fa-clipboard-list fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                                            <div>
                                                <p class="fw-bold mb-1">Order</p>
                                                <p class="fw-bold mb-0">Processed</p>
                                            </div>
                                        </div>
                                        <div class="d-lg-flex align-items-center">
                                            <i class="fas fa-box-open fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                                            <div>
                                                <p class="fw-bold mb-1">Order</p>
                                                <p class="fw-bold mb-0">Shipped</p>
                                            </div>
                                        </div>
                                        <div class="d-lg-flex align-items-center">
                                            <i class="fas fa-shipping-fast fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                                            <div>
                                                <p class="fw-bold mb-1">Order</p>
                                                <p class="fw-bold mb-0">En Route</p>
                                            </div>
                                        </div>
                                        <div class="d-lg-flex align-items-center">
                                            <i class="fas fa-home fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                                            <div>
                                                <p class="fw-bold mb-1">Order</p>
                                                <p class="fw-bold mb-0">Arrived</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Lấy trạng thái đơn hàng từ JSP (đảm bảo không có khoảng trắng thừa)
                let orderStatus = "${o.getStatusID().sName}".trim().toLowerCase();

                // Map trạng thái với bước tiến trình
                let stepMap = {
                    "Processing": 1,
                    "Shipping": 2,
                    "Completed": 3,
                    "arrived": 4
                };

                // Xác định bước hiện tại, nếu không có thì mặc định là 0
                let currentStep = stepMap[orderStatus] || 0;

                // Lấy danh sách các bước trong thanh tiến trình
                let steps = document.querySelectorAll("#progressbar-2 li");

                // Duyệt qua từng bước và cập nhật trạng thái
                steps.forEach((step, index) => {
                    if (index < currentStep) {
                        step.classList.add("active");  // Thêm class "active" để làm sáng bước
                        step.classList.remove("text-muted");
                    } else {
                        step.classList.remove("active");
                        step.classList.add("text-muted");  // Làm mờ bước chưa đạt
                    }
                });
            });
        </script>


    </body>
</html>
