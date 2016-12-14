<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../header.jsp" %>

<style>
   thead {
      display:none;
    }
    .table {
	    border-bottom:0px !important;
	}
	.table th, .table td {
	    border: 1px !important;
	}
	.fixed-table-container {
	    border:0px !important;
	}
	
	.fa-trash-o{
	  margin-left:5px;
	}
	
	.actions{
	   width:100px;
	}
	
</style>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
            
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          
          <h1>
              Messages
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
	              <table id="messages" class="table table-bordered table-striped">
	                <thead>
	                 <th>Name</th>
	                 <th>Message</th>
	                 <th>Date</th>
	                 <th>Actions</th>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listMessages!=null}">
	                           <c:forEach items="${listMessages}" var="message">
	                             <tr>
	                                <td><a href="#">${message.name}</a></td>
	                                <td><b>${message.subject}</b> - ${message.messageContent}</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${message.dateCreation}" /></td>
                                    <td class="actions">
                                        <a href="showMessage?message=${message.idMessage}"><button type="button" class="btn btn-primary"><i class="fa fa-eye" ></i></button></a> 
                                        <button type="button" class="btn btn-danger confirm-delete" data-url="deleteMessage?idMessage=${message.idMessage}"> <i class="fa fa-trash-o" ></i></button>                                     
                                    </td>
	                             </tr>
	                           </c:forEach>
	                       </c:when>
	                       <c:otherwise>
	                         <tr>
	                             <td>No Data was fund.</td>
	                         </tr>
	                       </c:otherwise>
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
	    $("#messages").DataTable({

	    });
	  });
	</script>