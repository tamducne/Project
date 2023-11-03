<%-- 
    Document   : dataExample
    Created on : Oct 18, 2023, 4:27:48 AM
    Author     : TAMDUC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        Data Table Example
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Action</th>

                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${listDoctor}" var="o">
                        <tr>
                            <!-- Name -->
                            <td>${o.name}</td>
                            <!-- Image -->

                            <td><img  width="100px"
                                      height="100px"
                                      src="${o.image}" 
                                      alt="..." class="card-img-top">
                            </td>
                            <!-- D -->

                            <td>${o.description}</td>
                            <!-- Price -->

                            <td>${o.price}</td>

                            <td>
                                <!--Edit-->
                                <i class="fa fa-edit fa-2x"
                                   style="color: #469408"
                                   data-toggle="modal"
                                   data-target="#editDoctorModal"
                                   onclick="editDoctorModal(
                                           ${o.id},
                                           `${o.name}`,
                                           `${o.description}`,
                                           
                                           ${o.price},
                                          
                                           `${o.image}`,
                                           ${o.departmentid})"
">
                                </i>
                                &nbsp;&nbsp;&nbsp;
                                <!--Delete-->
                                <i class="fa fa-trash fa-2x"
                                   style="color: #e70808"
                                   data-toggle="modal"
                                   data-target="#delete-modal"
                                   onclick="deleteDoctorModal(${o.id})">
                                </i>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>