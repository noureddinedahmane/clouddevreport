<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.domainSettings"/> : ${domain.domainName}
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="saveDomainConfig" modelAttribute="domainConfig" method="post">
              
              <!-- hidden fields -->
              <input type="hidden" name="idDomain" value="${domain.idDomain}">
              <form:hidden path="idValidation"/>
              
	          <div class="col-md-12">
		         
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">
		                <spring:message code="label.requiredFields"/>
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
			                      <label for="domainname" class="control-label"> <spring:message code="label.deviationRefPrefix"/></label>
				                  <form:input  cssClass="form-control" path="deviationRefPrefix"  placeholder="Deviation Prefix..." />
			                   </div>
			                 </div>  
			                 <br>
			                 
			                 </div>
			                 
			                 <div class="row">
			                 
			                  <div class="col-md-4">
			                  
				                  <form:checkbox  path="deviationRef" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.deviationRef"/></label>
				                 
				                  <br>
			                      <form:checkbox  path="deviationRiskCategory" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.deviationRiskCategory"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="requestedBy" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.requestedBy"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="dateCreation" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.dateCreation"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="signature" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.signature"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="position" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.position"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="deviationType" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.deviationType"/></label>
			              		                  
			                  
			                 </div>
			                 
			                 <div class="col-md-4">
			                      
			                      <form:checkbox  path="sollZustand" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.sollZustand"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="istZustand" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.istZustand"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="startDatePeriod" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.startDatePeriod"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="endDatePeriod" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.endDatePeriod"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="product" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.product"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="anlage" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.anlage"/></label>
			                      
			                      <br>
			                      <form:checkbox  path="barcode" />
			                      <label for="domainname" class="control-label"> <spring:message code="label.barcode"/></label>
			                 </div>
			                               
			                </div>
			                            
			                
		          </div>
		          
		          <div class="box-footer">
                      <button type="submit" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
                  </div>
		          
		          <!-- /.box -->
		        </div>	     
		      
		      </div>   
	 
           </form:form>

        
       </div><!-- ./Main Row -->
       
       
       <div class="row">
       
         <form:form action="saveDeviationType" modelAttribute="deviationType" method="post">
         
         <!-- hidden fields -->
           <input type="hidden" name="idDomain" value="${domain.idDomain}">
           <form:hidden path="idDeviationType"/>
         
           <div class="col-md-12">
                 <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">
		                <spring:message code="label.devationType"/>
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
				          <form:input  cssClass="form-control" path="deviationType"  placeholder="Deviation Type..." />
			           </div>
			           
			           <div class="col-md-2">
			            <button type="submit" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
			           </div>
			           
			          </div>    
			          
			          <div class ="row" style="margin-top:15px;">
			             <div class = "col-md-8">
			                  <table class="table table-striped">
				                  <tbody>
				                  <tr>
				                    <th> <spring:message code="label.deviationType"/></th>
				                    <th style="width: 150px"> <spring:message code="label.actions"/></th>
				                  </tr>
				                  <c:choose >
			                       <c:when test="${listDeviationTypes!=null}">
			                           <c:forEach items="${listDeviationTypes}" var="deviationType">
			                             <tr>
			                                <td>${deviationType.deviationType}</td>
			                                <td>
			                                  <a href="editDeviationType?idDeviationType=${deviationType.idDeviationType}&idDomain=${domain.idDomain}"><button type="button" class="btn btn-primary"><spring:message code="label.edit"/></button></a>
				                              <a href="deleteDeviationType?idDeviationType=${deviationType.idDeviationType}"><button type="button" class="btn btn-danger"><spring:message code="label.delete"/></button></a>
			                                </td>
			                             </tr>
			                           </c:forEach>
			                       </c:when>
			                   </c:choose>
	                   
				                 </tbody>
				                </table>                 
			             </div>
			             
			          </div> 
			                            
			                
		          </div>
		          
		          
		          <!-- /.box -->
		        </div>	     
		      
           </div>
         
         </form:form>
       </div>
       
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>