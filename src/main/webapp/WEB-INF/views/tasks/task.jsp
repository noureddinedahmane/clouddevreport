<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
      
      
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Task
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
        <form:form action="saveTask" modelAttribute="task" method="post">
        
             <form:hidden path="idTask"/>
             
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
			                    <div class="col-md-12">
					                 <div class="form-group">
					                      <label for="taskname" class="control-label">Task Name</label>
						                  <form:input  cssClass="form-control" path="taskName"  placeholder="Task Name..." />
					                 </div>
					             </div>
					          </div>
					           
					          <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="startdate" class="control-label">Start Date</label>
							                  <form:input type="date" cssClass="form-control" path="startDay"/>
						                 </div>
					                 </div>
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="enddate" class="control-label">End Date</label>
							                  <form:input type="date" cssClass="form-control" path="endDate"/>
						                 </div>
					                 </div>
			                  </div>
			                  
			                  <div class="row">
					                 <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="status" class="control-label">Status</label>
							                  <form:select  cssClass="form-control" path="status">
							                     <form:option value="started">Started</form:option>
							                     <form:option value="inprogress">In Progress</form:option>
							                     <form:option value="completed">Completed</form:option>
							                     <form:option value="deferred">Deferred</form:option>
							                  </form:select>
						                 </div>
					                 </div>
					                  <div class="col-md-6">
						                 <div class="form-group">
						                      <label for="priority" class="control-label">Priority</label>
							                  <form:select  cssClass="form-control" path="priority">
							                     <form:option value="high">High</form:option>
							                     <form:option value="normal">Normal</form:option>
							                     <form:option value="low">Low</form:option>
							                  </form:select>
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
			                    <div class="col-md-12">
					                 <div class="form-group">
						                  <form:textarea  cssClass="form-control" path="content" rows="8" />
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
		              <button type="submit" name="action" value="saveandnew"class="btn btn-primary pull-right">Save and new task</button>
		         </div>
		        
       
        </form:form>
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>