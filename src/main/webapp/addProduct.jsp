<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Thêm sản phẩm</title>
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
                <h5 class="font-weight-semi-bold m-0">Thêm sản phẩm</h5>
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
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">

        </div>
    </div>
</div>
<div id="form-add" style="margin: 0 200px 0 200px">
    <form action="add" method="post" enctype="multipart/form-data">
        <div class="col-md-12 form-group">
            <label>Tên sản phẩm</label>
            <input name="name" class="form-control" type="text" placeholder="">
        </div>
        <div class="col-md-12 form-group">
            <%--                <label>Hình ảnh</label>--%>
            <%--                <input name="image" class="form-control" type="text" placeholder="">--%>
            <label>Hình ảnh</label>
            <input name="imageFile" class="form-control" type="file">
        </div>
        <div class="col-md-12 form-group">
            <label>Giá</label>
            <input name="price" class="form-control" type="text" placeholder="">
        </div>
        <div class="col-md-12 form-group">
            <label>Loại sản phẩm</label>
            <input name="title" class="form-control" type="text" placeholder="">
            <p style="font-weight: bold">*Chú ý: <br>
                nu: quần áo nữ <br>
                nam: quần áo nam<br>
                te: quần áo trẻ em<br>
                g: giày<br>
                pk: phụ kiện<br>
                tui: túi xách<br></p>
        </div>
        <div class="col-md-12 form-group">
            <label>Mô tả sản phẩm</label>
            <input name="description" class="form-control" type="text" placeholder="">
        </div>
        <input class="col-md-3 btn btn-primary btn-block border-0 py-3" style="float: right" type="submit"
               value="Thêm sản phẩm"><br>
        <a href="managerproduct" id="back"><i class="fas fa-angle-left"></i> Trở về</a>
    </form>
</div>
</div>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>