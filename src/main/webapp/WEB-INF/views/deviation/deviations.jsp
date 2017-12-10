<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.deviationList"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
       <form:form action="deviationFilter" modelAttribute="deviationFilterForm" method="post">
         <div class="col-md-12">
	         <div class="box box-info">
	            <div class="box-header with-border">
	              <h3 class="box-title"><spring:message code="label.deviationFilters"/></h3>
	              <div class="box-tools pull-right">
	                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
	              </div>
	            </div><!-- /.box-header -->
	            <div class="box-body" style="display: block;">
	            	<div class="row">
	            	   <div class="col-md-4">
		            	   <div class="form-group">
		                      <label for="devRef" class="control-label"> <spring:message code="label.deviationRef"/></label>
			                  <form:input  cssClass="form-control" path="deviationRef" id="deviationRef" />
					       </div>
	            	   </div>
	            	   <div class="col-md-4">
		            	   <div class="form-group">
		                      <label for="devRef" class="control-label"> <spring:message code="label.anlage"/></label>
			                  <form:input  cssClass="form-control" path="anlage" id="anlage"/>
					       </div>
	            	   </div>
	            	   <div class="col-md-4">
		            	   <div class="form-group">
		                      <label for="devRef" class="control-label"> <spring:message code="label.product"/></label>
			                  <form:input  cssClass="form-control" path="product" id="product"/>
					       </div>
	            	   </div>
	            	</div>
	            	
	            	<div class="row">
	            	  <div class="col-md-4">
		            	   <div class="form-group">
		                      <label for="devRef" class="control-label"> <spring:message code="label.deviationType"/></label>
			                 <form:select cssClass="form-control ${formValid.deviationType}" path="deviationType" id="deviationType">
			                    <form:option value="none"><spring:message code="label.chooseDeviationType"/></form:option>
	                       		<form:options items="${listDeviationTypes}" itemLabel="deviationType" itemValue="deviationType" />
	                       		<form:option value="others"><spring:message code="label.deviationTypeOther"/></form:option>
					         </form:select>
					       </div>
	            	   </div>
	            	   <div class="col-md-4">
		   
					       <div class="form-group">
				                   <label for="devRef" class="control-label"> <spring:message code="label.startDatePeriod"/></label>
				                  <div class="input-group">
				                    <div class="input-group-addon">
				                      <i class="fa fa-calendar"></i>
				                    </div>
				                    <form:input cssClass="form-control" path="startDate" id="devStartDate"/>
				                  </div><!-- /.input group -->
				            </div>
				            
	            	   </div>
	            	   <div class="col-md-4">
					        <div class="form-group">
				                  <label for="devRef" class="control-label"> <spring:message code="label.endDatePeriod"/></label>
				                  <div class="input-group">
				                    <div class="input-group-addon">
				                      <i class="fa fa-calendar"></i>
				                    </div>
				                    <form:input cssClass="form-control" path="endDate" id="devEndDate"/>
				                  </div><!-- /.input group -->
				            </div>
	            	   </div>
	                </div>
	                
	            </div><!-- /.box-body -->
	            <div class="box-footer" style="display: block;">
                    <button class="btn btn-primary"><spring:message code="label.filter"/></button>
                     <button type="button" class="btn btn-danger" id="resetFilter" ><spring:message code="label.resetFilter"/></button>
                </div>
	          </div>
         </div>   
         </form:form>
     
          <div class="col-xs-12">
     
	        <div class="box box-info">
	            <div class="box-header">
	              <h3 class="box-title"></h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <table id="deviations" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                  <th> <spring:message code="label.deviationRef"/></th>
	                  <th> <spring:message code="label.requestedBy"/></th>
                      <th> <spring:message code="label.position"/></th>
                      <th> <spring:message code="label.deviationType"/></th>
                      <th> <spring:message code="label.startDatePeriod"/></th>
                       <th> <spring:message code="label.endDatePeriod"/></th>
                       <th> <spring:message code="label.status"/></th>
                       <th> <spring:message code="label.actions"/></th>
	                </tr>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listDeviations!=null}">
	                           <c:forEach items="${listDeviations}" var="deviation">
	                             <tr>
	                               <td>${deviation.deviationRef }</td>
	                               <td>${deviation.requestedBy }</td>
	                               <td>${deviation.position }</td>
	                               <td>${deviation.deviationType }</td>
	                               <td> ${deviation.startDatePeriod }</td>
	                               <td>${deviation.endDatePeriod }</td>
	                               <td><div class="dev-status dev-${deviation.status}"><spring:message code="label.${deviation.status }"/></div></td>
	                               <td style="width:120px;">
	                                    <a href="editDeviation?idDeviation=${deviation.idDeviation}">
	                                       <button type="button" class="btn btn-primary">
	                                       <spring:message code="label.edit"/></button>
	                                    </a>
	                                    <a href="generatePDF?idDeviation=${deviation.idDeviation}">
	                                       <button type="button" class="btn">
	                                       <spring:message code="label.pdf"/></button>
	                                    </a>
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
 
 <script>
      $(function () {
        $('#deviations').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": true
        });
      });
</script>

 <script>

  $(function () {
      $('#devStartDate').datetimepicker({
    	  format: 'YYYY-MM-DD HH:mm:ss'
      });
      $('#devEndDate').datetimepicker({
    	  format: 'YYYY-MM-DD HH:mm:ss'
      });
  });
  
  /*  reset FIlters*/
  $(document).on("click", "#resetFilter", function(){
	  $("#deviationRef, #anlage, #product, #devEndDate, #devStartDate").val("");
	  $('#deviationType option[value="none"]').attr("selected", "selected");
  });
  
</script>