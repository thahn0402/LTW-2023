<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Topbar Start -->
<div class="container-fluid">
    <div class="row bg-secondary py-2 px-xl-5">
        <div class="col-lg-6 d-none d-lg-block">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark" href="">FAQs</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Help</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Support</a>
            </div>
        </div>
        <div class="col-lg-6 text-center text-lg-right">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark px-2" href="">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-twitter"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-linkedin-in"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-instagram"></i>
                </a>
                <a class="text-dark pl-2" href="">
                    <i class="fab fa-youtube"></i>
                </a>
            </div>
        </div>
    </div>
    <div class="row align-items-center py-3 px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a href="home" class="text-decoration-none">
                <h1 class="m-0 display-5 font-weight-semi-bold"><span
                        class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
            </a>
        </div>
        <div class="col-lg-6 col-6 text-left">
            <form action="search" method="post">
                <div class="input-group">
                    <input value="${txtS}" name="txt" type="text" class="form-control" placeholder="Tìm kiếm sản phẩm">
                    <div class="input-group-append">
                        <button type="submit" class="input-group-text bg-transparent text-primary">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-3 col-6 text-right">
            <a href="" class="btn border">
                <i class="fas fa-heart text-primary"></i>
                <span class="badge">0</span>
            </a>
            <a href="" class="btn border">
                <i class="fas fa-shopping-cart text-primary"></i>
                <span class="badge">0</span>
            </a>
        </div>
    </div>
</div>
<!-- Topbar End -->


<!-- Navbar Start -->
<div class="container-fluid">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
               data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                <h6 class="m-0">Loại sản phẩm</h6>
                <i class="fa fa-angle-down text-dark"></i>
            </a>
            <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
                 id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                <div class="navbar-nav w-100 overflow-hidden" style="height: 250px">
                    <%--                    <div class="nav-item dropdown">--%>
                    <%--                        <a href="#" class="nav-link" data-toggle="dropdown">Quần áo<i--%>
                    <%--                                class="fa fa-angle-down float-right mt-1"></i></a>--%>
                    <%--                        <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">--%>
                    <%--                            <a href="" class="dropdown-item">Quần áo nam</a>--%>
                    <%--                            <a href="" class="dropdown-item">Quần áo nữ</a>--%>
                    <%--                            <a href="" class="dropdown-item">Quần áo trẻ em</a>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <a href="men" class="nav-item nav-link">Quần áo nam</a>
                    <a href="women" class="nav-item nav-link">Quần áo nữ</a>
                    <a href="children" class="nav-item nav-link">Quần áo trẻ em</a>
                    <a href="accessory" class="nav-item nav-link">Phụ kiện</a>
                    <a href="handbag" class="nav-item nav-link">Túi</a>
                    <a href="shoes" class="nav-item nav-link">Giày</a>
                </div>
            </nav>
        </div>
        <div class="col-lg-9">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <a href="home" class="text-decoration-none d-block d-lg-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span
                            class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="home" class="nav-item nav-link">Trang chủ</a>
                        <a href="shop" class="nav-item nav-link">Cửa hàng</a>
                        <a href="cart" class="nav-item nav-link">Giỏ hàng</a>
                        <a href="checkout.jsp" class="nav-item nav-link">Thanh toán</a>
                        <%--                        <a href="detail.jsp" class="nav-item nav-link">Shop Detail</a>--%>
                        <%--                        <div class="nav-item dropdown">--%>
                        <%--                            <a href="#" class="nav-link dropdown-toggle active" data-toggle="dropdown">Các trang</a>--%>
                        <%--                            <div class="dropdown-menu rounded-0 m-0">--%>
                        <%--                                <a href="cart.jsp" class="dropdown-item">Giỏ han</a>--%>
                        <%--                                <a href="checkout.jsp" class="dropdown-item">Checkout</a>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <a href="contact.jsp" class="nav-item nav-link">Liên hệ</a>
                        <c:if test="${sessionScope.acc.isSell == 1}">
                            <a href="managerproduct" class="nav-item nav-link">QL sản phẩm</a>
                        </c:if>
                        <c:if test="${sessionScope.acc.isAdmin == 1}">
                            <a href="manageraccount" class="nav-item nav-link">QL tài khoản</a>
                        </c:if>
                    </div>
                    <c:if test="${sessionScope.acc != null}">
                        <div class="navbar-nav ml-auto py-0">
                            <a href="" class="nav-item nav-link">${sessionScope.acc.name}</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                            <a href="logout" class="nav-item nav-link">Đăng xuất</a>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.acc == null}">
                        <div class="navbar-nav ml-auto py-0">
                            <a href="login.jsp" class="nav-item nav-link">Đăng nhập/Đăng kí</a>
                        </div>
                    </c:if>
                </div>
            </nav>
        </div>
    </div>
</div>
<!-- Navbar End -->