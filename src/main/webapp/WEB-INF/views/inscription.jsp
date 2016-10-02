<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

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
      
      <f:form  modelAttribute="client" action="saveClient" method="POST" class="form-inscription">
         <h4 class="form-signin-heading">Create your personal account</h4>
         
         <c:if test="${not empty username_exist}">
               <p class="errors">${username_exist}</p>   
         </c:if>

        <label for="inputName" class="">Your Fist Name</label> <f:errors path="name" cssClass="errors"></f:errors>
        <f:input type="text" path="name" id="inputName" cssClass="form-control"  required="" autofocus=""/>
        
        <label for="inputName" class="">Your Second Name</label> <f:errors path="prenom" cssClass="errors"></f:errors>
        <f:input type="text" path="prenom" id="inputName" cssClass="form-control"  required="" autofocus=""/>
        
        <label for="inputEmailadresse" class="">Email Adresse</label> <f:errors path="username" cssClass="errors"></f:errors>
        <f:input type="text" path="username" id="inputEmailadresse" cssClass="form-control" required=""/>
        
        <label for="inputPassword" class="">Password</label> <f:errors path="password" cssClass="errors"></f:errors>
        <f:input type="password" path="password"  id="inputPassword" cssClass="form-control" required=""/>
        
        <label for="inputBirthday" class="">Birthday</label> <f:errors path="dateNaissance" cssClass="errors"></f:errors>
        <f:input type="date" path="dateNaissance"  id="inputBirthday" cssClass="form-control" required=""/>
        
        <p class="insc-info">
          By clicking on "Create an account" below, you are agreeing to the <a href="">Terms of Service</a> and the <a href="">Privacy Policy</a>.
        </p>

        <button class="btn btn-lg btn-success btn-block" type="submit">Create an account</button>
      
      </f:form>


    </div> <!-- /container -->

 </body>
</html>