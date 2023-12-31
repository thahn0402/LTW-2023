<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Quản lí tài khoản</title>
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<!-- Header -->
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid pt-5">
    <div class="row px-xl-5 pb-3">
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
            <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                <%--                <h1 class="fa fa-check text-primary m-0 mr-3"></h1>--%>
                <h5 class="font-weight-semi-bold m-0">Quản lí tài khoản</h5>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
            <%--            <div class="d-flex align-items-center border mb-4" style="padding: 30px;">--%>
            <%--                <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>--%>
            <%--                <h5 class="font-weight-semi-bold m-0">Miễn phí Shipping</h5>--%>
            <%--            </div>--%>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">

        </div>
        <%--        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">--%>
        <%--            <div class="card-footer border-secondary bg-transparent">--%>

        <%--                <a href="addProduct.jsp" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3"><i--%>
        <%--                        class="text-primary mr-1"></i>Thêm sản phẩm</a>--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </div>
</div>
<table class="table table-bordered ">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Email</th>
        <th scope="col">Người bán</th>
        <th scope="col">Admin</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listP}" var="o">
    <tr>
        <td>${o.id}</td>
        <td>${o.name}</td>
        <td> ${o.address} </td>
        <td>${o.email}</td>
        <td>
            <c:if test="${o.isSell == 1}">Là người bán</c:if>
            <c:if test="${o.isSell == 0}">Không</c:if>
        </td>
        <td>
            <c:if test="${o.isAdmin == 1}">Là Admin</c:if>
            <c:if test="${o.isAdmin == 0}">Không</c:if>
        </td>
        <td>
            <a href="loadaccount?pid=${o.id}" class=""><i class="fas fa-edit"></i></a>
            <a href="deleteaccount?pid=${o.id}" class=""><i class="fas fa-trash"></i></a>
        </td>
    </tr>
    </c:forEach>

</table>
<div class="col-12 pb-1">
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center mb-3">
            <c:if test="${tag>1}">
                <li class="page-item">
                    <a class="page-link" href="manageraccount?index=${tag - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${endP}" var="i">
                <li class="${tag == i?"page-item active":"page-item"}"><a class="page-link"
                                                                          href="manageraccount?index=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${tag<endP}">
                <li class="page-item">
                    <a class="page-link" href="manageraccount?index=${tag + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>