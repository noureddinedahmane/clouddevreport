<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
      
      
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Patient
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
        <form:form action="editPatient" modelAttribute="patient" method="post">
        
             <form:hidden path="idPatient"/>
             
             <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">Informations
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
						                  <form:input  cssClass="form-control" path="firstName"  placeholder="First Name..." />
					                 </div>
					             </div>
					             <div class="col-md-6">
					                 <div class="form-group">
					                      <label for="lastname" class="control-label">Last Name</label>
						                  <form:input  cssClass="form-control" path="lastName"  placeholder="Last Name..." />
					                 </div>
					              </div>
					          </div>
					           
					          <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="gender" class="control-label">Gender</label>
							                  <form:select  cssClass="form-control" path="gender">
							                     <form:option value="Female">Female</form:option>
							                     <form:option value="Male">Male</form:option>
							                  </form:select>
						                 </div>
					                 </div>
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="birthday" class="control-label">Birthday</label>
							                  <form:input type="date" cssClass="form-control" path="birthDay"  placeholder="Birthday..." />
						                 </div>
					                 </div>
			                  </div>
			                  
			                  <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="occupation" class="control-label">Occupation</label>
							                  <form:input  cssClass="form-control" path="occupation"  placeholder="Occupation..." />
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
					                      <label for="cellphone" class="control-label">Cell Phone</label>
						                  <form:input  cssClass="form-control" path="cellPhone"  placeholder="Cell Phone..." />
					                 </div>
					             </div>
					             <div class="col-md-6">
					                 <div class="form-group">
					                      <label for="homePhone" class="control-label">Home Phone</label>
						                  <form:input  cssClass="form-control" path="homePhone"  placeholder="Home Phone..." />
					                 </div>
					              </div>
					          </div>
					           
					          <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="workPhone" class="control-label">Work Phone</label>
							                  <form:input  cssClass="form-control" path="workPhone"  placeholder="Work Phone..." />
						                 </div>
					                 </div>
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="emailAdress" class="control-label">Email</label>
							                  <form:input cssClass="form-control" path="emailAddress"  placeholder="Email..." />
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
		              <h3 class="box-title">Address
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
					                      <label for="state" class="control-label">State</label>
						                  <form:input  cssClass="form-control" path="state"  placeholder="State..." />
					                 </div>
					             </div>
					             <div class="col-md-6">
					                 <div class="form-group">
					                      <label for="City" class="control-label">City</label>
						                  <form:input  cssClass="form-control" path="city"  placeholder="City..." />
					                 </div>
					              </div>
					          </div>
					           
					          <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="street" class="control-label">Street</label>
							                  <form:input  cssClass="form-control" path="street"  placeholder="Street..." />
						                 </div>
					                 </div>
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="zipcode" class="control-label">Zip Code</label>
							                  <form:input cssClass="form-control" path="zipCode"  placeholder="Zip Code..." />
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
		              <h3 class="box-title">Others
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
					                      <label for="individual responsible for charge name" class="control-label">Individual Responsible for Charge Name</label>
						                  <form:input  cssClass="form-control" path="irfchName"  placeholder="Name..." />
					                 </div>
					             </div>
					             <div class="col-md-6">
					                 <div class="form-group">
					                      <label for="individual responsible for charge name" class="control-label">Individual Responsible for Charge Phone</label>
						                  <form:input  cssClass="form-control" path="irfchPhone"  placeholder="Phone..." />
					                 </div>
					              </div>
					          </div>
					           
					          <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="Reffered by" class="control-label">Reffered By</label>
							                  <form:input  cssClass="form-control" path="referredBy"  placeholder="Reffered By..." />
						                 </div>
					                 </div>
			                  </div>
			                  
			                  <div class="row">
			                      <div class="col-md-12">
						                 <div class="form-group">
						                      <label for="refferal Reason" class="control-label">Refferal Reasons</label>
							                  <form:textarea cssClass="form-control" path="referralReason"  rows="5" placeholder="Refferal Reasons..." />
						                 </div>
					               </div>
			                  </div>
			                 
			            </div>
		          </div>
		          <!-- /.box -->
		        </div>
		        <!-- /.col-->
		        
		        
		        
		        
		         <div class="col-md-12">
		              <button type="submit" name="action" value="save" class="btn btn-primary pull-right" style="margin-left:3px;">Save</button>
		              <button type="submit" name="action" value="saveandm_records"class="btn btn-primary pull-right">Save and edit medical records</button>
		         </div>
		        
       
        </form:form>
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>