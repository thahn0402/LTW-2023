<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Liên hệ</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.png" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
<!-- Header -->
<jsp:include page="header.jsp"></jsp:include>


<!-- Page Header Start -->
<div class="container-fluid bg-secondary mb-5">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Liên hệ với chúng tôi</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="index.jsp">Trang chủ</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Liên hệ với chúng tôi</p>
        </div>
    </div>
</div>
<!-- Page Header End -->


<!-- Contact Start -->
<div class="container-fluid pt-5">
    <div class="text-center mb-4">
        <h2 class="section-title px-5"><span class="px-2">Liên hệ với bất kỳ câu hỏi nào</span></h2>
    </div>
    <div class="row px-xl-5">
        <div class="col-lg-7 mb-5">
            <div class="contact-form">
                <div id="success"></div>
                <form name="sentMessage" id="contactForm" novalidate="novalidate">
                    <div class="control-group">
                        <input type="text" class="form-control" id="name" placeholder="Tên của bạn"
                               required="required" data-validation-required-message="Vui lòng nhập tên"/>
                        <p class="help-block text-danger"></p>
                    </div>
                    <div class="control-group">
                        <input type="email" class="form-control" id="email" placeholder="Email của bạn"
                               required="required" data-validation-required-message="Vui lòng nhập email"/>
                        <p class="help-block text-danger"></p>
                    </div>
                    <div class="control-group">
                        <input type="text" class="form-control" id="subject" placeholder="Đối tượng"
                               required="required" data-validation-required-message="Vui lòng nhập đối tượng"/>
                        <p class="help-block text-danger"></p>
                    </div>
                    <div class="control-group">
                            <textarea class="form-control" rows="6" id="message" placeholder="Lời nhắn"
                                      required="required"
                                      data-validation-required-message="Vui lòng nhập lời nhắn"></textarea>
                        <p class="help-block text-danger"></p>
                    </div>
                    <div>
                        <button class="btn btn-primary py-2 px-4" type="submit" id="sendMessageButton">Gửi tin nhắn
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-lg-5 mb-5">
            <h5 class="font-weight-semi-bold mb-3">Liên lạc</h5>
            <p>Được thành lập vào tháng 10/2022, EShopper là doanh nghiệp chuyên về quản trị, sản xuất và phân
                phối các dòng sản phẩm bao gồm thời trang, phụ kiện và giày, đa
                phần là các bản in mang tác phẩm của các nghệ sỹ trẻ hàng đầu Việt Nam. </p>
            <div class="d-flex flex-column mb-3">
                <h5 class="font-weight-semi-bold mb-3">Cửa hàng 1</h5>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Võ Văn Ngân, Thủ Đức, VN</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>19130207@st.hcmuaf.edu.vn</p>
                <p class="mb-2"><i class="fa fa-phone-alt text-primary mr-3"></i>+842 345 67890</p>
            </div>
            <div class="d-flex flex-column">
                <h5 class="font-weight-semi-bold mb-3">Cửa hàng 2</h5>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>456 Lê Văn Việt, Quận 9, VN</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>19130207@st.hcmuaf.edu.vn<</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+842 345 67890</p>
            </div>
        </div>
    </div>
</div>
<!-- Contact End -->


<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="mail/jqBootstrapValidation.min.js"></script>
<script src="mail/contact.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>

</html>