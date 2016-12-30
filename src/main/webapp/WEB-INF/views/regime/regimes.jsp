<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
            
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          
          <h1>
              List Diets
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
        <div class="col-xs-12">
     
	        <div class="box box-primary">
	            <div class="box-header">
	              <h3 class="box-title"></h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <table id="regime" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                  <th>Title</th>
	                  <th>Last update</th>
	                  <th>Patient</th>
	                  <th style="width:50px;">Activation</th>
	                  <th style="width:50px;">Actions</th>
	                </tr>
	                </thead>
	                <tbody>
	                  
	                   <c:choose>
	                     <c:when test="${listRegimes!=null}">
	                     
	                       <c:forEach items="${listRegimes}" var="regime">
	                          <tr>
	                            <td>${regime.title }</td>
	                            <td>${regime.lastUpdate }</td>
	                            <td><a href="updatePatient?patient=${regime.patient.idPatient}">${regime.patient.firstName} ${regime.patient.lastName}</a></td>
	                            <td>
		                             <c:choose>
		                               <c:when test="${regime.active}">
		                                  <i class="fa fa-fw fa-check regime_active"></i>
		                               </c:when>
		                             </c:choose>
	                             </td>
	                             <td>
	                                <a href="editRegime?idRegime=${regime.idRegime}"><i class="fa fa-edit"></i></a>
	                                <i class="fa fa-trash delete_icon confirm-delete" data-url="deleteRegime?idRegime=${regime.idRegime}"></i>
	                             </td>
	                           </tr>
	                       </c:forEach>
	 
	                     </c:when>
	                     
	                     
	                  </c:choose>
	                  
	                </tbody>
     
	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
        </div>
          <!-- /.box -->
          
          
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 
 <!-- MODAL ELEMENT to delete items--> 

<%@include file="../modal.jsp" %>

  
<!-- delete MODAL -->
<script  src="<c:url value="/resources/js/deleteModal.js"/>" ></script>

 <!-- page script -->
	<script>
	
	  $(function () {
	    $("#regime").DataTable({

	    });
	  });
	</script>