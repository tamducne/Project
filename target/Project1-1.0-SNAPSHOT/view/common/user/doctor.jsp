<%-- 
    Document   : doctor
    Created on : Oct 7, 2023, 4:45:02 AM
    Author     : TAMDUC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section id="product">
    <div class="row">

        <div class="col-md-2 mb-sm-5">
            <ul class="list-group">
                <c:forEach items="${listDepartment}" var="department">
                    <li class="list-group-item">${department.name}
                    
                    </li>

                </c:forEach>
 
            </ul>
        </div>
        <!-- Product details -->
        <div class="col-md-10 product-details">
            <!-- First row -->
            <div class="row">

                <c:forEach items="${listDoctor}" var="o">
                    <!-- First product - first row -->
                    <div class="col-lg-4 mb-md-5 ">
                        <div class="card h-100">
                            <img src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." class="card-img-top">
                            <div class="card-body">
                                <div class="text-center">
                                    <h5 class="card-title">${o.name}</h5>
                                    ${o.price} $
                                </div>
                            </div>

                            <div class="card-footer  bg-transparent border-top-0">
                                <div class="text-center">
                                    <a href="#" class="btn btn-outline-dark">Book Doctor</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>


            </div>



        </div>
    </div>
</section>