<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/inscription.css" />" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-inscription">
        <h4 class="form-signin-heading">Create your personal account</h4>
        
        <label for="inputName" class="">Your Name</label>
        <input type="text" id="inputName" class="form-control"  required="" autofocus="">
       
        <label for="inputEmailadresse" class="">Email Adresse</label>
        <input type="text" id="inputEmailadresse" class="form-control" required="">
        
        <label for="inputPassword" class="">Password</label>
        <input type="text" id="inputPassword" class="form-control" required="">
        
        <p class="insc-info">
          By clicking on "Create an account" below, you are agreeing to the <a href="">Terms of Service</a> and the <a href="">Privacy Policy</a>.
        </p>

        <button class="btn btn-lg btn-success btn-block" type="submit">Create an account</button>
      </form>

    </div> <!-- /container -->

 </body>
</html>