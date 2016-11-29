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
                     This Page should provide The Patients with Informations about you, so take your time to edit it very well,
		             we advise you go through all peaces of informations the patients looking for, good luck!
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
	            <form action="updateEditAbout" method="post">
		            <div class="box-body pad">
		                    <textarea id="editor1" name="about" rows="10" cols="80">
		                             ${about}
		                    </textarea>
		            </div>
		            <div class="box-footer">
	                   <button type="submit" class="btn btn-primary pull-right">Save</button>
	                </div>
                </form>
	          </div>
	          <!-- /.box -->
	        </div>
	        <!-- /.col-->
        
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