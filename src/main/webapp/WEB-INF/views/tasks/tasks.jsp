<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
            
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          
          <h1>
              List Tasks
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
	              <table id="tasks" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                  <th>Name</th>
	                  <th>From</th>
	                  <th>To</th>
                      <th>Status</th>
                      <th>Priority</th>
                      <th>Actions</th>
	                </tr>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listTasks!=null}">
	                           <c:forEach items="${listTasks}" var="task">
	                             <tr>
	                                <td>${task.taskName}</td>
	                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${task.startDay}" /></td>
	                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${task.endDate}" /></td>
	                                <td>${task.status}</td>
	                                <td>${task.priority}</td>
	                                <td style="width:160px;">
				                       <a href="editTask?task=${task.idTask}"><button type="button" class="btn btn-primary">Edit</button></a>
				                       <button type="button" class="btn btn-danger confirm-delete" data-url="deleteTask?task=${task.idTask}">Delete</button>
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
	    $("#tasks").DataTable({

	    });
	  });
	</script>