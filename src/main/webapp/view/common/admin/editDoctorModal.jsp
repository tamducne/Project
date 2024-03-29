<%-- 
    Document   : editDoctorModal
    Created on : Oct 23, 2023, 12:30:41 AM
    Author     : TAMDUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="editDoctorModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editDoctorModalLabel">Edit Doctor</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editDoctorForm" action="dashboard?action=edit" method="POST" enctype="multipart/form-data">
                    <!--id-->
                    <div class="form-group" style="display: none">
                        <input type="text" class="form-control" id="idEditInput" name="id">
                    </div>
                    <!--Name-->
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="nameEditInput" name="name">
                        <div id="nameEditError" class="error"></div>
                    </div>
                    
                    <!--Price-->
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="text" class="form-control" id="priceEditInput" name="price">
                        <div id="priceEditError" class="error"></div>
                    </div>
                    
                    <!--Category-->
                    <div class="form-group">
                        <label for="department">Department: </label>
                        <div class="input-group">
                            <select class="custom-select" id="departmentEditInput" name="department">
                                <c:forEach items="${listDepartment}" var="department">
                                    <option value="${department.id}">${department.name}</option>
                                </c:forEach>
                            </select>
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button">Department</button>
                            </div>
                        </div>
                    </div>
                    <!--Image-->
                    <div class="form-group">
                        <label for="image">Image: </label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Upload</span>
                            </div>
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="imageEdit" name="image"
                                       onchange="displayImage2(this)">
                                <label class="custom-file-label">Choose file</label>
                            </div>
                        </div>
                        <img id="previewImage2" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="Preview"
                             style="display: none; max-width: 300px; max-height: 300px;">
                        <input type="hidden" id="currentImage" name="currentImage" value="">
                    </div>
                    <!--Description-->
                    <div class="form-group">
                        <label for="descriptionEditInput">Description:</label>
                        <textarea class="form-control" id="descriptionEdit" name="description"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-primary" form="editDoctorForm"
                        onclick="validateForm2()">Update</button>
            </div>
        </div>
    </div>
</div>

<script>
    function validateForm2() {
        let name = $('#nameEditInput').val();
        
        let price = $('#priceEditInput').val();
        

        //xoá thông báo lỗi hiện tại
        $('.error').html('');

        if (name === '') {
            $('#nameEditError').html('Tên sách không được để trống');
        }

        

        if (price === '') {
            $('#priceEditError').html('Giá của quyển sách không được để trống');
        } else if (!$.isNumeric(price) || parseFloat(price) < 0) {
            $('#priceEditError').html('Giá của quyển sách phải là số và không được nhỏ hơn 0');
        }

       

        // Kiểm tra nếu không có lỗi thì submit form
        let error = '';
        $('.error').each(function () {
            error += $(this).html();
        });
        if (error === '') {
            $('#editDoctorForm').submit();
        } else {
            event.preventDefault();
        }
    }

    function displayImage2(input) {
        var previewImage = document.getElementById("previewImage2");
        var file = input.files[0];
        var reader = new FileReader();

        reader.onload = function (e) {
            previewImage.src = e.target.result;
            previewImage.style.display = "block";
        }

        reader.readAsDataURL(file);
    }

    function editDoctorModal(id, name, description, price, image, departmentid) {
        $('#idEditInput').val(id);
        $('#nameEditInput').val(name);
        
        $('#priceEditInput').val(price);
        
        $('#departmentEditInput').val(departmentid);
        $('#descriptionEdit').val(description);
        $('#previewImage2').attr('src', image);
        $('#previewImage2').css('display', 'block');
        $('#currentImage').val(image);
    }

</script>
