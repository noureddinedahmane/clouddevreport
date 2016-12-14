<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Profile
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="updateProfile" modelAttribute="profile" method="post">
              
              <!-- hidden fields -->
              <form:hidden path="idProfile"/>
              
	          <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">Your First and Last Name
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
	
			                 <div class="row">
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="firstname" class="control-label">First Name</label>
					                  <form:input  cssClass="form-control" path="clientFirstName"  placeholder="First Name..." />
				                   </div>
				                 </div>
				                 
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="lastname" class="control-label">Last Name</label>
					                    <form:input  cssClass="form-control" path="clientLatName"  placeholder="First Name..." />
				                    </div>
				                 </div>
				                 
			                  </div>
			                  
			                  <div class="row">
			                    <div class="col-md-6">
			                      <div class="form-group">
				                      <label for="clienttitle" class="control-label">Title</label>
					                   <form:input  cssClass="form-control" path="clientTitle"  placeholder="Your title..." />
				                  </div>
			                    </div>
			                  </div>
			                 
			            </div>
		          </div>
		          <!-- /.box -->
		        </div>
		        <!-- /.col-->
		        
		        <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">Contact
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
	
			                 <div class="row">
				                <div class="col-md-6">
				                  <div class="form-group">
				                      <label for="inputEmail3" class="control-label">Email</label>
					                  <form:input  cssClass="form-control" path="clientEmail"  placeholder="Email..." />
				                   </div>
				                </div>
				                 
				                 <div class="col-md-6">
				                     <div class="form-group">
				                       <label for="phonr" class="control-label">Phone</label>
					                    <form:input  cssClass="form-control" path="clientPhone"  placeholder="Phone..." />
				                     </div>
				                 </div>
				                
				              </div>
				              
				              <div class="row">
				               <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="mobile" class="control-label">Mobile</label>
					                  <form:input  cssClass="form-control" path="clientMobilePhone"  placeholder="Your title..." />
				                   </div>
				                </div>
				                
				                <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="fqcebook" class="control-label">Facebook</label>
					                  <form:input  cssClass="form-control" path="clientFaceBookPage"  placeholder="Facebook..." />
				                   </div>
				                 </div>
				                 
				               </div>
				               
				               <div class="row">
				                 <div class="col-md-6">
				                  <div class="form-group">
				                      <label for="twitter" class="control-label">Facebook</label>
					                  <form:input  cssClass="form-control" path="clientTwitterPage"  placeholder="Twitter..." />
				                   </div>
				                </div>
				                
				               </div>
				                 
			            </div>
		          </div>
		          <!-- /.box -->
		        </div>
		        <!-- /.col-->
		        
		        <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">Your Adress
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
	
			                 <div class="row">
			                    <div class="col-md-6">
				                  <div class="form-group">
				                      <label for="Country" class="control-label">Country</label>
					                  <form:input  cssClass="form-control" path="clientContry"  placeholder="Country..." />
				                  </div>
				                </div>
				                
				                <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="city" class="control-label">Phone</label>
			  	                      <form:input  cssClass="form-control" path="clientCity"  placeholder="City..." />
				                   </div>
				                 </div>
				                 
				              </div>
				              
				              <div class="row">
				                <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="street" class="control-label">Street</label>
					                  <form:input  cssClass="form-control" path="clientSreet"  placeholder="Street..." />
				                   </div>
                                 </div>
				              </div>
				                 
			            </div>
		          </div>
		          <!-- /.box -->
		        </div>
		        <!-- /.col-->
		        
		        <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">Description
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
	
			                 <div class="row">
				                <div class="form-group">
					                  <div class="col-sm-12">
					                    <form:textarea path="clientDescription" cssClass="form-control" rows="4"/>
					                  </div>
				                 </div>

				              </div>
				                 
			            </div>
		          </div>
		          <!-- /.box -->
		        </div>
		        <!-- /.col-->
		        
		         <div class="col-md-12">
		                  <button type="submit" class="btn btn-primary pull-right">Update</button>
		          </div>
		        
	 
           </form:form>
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>