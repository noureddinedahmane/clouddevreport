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
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form  name="f" action="<c:url value='j_spring_security_check' />" Method="POST" class="form-signin">
       
        <h2 class="form-signin-heading">Please sign in</h2>
       
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="j_username" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required="">
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        
        <button class="btn btn-lg btn-success btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <script src="./Signin Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>
  

 </body>
</html>