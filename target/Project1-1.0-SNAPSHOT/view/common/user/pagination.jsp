<%-- 
    Document   : pagination
    Created on : Oct 7, 2023, 4:49:41 AM
    Author     : TAMDUC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="page-navigation" class="d-flex justify-content-center">
    <ul class="pagination">
        
        
        <c:if test="${pageControl.page == 1}">
           <li class="page-item disabled">
            <a class="page-link" href="home?action=pagination&page=">Previous</a>
        </li>  
        </c:if>
        <c:if test="${pageControl.page > 1}">
          <li class="page-item">
            <a class="page-link" href="home?action=pagination&page=">Previous</a>
        </li>  
        </c:if>
        
        <li class="page-item">
            <a class="page-link" href="home?action=pagination&page=${pageControl.page}">${pageControl.page}</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="home?action=pagination&page=${pageControl.page + 1}">${pageControl.page + 1}</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="home?action=pagination&page=${pageControl.page + 2}">${pageControl.page + 2}</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="home?action=pagination&page=1">Next</a>
        </li>
    </ul>
</section>
