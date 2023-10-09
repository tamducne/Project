<%-- 
    Document   : navigationBar
    Created on : Oct 7, 2023, 4:27:05 AM
    Author     : TAMDUC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section id="navigation-bar">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light ">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
                    aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"> <a href="#" class="nav-link">Home</a> </li>
                </ul>

                <nav class="navbar navbar-light bg-light pl-sm-0">
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0 ml-sm-0" type="submit">Search</button>
                    </form>
                </nav>

                <button class="btn btn-outline-primary ml-2">Login Khám Bệnh</button>
            </div>

        </nav>
    </div>
</section>
