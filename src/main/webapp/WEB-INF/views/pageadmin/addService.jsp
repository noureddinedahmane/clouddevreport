<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        <div class="btn-group createNew">
                  <button type="button" class="btn btn-success"><spring:message code="label.createNew"/></button>
                  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                    <span class="sr-only">Toggle Dropdown</span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Note</a></li>
                    <li><a href="#">Task</a></li>
                    <li><a href="#">Patient</a></li>
                    <li><a href="#">Calendar</a></li>
                    <li><a href="#">Event</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
          </div>
          
          <h1>
              Edit You Page
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
	        <!-- Show infos for users about editing this page -->
	        <div class="col-md-12 col-xs-12 col-sm-12">

	           <div class="alert alert-info alert-dismissible">
                 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    Hier you can create a service that you provide, edit the name of you service and make a description of it. 
              </div>
	            
             </div>
        
            <form:form action="saveService" modelAttribute="clientService"  method="post">
                
                <!-- Hidden fields -->
                <form:hidden path="idClientService"/>
	            <!-- edit the name of the service -->
		       <div class="col-md-12">
		       
		           <div class="box box-info">

		              <div class="box-body">
		              
		                <div class="form-group">
		                  <label for="inputEmail3" class="col-sm-2 control-label">Sevice Name</label>
		
		                  <div class="col-sm-10">
		                    <form:input  cssClass="form-control" path="serviceName"  placeholder="Service Name..." />
		                  </div>
		                </div>
	 
		              </div>
		              <!-- /.box-body -->
	
	               </div>
	               
		       </div>
	             
		        <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">Edit your own page
		                <small></small>
		              </h3>
		              <!-- tools box -->
		              <div class="pull-right box-tools">
		                <button type="button" class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse">
		                  <i class="fa fa-minus"></i></button>
		              </div>
		              <!-- /. tools -->
		            </div>
		            <!-- /.box-header -->
		            
			            <div class="box-body pad">
			                    <form:textarea id="editor1" path="serviceDescription" rows="10" cols="80" />
			                             
			            </div>
			            <div class="box-footer">
		                   <button type="submit" class="btn btn-primary pull-right">Save</button>
		                </div>
		          </div>
		          <!-- /.box -->
		        </div>
		        <!-- /.col-->
	        
	        </form:form>
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 
  <script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1');
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
  });
</script>
 