<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.domain"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="saveDomain" modelAttribute="domain" method="post">
              
              <!-- hidden fields -->
              <form:hidden path="idDomain"/>
              
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
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="domainname" class="control-label"> <spring:message code="label.domainName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="domainName"  placeholder="Domain Name..." />
				                   </div>
				                 </div>
		
			                  </div>
			                  
			                   <div class="row">
			                    <div class="col-md-12">
					                 <div class="form-group">
					                      <label for="domainname" class="control-label"> <spring:message code="label.about"/></label>
						                  <form:textarea  cssClass="form-control" path="others" rows="8" />
					                 </div>
					             </div>
					          </div> 
			                 
			                 <button type="submit" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
			                 
			            </div>
			    
		          </div>
		          
		          <!-- /.box -->
		        </div>	        
	 
           </form:form>
           
           
           
          <!-- List of domains -->
          <div class="col-xs-12">
     
	        <div class="box">
	            <div class="box-header">
	              <h3 class="box-title"></h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <table id="patients" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                  <th> <spring:message code="label.domainName"/></th>
	                  <th> <spring:message code="label.dateCreation"/></th>
                      <th> <spring:message code="label.about"/></th>
                      <th> <spring:message code="label.actions"/></th>
	                </tr>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listDomains!=null}">
	                           <c:forEach items="${listDomains}" var="domain">
	                             <tr>
	                                <td>${domain.domainName}</td>
	                                <td>${domain.dateCreation}</td>
	                                <td>${domain.others}</td>
	                                <td style="width:300px;">
	                                    <a href="approvementGroup?idDomain=${domain.idDomain}">
	                                       <button type="button" class="btn btn-success" data-url="approvementGroups?idDomain=${domain.idDomain}">
	                                       <spring:message code="label.groups"/></button>
	                                    </a>
	                                    <a href="domainConfig?idDomain=${domain.idDomain}">
	                                     <button type="button" class="btn btn-success" data-url="domainConfig?idDomain=${domain.idDomain}">
	                                     <spring:message code="label.settings"/></button>
	                                    </a>
				                       <a href="editDomain?idDomain=${domain.idDomain}"><button type="button" class="btn btn-primary"> <spring:message code="label.edit"/></button></a>
				                       <button type="button" class="btn btn-danger confirm-delete" data-url="deleteDomain?idDomain=${domain.idDomain}"> <spring:message code="label.delete"/></button>
				                    </td>
	                             </tr>
	                           </c:forEach>
	                       </c:when>
	                   </c:choose>
	                </tbody>
     
	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
        </div>
        <!-- /.box -->
          
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>