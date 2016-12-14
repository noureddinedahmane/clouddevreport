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