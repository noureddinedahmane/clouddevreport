<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
            
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          
          <h1>
              List Patients
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
        <div class="col-xs-12">
     
	        <div class="box">
	            <div class="box-header">
	              <h3 class="box-title"></h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <table id="patients" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                  <th>Name</th>
	                  <th>Occupation</th>
                      <th>Email</th>
                      <th>Date Registration</th>
                      <th>Actions</th>
	                </tr>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listPatients!=null}">
	                           <c:forEach items="${listPatients}" var="patient">
	                             <tr>
	                                <td>${patient.lastName} ${patient.firstName}</td>
	                                <td>${patient.occupation}</td>
	                                <td>${patient.emailAddress}</td>
	                                <td>${patient.registrayDate}</td>
	                                <td style="width:270px;">
				                       <a href="updatePatient?patient=${patient.idPatient}"><button type="button" class="btn btn-primary">Edit</button></a>
				                       <button type="button" class="btn btn-danger confirm-delete" data-url="deletePatient?patient=${patient.idPatient}">Delete</button>
				                       <a href="medicalRecord?patient=${patient.idPatient}"><button type="button" class="btn btn-primary">Medical Record</button></a>
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
	    $("#patients").DataTable({

	    });
	  });
	</script>