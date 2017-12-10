<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.users"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="saveUser" modelAttribute="user" method="post">             
	          <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">
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
				                      <label class="control-label"> <spring:message code="label.domain"/> <span class="pflicht">*</span></label>
					                  <form:select cssClass="form-control" path="domain.idDomain">
					                     <form:options items="${listDomains}" itemLabel="domainName" itemValue="idDomain"></form:options>
					                  </form:select>
				                   </div>				                 
				                 </div>
				                 
	                         </div>
	                         
			                 <div class="row">
			                 
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.firstName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="name"  placeholder="First Name..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.secondName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="prenom"  placeholder="Second Name..." />
				                   </div>
				                 </div>
		
			                  </div>
			                  
			                   <div class="row">
			                 
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.userName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="username"  placeholder="UserName Name..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.password"/> <span class="pflicht">*</span></label>
					                  <form:password  cssClass="form-control" path="password" placeholder="Password..."/>
				                   </div>
				                 </div>
		
			                  </div>
			                  
			                  <div class="row">
			                 
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.position"/> <span class="pflicht">*</span></label>
				                      <form:input  cssClass="form-control" path="position"  placeholder="position..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.roles"/> <span class="pflicht">*</span></label><br>
					                  <select name="roles" multiple>
					                    <option value="ROLE_ADMIN_DOMAIN">ROLE_ADMIN_DOMAIN </option>
					                    <option value="ROLE_ADMIN">ROLE_ADMIN </option>
					                  </select>
				                   </div>
				                 </div>
				              
		
			                  </div>
			                  
			             
			                 <button type="submit" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
			                 
			            </div>
			    
		          </div>
		          
		          <!-- /.box -->
		        </div>	        
	 
           </form:form>
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 
 
 