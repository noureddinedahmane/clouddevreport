<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.approvementGroup"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="newApprovementGroup" modelAttribute="approvementGroup" method="post">
              
              <!-- hidden fields -->
              <form:hidden path="idApprovementGroup"/>
              
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
			                       <label class="control-label"> <spring:message code="label.domain"/> <span class="pflicht">*</span></label>
				                   <div class="form-group">
					                   <form:select path="domain.idDomain" cssClass="form-control">
										    <c:forEach items="${listDomains}" var="domain">
										        <c:choose>
										            <c:when test="${domain.idDomain == idDomain}">
										                <option value="${domain.idDomain }" selected>${domain.domainName}</option>
										            </c:when>
										            <c:otherwise>
										                <option value="${domain.idDomain }">${domain.domainName}</option>
										            </c:otherwise>
										        </c:choose> 
										    </c:forEach>
										</form:select>
									</div>
								</div>
								
							</div>
	
			                 <div class="row">
			                 
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="groupname" class="control-label"> <spring:message code="label.groupName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="label"  placeholder="Group Name..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="rolename" class="control-label"> <spring:message code="label.role"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="role"  placeholder="Role Name..." />
				                   </div>
				                 </div>
				                 
				                 
			                  </div>
			                  
			                   <div class="row">
			                   
			                    <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="Groupmail" class="control-label"> <spring:message code="label.groupMail"/></label>
					                  <form:input  cssClass="form-control" path="listEmail"  placeholder="Groupmail..." />
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