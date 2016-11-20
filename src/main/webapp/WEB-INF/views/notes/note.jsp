<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
    <!-- Content header-->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
        <p>${userName}</p>
      </ol>
    </section>
    
    <!--  Main Content -->
    <section class="content">
       
       <!-- Main Row -->
       <div class="row">
       
          <!-- Left col -->
          <section class="col-lg-4 connectedSortable ui-sortable note-section">
          
	         <div class="box box-primary note-box">
	           <div class="box-header with-border">
	             <h3 class="box-title"><p><spring:message code="label.listNotes"/></p></h3>
	
	             <div class="box-tools pull-right">
	               <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	               </button>
	             </div>
	             <!-- /.box-tools -->
	           </div>
	           <!-- /.box-header -->
	           
	           <div class="box-body note-list" style="display: block;">
	               <ul>
	                   <li>
		                     <div class="tools">
	                             <i class="fa fa-edit"></i>
	                             <i class="fa fa-trash-o"></i>
	                         </div>
	                         <div class="note-title">
	                             <h3>This is a Note Title...</h3>
	                         </div>
	                         <div class="note-body">
	                           <p>This is the note body, hier you will insert the text of the note.
	                             But if the text is too long you will have to show just a minimal number of words
	                           </p>
	                         </div>
	                   </li>
	                   <li>
		                     <div class="tools">
	                             <i class="fa fa-edit"></i>
	                             <i class="fa fa-trash-o"></i>
	                         </div>
	                         <div class="note-title">
	                             <h3>This is a Note Title...</h3>
	                         </div>
	                         <div class="note-body">
	                           <p>This is the note body, hier you will insert the text of the note.
	                             But if the text is too long you will have to show just a minimal number of words
	                           </p>
	                         </div>
	                   </li>
	                   <li>
		                     <div class="tools">
	                             <i class="fa fa-edit"></i>
	                             <i class="fa fa-trash-o"></i>
	                         </div>
	                         <div class="note-title">
	                             <h3>This is a Note Title...</h3>
	                         </div>
	                         <div class="note-body">
	                           <p>This is the note body, hier you will insert the text of the note.
	                             But if the text is too long you will have to show just a minimal number of words
	                           </p>
	                         </div>
	                   </li>
	                    <li>
		                     <div class="tools">
	                             <i class="fa fa-edit"></i>
	                             <i class="fa fa-trash-o"></i>
	                         </div>
	                         <div class="note-title">
	                             <h3>This is a Note Title...</h3>
	                         </div>
	                         <div class="note-body">
	                           <p>This is the note body, hier you will insert the text of the note.
	                             But if the text is too long you will have to show just a minimal number of words
	                           </p>
	                         </div>
	                   </li>
	                    <li>
		                     <div class="tools">
	                             <i class="fa fa-edit"></i>
	                             <i class="fa fa-trash-o"></i>
	                         </div>
	                         <div class="note-title">
	                             <h3>This is a Note Title...</h3>
	                         </div>
	                         <div class="note-body">
	                           <p>This is the note body, hier you will insert the text of the note.
	                             But if the text is too long you will have to show just a minimal number of words
	                           </p>
	                         </div>
	                   </li>
	               </ul>
	           </div>
	           
	           <!-- /.box-body -->
	         </div>
          
         </section>
          
          <!-- Right col -->
          <section class="col-lg-8 connectedSortable ui-sortable note-section">

		          <div class="box box-primary note-box">
		            <div class="box-header">
		              <i class="fa fa-fw fa-sticky-note"></i>
		
		              <h3 class="box-title">Edit Your Note</h3>
		              <!-- tools box -->
		              <div class="box-tools pull-right">
	                      <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	                       </button>
	                   </div>
		              <!-- /. tools -->
		            </div>
		            <div class="box-body">
		              <form action="#" method="post">
		                <div class="form-group">
		                  <input type="text" class="form-control note-title-input" name="subject" placeholder="Enter You Note Title">
		                </div>
		                <div>
		                  <textarea class="textarea" placeholder="Message" style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
		                </div>
		              </form>
		            </div>
		            <div class="box-footer clearfix">
		              <button type="button" class="pull-right btn btn-default" id="sendEmail">Send
		                <i class="fa fa-arrow-circle-right"></i></button>
		            </div>
		           </div>
		            
          </section>
          
       </div>
       
    </section>
  
  </div>
  

<%@include file="../footer.jsp" %>
