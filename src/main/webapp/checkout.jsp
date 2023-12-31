<%@ page import="entity.Cart" %>
<%@ page import="entity.Item" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Thanh toán</title>
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
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Thanh toán</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="index.jsp">Trang chủ</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Thanh toán</p>
        </div>
    </div>
</div>
<!-- Page Header End -->


<!-- Checkout Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <div class="col-lg-8">
            <div class="mb-4">
                <h4 class="font-weight-semi-bold mb-4">Thông tin giao hàng</h4>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label>Họ và tên lót</label>
                        <input class="form-control" type="text" placeholder="Nguyễn Trí">
                    </div>
                    <div class="col-md-6 form-group">
                        <label>Tên</label>
                        <input class="form-control" type="text" placeholder="Thành">
                    </div>
                    <div class="col-md-6 form-group">
                        <label>E-mail</label>
                        <input class="form-control" type="text" placeholder="thanhnguyen@gmail.com">
                    </div>
                    <div class="col-md-6 form-group">
                        <label>Số điện thoại</label>
                        <input class="form-control" type="text" placeholder="+843 456 789">
                    </div>
                    <div class="col-md-6 form-group">
                        <label>Số nhà</label>
                        <input class="form-control" type="text" placeholder="123 Võ Văn Ngân">
                    </div>
                    <div class="col-md-6 form-group">
                        <label>Quận</label>
                        <input class="form-control" type="text" placeholder="Thủ Đức">
                    </div>
                    <div class="col-md-12 form-group">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="newaccount">
                            <label class="custom-control-label" for="newaccount">Tạo tài khoản</label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="card border-secondary mb-5">
                <div class="card-header bg-secondary border-0">
                    <h4 class="font-weight-semi-bold m-0">Đơn hàng</h4>
                </div>
                <div class="card-body">
                    <h5 class="font-weight-medium mb-3">Sản phẩm</h5>
                    <%
                        Cart cart = (Cart) session.getAttribute("cartP");
                        List<Item> list = cart.getItems();
                        for (Item p : list) {
                    %>
                    <div class="d-flex justify-content-between">
                        <p><%=p.getProduct().getName()%></p>
                        <p>SL: <%=p.getQuantity()%></p>
                        <p><%=p.getPrice()%> đ</p>
                    </div>
                    <%
                        }
                    %>
                    <hr class="mt-0">
                    <div class="d-flex justify-content-between mb-3 pt-1">
                        <h6 class="font-weight-medium">Tổng tiền</h6>
                        <h6 class="font-weight-medium"><%=cart.totalMoney()%> đ</h6>
                    </div>
                    <div class="d-flex justify-content-between">
                        <h6 class="font-weight-medium">Phí giao hàng</h6>
                        <h6 class="font-weight-medium">20 000 đ</h6>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <div class="d-flex justify-content-between mt-2">
                        <h5 class="font-weight-bold">Tổng cộng</h5>
                        <h5 class="font-weight-bold"><%=cart.totalMoney() + 20000%> đ</h5>
                    </div>
                </div>
            </div>
            <div class="card border-secondary mb-5">
                <div class="card-header bg-secondary border-0">
                    <h4 class="font-weight-semi-bold m-0">Phương thức thanh toán</h4>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" name="payment" id="paypal">
                            <label class="custom-control-label" for="paypal">COD</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" name="payment" id="directcheck">
                            <label class="custom-control-label" for="directcheck">Chuyển khoản</label>
                        </div>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <button class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Thanh toán</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Checkout End -->

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