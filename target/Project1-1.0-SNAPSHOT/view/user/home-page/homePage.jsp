<%-- 
    Document   : homePage
    Created on : Oct 7, 2023, 4:12:11 AM
    Author     : TAMDUC
--%>
<jsp:include page="../../common/import.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đặt lịch khám bệnh</title>

        <!-- Bootstrap CDN -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />

        <!-- CSS stylesheet -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />

        <!-- Font Awesome -->
        <script src="https://kit.fontawesome.com/65d7426ab6.js" crossorigin="anonymous"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

    </head>

    <body>

        <!-- Navigation Bar -->
        <jsp:include page="../../common/user/navigationBar.jsp"></jsp:include>
        <!-- Header -->
        <jsp:include page="../../common/user/header.jsp"></jsp:include>

        <!-- Product -->
        <jsp:include page="../../common/user/doctor.jsp"></jsp:include>
        <!-- pagination -->
        <jsp:include page="../../common/user/pagination.jsp"></jsp:include>


        <!-- Footer -->
        <jsp:include page="../../common/user/footer.jsp"></jsp:include>



    </body>
    <!-- Bootstrap Scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>

</html>
