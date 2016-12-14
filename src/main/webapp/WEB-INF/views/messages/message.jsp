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
	  color:red;
	  margin-left:5px;
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

          <div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Read Mail</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-read-info">
                <h3>${mail.subject}</h3>
                <h5>From: ${mail.email} , ${mail.phone}
                  <span class="mailbox-read-time pull-right"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${mail.dateCreation}" /></span></h5>
              </div>
   
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
                 ${mail.messageContent}
              </div>
              <!-- /.mailbox-read-message -->
            </div>

            <div class="box-footer">
               <button type="button" class="btn btn-default confirm-delete" data-url="deleteMessage?idMessage=${mail.idMessage}"><i class="fa fa-trash-o"></i> Delete</button>
              <button type="button" class="btn btn-default"><i class="fa fa-print"></i> Print</button>
            </div>
            <!-- /.box-footer -->
          </div>
          <!-- /. box -->
        </div>
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 
 <!-- MODAL ELEMENT to delete items--> 

<%@include file="../modal.jsp" %>

  
<!-- delete MODAL -->
<script  src="<c:url value="/resources/js/deleteModal.js"/>" ></script>