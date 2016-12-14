<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Edit You Page
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
              <h3 class="box-title">Your Services</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                
                <tr>
                  <th>Last Update</th>
                  <th>Service Name</th>
                  <th>Actions</th>
                </tr>
                
                <c:choose>
                     <c:when test="${clientServices!=null }">
                           <c:forEach items="${clientServices}" var="clientService">
                              <tr>
				                  <td>${clientService.dateLastUpdate}</td>
				                  <td>${clientService.serviceName}</td>
				                  <td style="width:160px;">
				                     <a href="editClientService?service=${clientService.idClientService}"><button type="button" class="btn btn-primary">Edit</button></a>
				                     <button type="button" class="btn btn-danger confirm-delete" data-url="deleteService?service=${clientService.idClientService}">Delete</button>
				                  </td>
				                </tr>
                           </c:forEach>
                     </c:when>
                     <c:otherwise>
                        <h3>No services were found</h3>
                     </c:otherwise>
                </c:choose>
                
              </tbody></table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 

<!-- MODAL ELEMENT --> 

<%@include file="../modal.jsp" %>

  
<!-- delete MODAL -->
<script  src="<c:url value="/resources/js/deleteModal.js"/>" ></script>
 