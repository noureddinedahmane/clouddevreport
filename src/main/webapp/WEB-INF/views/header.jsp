<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Starter</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet"  href="<c:url value="/resources/css/style.css"/>">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" >
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet"  href="<c:url value="/resources/dist/css/AdminLTE.min.css"/>">
  <!-- datatables -->
  <link rel="stylesheet"  href="<c:url value="/resources/plugins/datatables/dataTables.bootstrap.css"/>">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
  <link rel="stylesheet"  href="<c:url value="/resources/dist/css/skins/skin-blue.min.css"/>">

  <!-- fullCalendar 2.2.5-->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fullcalendar/fullcalendar.print.css"/>" media="print">
  
  <!-- datetimepicker-->
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-datetimepicker.css" />">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="skin-blue sidebar-mini">

 <div id="msg">
     <c:choose>
    <c:when test="${message!=null}">
    
	 <div class="alert alert-${message.messageType } alert-dismissible message">
	      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
	      ${message.message}
	 </div>
	 
    </c:when>    
</c:choose>
 </div>

<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-danger" id="notification_numb"></span>
            </a>
            <ul class="dropdown-menu">
              <li>
                <!-- inner menu: contains the messages -->
                <ul class="menu" id="listNotification">
                  
                  <!-- display notifications-->
                  
                </ul>
                <!-- /.menu -->
              </li>
            </ul>
          </li>
    
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <ul class="nav navbar-nav">
             <li style="" class="dropdown">
	             <a href="../logout">
	              <i class="fa fa-sign-out"></i>
	            </a>
             </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
       <!-- 
        <div class="pull-left image">
          <img  src="<c:url value="/resources/dist/img/user2-160x160.jpg"/>" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
        -->
      </div>

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">HEADER</li>
        <!-- Optionally, you can add icons to the links -->
        
        <li class="active"><a href="account"><i class="fa fa-user"></i> <span><spring:message code="label.account"/></span></a></li>
        <li><a href="domain"><i class="fa fa-globe"></i> <span><spring:message code="label.domains"/></span></a></li>          
        <li class="treeview">
              <a href="#">
                <i class="fa fa-user-plus"></i>
                <span><spring:message code="label.users"/></span>
              </a>
              <ul class="treeview-menu" style="display: none;">
                <li><a href="user"><i class="fa fa-circle-o"></i> <span><spring:message code="label.newUser"/></span></a></li> 
                <li><a href="listUsers"><i class="fa fa-circle-o"></i> <span><spring:message code="label.listUsers"/></span></a></li> 
              </ul>
          </li>   
          <li class="treeview">
              <a href="#">
                <i class="fa fa-users"></i>
                <span><spring:message code="label.groups"/></span>
              </a>
              <ul class="treeview-menu" style="display: none;">
                <li><a href="approvementGroup"><i class="fa fa-circle-o"></i> <span><spring:message code="label.newGroup"/></span></a></li> 
                <li><a href="listGroups"><i class="fa fa-circle-o"></i> <span><spring:message code="label.listGroups"/></span></a></li> 
              </ul>
          </li>  
           <li class="treeview">
              <a href="#">
                <i class="fa fa-warning"></i>
                <span><spring:message code="label.deviations"/></span>
              </a>
              <ul class="treeview-menu" style="display: none;">
                <li><a href="deviation"><i class="fa fa-circle-o"></i> <span><spring:message code="label.newDeviation"/></span></a></li> 
                <li><a href="deviations"><i class="fa fa-circle-o"></i> <span><spring:message code="label.listDeviations"/></span></a></li> 
              </ul>
          </li> 
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>